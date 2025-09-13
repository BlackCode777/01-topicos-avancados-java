package com.blackcode777.java8.streams;

import java.util.*;
import java.util.stream.*;

/**
 * Demonstra o uso da Stream API introduzida no Java 8
 */
public class StreamExamples {
    
    public static void demonstrateStreams() {
        System.out.println("--- Stream API ---");
        
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Lista original: " + numeros);
        
        // Exemplo 1: Filtrar e mapear
        List<Integer> paresAoQuadrado = numeros.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Números pares ao quadrado: " + paresAoQuadrado);
        
        // Exemplo 2: Redução
        Optional<Integer> soma = numeros.stream()
            .reduce((a, b) -> a + b);
        System.out.println("Soma de todos os números: " + soma.orElse(0));
        
        // Exemplo 3: Estatísticas
        IntSummaryStatistics stats = numeros.stream()
            .mapToInt(Integer::intValue)
            .summaryStatistics();
        System.out.println("Estatísticas: " + stats);
        
        // Exemplo 4: Agrupamento
        demonstrateGrouping();
        
        // Exemplo 5: Streams infinitos
        demonstrateInfiniteStreams();
    }
    
    private static void demonstrateGrouping() {
        System.out.println("\n--- Agrupamento ---");
        
        List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("Ana", 25),
            new Pessoa("Bruno", 30),
            new Pessoa("Carlos", 25),
            new Pessoa("Diana", 35)
        );
        
        Map<Integer, List<Pessoa>> porIdade = pessoas.stream()
            .collect(Collectors.groupingBy(Pessoa::getIdade));
        
        porIdade.forEach((idade, lista) -> 
            System.out.println("Idade " + idade + ": " + lista));
    }
    
    private static void demonstrateInfiniteStreams() {
        System.out.println("\n--- Streams Infinitos ---");
        
        // Números pares infinitos
        List<Integer> primeiros10Pares = Stream.iterate(2, n -> n + 2)
            .limit(10)
            .collect(Collectors.toList());
        System.out.println("Primeiros 10 números pares: " + primeiros10Pares);
        
        // Números aleatórios
        List<Double> numerosAleatorios = Stream.generate(Math::random)
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("5 números aleatórios: " + numerosAleatorios);
    }
    
    // Classe auxiliar
    static class Pessoa {
        private String nome;
        private int idade;
        
        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }
        
        public String getNome() { return nome; }
        public int getIdade() { return idade; }
        
        @Override
        public String toString() {
            return nome + "(" + idade + ")";
        }
    }
}