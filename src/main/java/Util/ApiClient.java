package Util;
import Model.Credential;

import Model.Drug;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import Model.ResponseBody.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class ApiClient {
    private static final String endPointUrl = "http://localhost:8080";
    private String role;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public AuthResponse getToken(String login, String password) throws IOException, InterruptedException {
        Credential credential = new Credential();
        credential.setLogin(login).setPassword(password);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(credential);
        Map<String,String> headers= new HashMap<>();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/json");
        String response = sendRequest("POST", endPointUrl + "/token", requestBody, headers);
        return objectMapper.readValue(response, AuthResponse.class);
    }


    public Report getRapportVisite(Long id, String token) throws IOException, InterruptedException {
        String url = endPointUrl + "/" + role + "/report/" + id.toString();
        String response = sendRequest("GET", url,null, getHeaders(token));
        return objectMapper.readValue(response, Report.class);
    }

    public Collection<Report> getRapportVisites(String token) throws IOException, InterruptedException {
        String url = endPointUrl + "/" + role + "/reports";
        String response = sendRequest("GET", url,null, getHeaders(token));
        return Arrays.asList(objectMapper.readValue(response, Report[].class));
    }

    public Report postReport(ReportBody reportBody, String token) {
        String url = endPointUrl + "/"+ role + "/report";
        String response = null;
        try {
            response = sendRequest("POST", url, objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(reportBody), getHeaders(token));
            return objectMapper.readValue(response, Report.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Report();
        }
    }

    public Report patchReport(ReportBody reportBody,Long id, String token){
        String url = endPointUrl + "/"+ role + "/report/" + id;
        String response;
        try {
            response = sendRequest("PATCH", url, objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(reportBody), getHeaders(token));
            return objectMapper.readValue(response, Report.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new Report();
        }
    }

    public Report[] deleteReport(Long id, String token) throws IOException {
        String url = endPointUrl + "/" + role + "/report/" + id.toString();
        String response = sendRequest("DELETE", url,null, getHeaders(token));
        return objectMapper.readValue(response, Report[].class);
    }

    public Collection<Drug> getDrugs(String token) throws IOException {
        String url = endPointUrl + "/"+ role + "/drugs";
        String response = sendRequest("GET", url, null, getHeaders(token));
        return Arrays.asList(objectMapper.readValue(response, Drug[].class));
    }

    public Collection<Pratitionner> getPratitionners(String token) throws IOException {
        String url = endPointUrl + "/" + role + "/pratitionners";
        String response = sendRequest("GET", url, null, getHeaders(token));
        return Arrays.asList(objectMapper.readValue(response, Pratitionner[].class));
    }

    public static void main(String[] args) throws IOException {
    }

    static public String sendRequest(String method, String url, String content, Map<String, String> headers) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest request = null;
        switch (method){
            case "GET":
                request = new HttpGet(url);
                break;
            case "POST":
                request = new HttpPost(url);
                ((HttpPost) request).setEntity(new StringEntity(content));
                break;
            case "PATCH":
                request = new HttpPatch(url);
                ((HttpPatch) request).setEntity(new StringEntity(content));
                break;
            case "DELETE":
                request = new HttpDelete(url);
                break;
        }
        if (request != null)
        {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                request.setHeader(header.getKey(), header.getValue());
            }
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }
        else{
            return "";
        }
    }

    private HashMap<String, String> getHeaders(String token){
        HashMap<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.put(HttpHeaders.AUTHORIZATION, token);
        return headers;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
