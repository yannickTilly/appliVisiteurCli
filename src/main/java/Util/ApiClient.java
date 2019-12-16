package Util;
import Model.Credential;

import Model.Drug;
import Model.Execption.ServerError;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import Model.ResponseBody.AuthResponse;
import View.Structure.Prationner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collection;


public class ApiClient {
    private static final String endPointUrl = "http://localhost:8080";

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public AuthResponse getToken(String login, String password) throws IOException, InterruptedException {
        Credential credential = new Credential();
        credential.setLogin(login).setPassword(password);
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(credential);

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .uri(URI.create(endPointUrl + "/token"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), AuthResponse.class);
    }

    public Report getRapportVisite(Long id, String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/visitor/report/" + id.toString()))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), Report.class);
    }

    public Collection<Report> getRapportVisites(String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/visitor/reports"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return Arrays.asList(objectMapper.readValue(response.body(), Report[].class));
    }

    public Report postReport(ReportBody reportBody, String token) throws ServerError {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .header("Authorization", token)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(reportBody)))
                    .uri(URI.create(endPointUrl + "/visitor/report"))
                    .build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), Report.class);
        } catch (IOException | InterruptedException e) {
            throw new ServerError(e.toString());
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ApiClient apiClient = new ApiClient();
    }

    public Collection<Drug> getDrugs(String token) throws ServerError {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/visitor/drugs"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.asList(objectMapper.readValue(response.body(), Drug[].class));
        } catch (IOException | InterruptedException e) {
            throw new ServerError(e.toString());
        }
    }

    public Collection<Pratitionner> getPratitionners(String token) throws ServerError {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/visitor/pratitionners"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.asList(objectMapper.readValue(response.body(), Pratitionner[].class));
        } catch (IOException | InterruptedException e) {
            throw new ServerError(e.toString());
        }
    }
}
