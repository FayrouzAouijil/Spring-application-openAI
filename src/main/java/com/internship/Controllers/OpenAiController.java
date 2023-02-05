package com.internship.Controllers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/completion")
public class OpenAiController {

    @PostMapping
    public String generateCompletion(@RequestBody Map<String, Object> requestData) {
        // Send the prompt data to OpenAI API for completion
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiKey = "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";
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestData, headers);

        String endpoint = "https://api.openai.com/v1/completions";
        ResponseEntity<String> response = restTemplate.postForEntity(endpoint, request, String.class);

        // Parse the response body into a Java object
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode;
        try {
            rootNode = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // Extract the text value from the response
        JsonNode choicesNode = rootNode.path("choices");
        JsonNode textNode = choicesNode.get(0).path("text");
        String text = textNode.asText();

        // Return the extracted text value
        return text;
    }
}

