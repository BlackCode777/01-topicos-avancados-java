package com.blackcode777.java11.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/**
 * Demonstra o uso da HTTP Client API introduzida no Java 11
 */
public class HttpClientExamples {
    
    public static void demonstrateHttpClient() {
        System.out.println("--- HTTP Client API ---");
        
        // Exemplo 1: Cliente HTTP básico
        demonstrateBasicHttpClient();
        
        // Exemplo 2: Cliente HTTP assíncrono
        demonstrateAsyncHttpClient();
        
        // Exemplo 3: Cliente HTTP com configurações
        demonstrateConfiguredHttpClient();
    }
    
    private static void demonstrateBasicHttpClient() {
        System.out.println("\n--- Cliente HTTP Básico ---");
        
        try {
            // Criar cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            
            // Criar requisição
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .build();
            
            // Enviar requisição e obter resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Status: " + response.statusCode());
            System.out.println("Headers: " + response.headers().map());
            System.out.println("Body (primeiros 200 chars): " + 
                              response.body().substring(0, Math.min(200, response.body().length())) + "...");
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro na requisição HTTP: " + e.getMessage());
        }
    }
    
    private static void demonstrateAsyncHttpClient() {
        System.out.println("\n--- Cliente HTTP Assíncrono ---");
        
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/delay/1"))
                .build();
            
            // Requisição assíncrona
            CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, 
                HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Requisição enviada, aguardando resposta...");
            
            // Processar resposta quando disponível
            futureResponse.thenAccept(response -> {
                System.out.println("Resposta assíncrona recebida!");
                System.out.println("Status: " + response.statusCode());
                System.out.println("Primeiro header: " + response.headers().firstValue("content-type").orElse("N/A"));
            }).join(); // Aguardar conclusão para demonstração
            
        } catch (Exception e) {
            System.err.println("Erro na requisição HTTP assíncrona: " + e.getMessage());
        }
    }
    
    private static void demonstrateConfiguredHttpClient() {
        System.out.println("\n--- Cliente HTTP Configurado ---");
        
        try {
            // Cliente com configurações personalizadas
            HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();
            
            // Requisição POST com body JSON
            String jsonBody = "{\"nome\": \"João\", \"idade\": 30}";
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Java11-HttpClient")
                .timeout(Duration.ofSeconds(30))
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("POST Status: " + response.statusCode());
            System.out.println("Response (primeiros 300 chars): " + 
                              response.body().substring(0, Math.min(300, response.body().length())) + "...");
            
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro na requisição HTTP configurada: " + e.getMessage());
        }
    }
}