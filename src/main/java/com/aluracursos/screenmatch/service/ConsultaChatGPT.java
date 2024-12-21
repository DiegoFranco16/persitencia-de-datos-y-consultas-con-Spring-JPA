package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    private static final String API_KEY = System.getenv("API_CHATGPT");

    public static String obtenerTraduccion(String texto) {

        OpenAiService service = new OpenAiService(API_KEY);

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(200)
                .temperature(0.7)
                .build();
        try {
            var respuesta = service.createCompletion(requisicion);
            return respuesta.getChoices().get(0).getText().trim();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }
}
