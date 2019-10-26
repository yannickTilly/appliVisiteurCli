package Util;
import Model.Credential;

import Model.RapportVisite;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
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

    public String getToken(String login, String password) throws IOException, InterruptedException {
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
        return response.body();
    }

    public RapportVisite getRapportVisite(Long id, String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/rapportVisite/" + id.toString()))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(), RapportVisite.class);
    }

    public Collection<RapportVisite> getRapportVisites(String token) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .GET()
                .uri(URI.create(endPointUrl + "/rapportVisites"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return Arrays.asList(objectMapper.readValue(response.body(), RapportVisite[].class));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ApiClient apiClient = new ApiClient();
    }
}
