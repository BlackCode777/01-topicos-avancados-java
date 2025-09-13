package com.blackcode777.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Demonstra o uso de Lambda Expressions introduzidas no Java 8
 */
public class LambdaExamples {
    
    public static void demonstrateLambdas() {
        System.out.println("--- Lambda Expressions ---");
        
        // Exemplo 1: Comparator usando lambda
        List<String> nomes = Arrays.asList("Ana", "Carlos", "Bruno", "Diana");
        System.out.println("Lista original: " + nomes);
        
        // Ordenação usando lambda
        nomes.sort((a, b) -> a.compareTo(b));
        System.out.println("Ordenada: " + nomes);
        
        // Exemplo 2: Interfaces funcionais
        demonstrateFunctionalInterfaces();
        
        // Exemplo 3: Method references
        demonstrateMethodReferences();
    }
    
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("\n--- Interfaces Funcionais ---");
        
        // Predicate - testa condição
        Predicate<String> isLongName = name -> name.length() > 5;
        System.out.println("'Carlos' tem nome longo? " + isLongName.test("Carlos"));
        
        // Function - transforma entrada em saída
        Function<String, Integer> nameLength = String::length;
        System.out.println("Tamanho de 'Ana': " + nameLength.apply("Ana"));
        
        // Consumer - consome entrada
        Consumer<String> printUpperCase = name -> System.out.println(name.toUpperCase());
        System.out.print("Nome em maiúscula: ");
        printUpperCase.accept("bruno");
        
        // Supplier - fornece valor
        Supplier<String> randomName = () -> "Nome" + Math.random();
        System.out.println("Nome aleatório: " + randomName.get());
    }
    
    private static void demonstrateMethodReferences() {
        System.out.println("\n--- Method References ---");
        
        List<String> palavras = Arrays.asList("java", "lambda", "stream", "optional");
        
        // Method reference para método estático
        palavras.forEach(System.out::println);
        
        // Method reference para método de instância
        System.out.println("Palavras em maiúscula:");
        palavras.stream()
               .map(String::toUpperCase)
               .forEach(System.out::println);
    }
}