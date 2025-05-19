package com.prosper.ai.utilities.controller;

import com.prosper.ai.utilities.configuration.GeminiApiClient;
import com.prosper.ai.utilities.constants.DocumentCategory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/gemini-pro-vision")
public class GeminiProVisionController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final GeminiApiClient geminiApiClient;
    private final String PROSPER_QUERY = "The query is from a FinTech company Prosper to verify the User.";

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public GeminiProVisionController(GeminiApiClient geminiApiClient) {
        this.geminiApiClient = geminiApiClient;
    }

    @PostMapping(path = "/document")
    public String extractDocument(@RequestParam("file") MultipartFile file,
                       @RequestParam("category") DocumentCategory category,
                       @RequestParam(value = "query", required = false) String customQuery) throws IOException, InterruptedException {

        String query = PROSPER_QUERY + category.getCategoryRelatedQuery() + customQuery;

        // Use the modified GeminiApiClient for multimodal input
        String rawResponse = geminiApiClient.generateContent(geminiApiKey, query, file.getBytes(), file.getContentType());
        return rawResponse;
    }

    @PostMapping(path = "/generate-text")
    public String generateText(@RequestParam("prompt") String prompt) throws IOException, InterruptedException {
        String rawResponse = geminiApiClient.generateContent(geminiApiKey, prompt);
        return rawResponse;
    }
}
