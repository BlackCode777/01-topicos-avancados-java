package com.blackcode777.java11;

import com.blackcode777.java11.httpclient.HttpClientExamples;
import com.blackcode777.java11.stringmethods.StringMethodExamples;
import com.blackcode777.java11.files.FilesExamples;

/**
 * Classe principal para demonstrar as funcionalidades do Java 11
 * 
 * Principais funcionalidades:
 * - HTTP Client API
 * - String Methods (isBlank, strip, lines, repeat)
 * - Files Methods
 * - Local Variable Type Inference com var
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java 11 - Tópicos Avançados ===\n");
        
        System.out.println("1. HTTP Client API:");
        HttpClientExamples.demonstrateHttpClient();
        
        System.out.println("\n2. String Methods:");
        StringMethodExamples.demonstrateStringMethods();
        
        System.out.println("\n3. Files Methods:");
        FilesExamples.demonstrateFilesMethods();
        
        System.out.println("\n4. Local Variable Type Inference (var):");
        demonstrateVar();
    }
    
    private static void demonstrateVar() {
        System.out.println("--- Uso de var ---");
        
        // var pode ser usado em declarações locais
        var texto = "Hello World";
        var numero = 42;
        var lista = java.util.List.of("Java", "11", "var");
        var mapa = java.util.Map.of("versao", "Java 11", "ano", 2018);
        
        System.out.println("Texto: " + texto + " (tipo: " + texto.getClass().getSimpleName() + ")");
        System.out.println("Número: " + numero + " (tipo: " + ((Object)numero).getClass().getSimpleName() + ")");
        System.out.println("Lista: " + lista + " (tipo: " + lista.getClass().getSimpleName() + ")");
        System.out.println("Mapa: " + mapa + " (tipo: " + mapa.getClass().getSimpleName() + ")");
        
        // var em loops
        System.out.println("Iterando com var:");
        for (var item : lista) {
            System.out.println("  - " + item);
        }
    }
}