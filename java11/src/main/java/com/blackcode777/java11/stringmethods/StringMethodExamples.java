package com.blackcode777.java11.stringmethods;

import java.util.stream.Collectors;

/**
 * Demonstra os novos métodos de String introduzidos no Java 11
 */
public class StringMethodExamples {
    
    public static void demonstrateStringMethods() {
        System.out.println("--- Novos Métodos de String ---");
        
        // Exemplo 1: isBlank()
        demonstrateIsBlank();
        
        // Exemplo 2: strip(), stripLeading(), stripTrailing()
        demonstrateStrip();
        
        // Exemplo 3: lines()
        demonstrateLines();
        
        // Exemplo 4: repeat()
        demonstrateRepeat();
    }
    
    private static void demonstrateIsBlank() {
        System.out.println("\n--- isBlank() ---");
        
        String vazia = "";
        String espacos = "   ";
        String comTexto = "  Hello  ";
        String tabs = "\t\n";
        
        System.out.println("String vazia.isBlank(): " + vazia.isBlank());
        System.out.println("String com espaços.isBlank(): " + espacos.isBlank());
        System.out.println("String com texto.isBlank(): " + comTexto.isBlank());
        System.out.println("String com tabs/newlines.isBlank(): " + tabs.isBlank());
        
        // Comparação com isEmpty()
        System.out.println("\nComparação com isEmpty():");
        System.out.println("Espaços - isEmpty(): " + espacos.isEmpty() + ", isBlank(): " + espacos.isBlank());
    }
    
    private static void demonstrateStrip() {
        System.out.println("\n--- strip(), stripLeading(), stripTrailing() ---");
        
        String texto = "  \t  Hello World  \n  ";
        
        System.out.println("Original: '" + texto + "'");
        System.out.println("strip(): '" + texto.strip() + "'");
        System.out.println("stripLeading(): '" + texto.stripLeading() + "'");
        System.out.println("stripTrailing(): '" + texto.stripTrailing() + "'");
        
        // Comparação com trim()
        System.out.println("\nComparação com trim():");
        String unicodeSpaces = "\u2000\u2001Hello\u2002\u2003";
        System.out.println("String com espaços Unicode: '" + unicodeSpaces + "'");
        System.out.println("trim(): '" + unicodeSpaces.trim() + "'");
        System.out.println("strip(): '" + unicodeSpaces.strip() + "'");
    }
    
    private static void demonstrateLines() {
        System.out.println("\n--- lines() ---");
        
        String multilinhas = "Linha 1\nLinha 2\r\nLinha 3\n\nLinha 5";
        
        System.out.println("Texto original:");
        System.out.println(multilinhas);
        
        System.out.println("\nUsando lines():");
        multilinhas.lines()
                   .forEach(linha -> System.out.println("  '" + linha + "'"));
        
        // Processamento de linhas
        System.out.println("\nLinhas não vazias em maiúscula:");
        String resultado = multilinhas.lines()
                                     .filter(linha -> !linha.isBlank())
                                     .map(String::toUpperCase)
                                     .collect(Collectors.joining(" | "));
        System.out.println(resultado);
        
        // Contagem de linhas
        long totalLinhas = multilinhas.lines().count();
        long linhasNaoVazias = multilinhas.lines().filter(linha -> !linha.isBlank()).count();
        System.out.println("Total de linhas: " + totalLinhas);
        System.out.println("Linhas não vazias: " + linhasNaoVazias);
    }
    
    private static void demonstrateRepeat() {
        System.out.println("\n--- repeat() ---");
        
        String padrao = "Java ";
        String separador = "-";
        String emoji = "🚀";
        
        System.out.println("Padrão repetido 3 vezes: '" + padrao.repeat(3) + "'");
        System.out.println("Separador repetido 20 vezes: " + separador.repeat(20));
        System.out.println("Emoji repetido 5 vezes: " + emoji.repeat(5));
        
        // Uso prático: criando padding
        System.out.println("\nCriando padding:");
        String titulo = "JAVA 11";
        String padding = " ".repeat(10);
        System.out.println("'" + padding + titulo + padding + "'");
        
        // Criando linhas decorativas
        System.out.println("\nLinhas decorativas:");
        System.out.println("=".repeat(50));
        System.out.println("*".repeat(25) + " TÍTULO " + "*".repeat(25));
        System.out.println("=".repeat(50));
        
        // repeat(0) retorna string vazia
        System.out.println("repeat(0): '" + padrao.repeat(0) + "'");
    }
}