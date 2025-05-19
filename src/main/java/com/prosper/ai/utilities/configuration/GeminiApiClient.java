package com.prosper.ai.utilities.configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GeminiApiClient {

    private static final String API_BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent";

    public String generateContent(String apiKey, String prompt, byte[] fileData, String mimeType) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String base64ImageData = Base64.getEncoder().encodeToString(fileData);

        String requestBody = String.format(
                "{\"contents\": [{\"parts\":[{\"text\": \"%s\"}, {\"inline_data\": {\"mime_type\":\"%s\", \"data\":\"%s\"}}]}]}",
                prompt, mimeType, base64ImageData
        );

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + "?key=" + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body());
        JsonNode textNode = rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text");
        if (textNode != null && textNode.isTextual()) {
            return textNode.asText();
        }
        return "Error extracting text from response.";
    }

    // Overload for text-only content generation
    public String generateContent(String apiKey, String prompt) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String requestBody = String.format("{\"contents\": [{\"parts\":[{\"text\": \"%s\"}]}]}", prompt);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + "?key=" + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body());
        JsonNode textNode = rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text");
        if (textNode != null && textNode.isTextual()) {
            return textNode.asText();
        }
        return "Error extracting text from response.";
    }


}
