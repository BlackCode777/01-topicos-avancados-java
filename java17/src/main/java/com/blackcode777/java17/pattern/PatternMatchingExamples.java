package com.blackcode777.java17.pattern;

/**
 * Demonstra o uso de Pattern Matching for instanceof introduzido no Java 17
 */
public class PatternMatchingExamples {
    
    public static void demonstratePatternMatching() {
        System.out.println("--- Pattern Matching for instanceof ---");
        
        // Exemplo básico
        demonstrateBasicPatternMatching();
        
        // Exemplo com hierarchy
        demonstrateHierarchyPatternMatching();
        
        // Exemplo com collections
        demonstrateCollectionPatternMatching();
    }
    
    private static void demonstrateBasicPatternMatching() {
        System.out.println("\n--- Pattern Matching Básico ---");
        
        Object obj1 = "Hello World";
        Object obj2 = 42;
        Object obj3 = 3.14;
        Object obj4 = java.util.List.of(1, 2, 3);
        
        processObject(obj1);
        processObject(obj2);
        processObject(obj3);
        processObject(obj4);
    }
    
    private static void processObject(Object obj) {
        // Modo antigo (antes do Java 17)
        /*
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("String com " + s.length() + " caracteres: " + s);
        } else if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("Integer: " + i + " (par: " + (i % 2 == 0) + ")");
        }
        */
        
        // Modo novo com Pattern Matching (Java 17+)
        if (obj instanceof String s) {
            System.out.println("String com " + s.length() + " caracteres: " + s);
        } else if (obj instanceof Integer i) {
            System.out.println("Integer: " + i + " (par: " + (i % 2 == 0) + ")");
        } else if (obj instanceof Double d) {
            System.out.println("Double: " + d + " (inteiro: " + (d % 1 == 0) + ")");
        } else if (obj instanceof java.util.List<?> list) {
            System.out.println("Lista com " + list.size() + " elementos: " + list);
        } else {
            System.out.println("Tipo não reconhecido: " + obj.getClass().getSimpleName());
        }
    }
    
    private static void demonstrateHierarchyPatternMatching() {
        System.out.println("\n--- Pattern Matching com Hierarquia ---");
        
        Animal cachorro = new Cachorro("Rex", "Golden Retriever");
        Animal gato = new Gato("Mimi", true);
        Animal passaro = new Passaro("Piu", true);
        
        processAnimal(cachorro);
        processAnimal(gato);
        processAnimal(passaro);
    }
    
    private static void processAnimal(Animal animal) {
        String descrição;
        if (animal instanceof Cachorro c) {
            descrição = "Cachorro " + c.nome() + " da raça " + c.raca();
        } else if (animal instanceof Gato g) {
            descrição = "Gato " + g.nome() + (g.domestico() ? " (doméstico)" : " (selvagem)");
        } else if (animal instanceof Passaro p) {
            descrição = "Pássaro " + p.nome() + (p.podeVoar() ? " que voa" : " que não voa");
        } else {
            descrição = "Animal desconhecido";
        }
        
        System.out.println(descrição);
        
        // Pattern matching em condicionais
        if (animal instanceof Cachorro c && c.raca().contains("Golden")) {
            System.out.println("  → Este é um Golden Retriever!");
        } else if (animal instanceof Gato g && g.domestico()) {
            System.out.println("  → Este gato é doméstico e provavelmente ronrona!");
        } else if (animal instanceof Passaro p && p.podeVoar()) {
            System.out.println("  → Este pássaro pode voar bem alto!");
        }
    }
    
    private static void demonstrateCollectionPatternMatching() {
        System.out.println("\n--- Pattern Matching com Collections ---");
        
        Object obj1 = java.util.List.of(1, 2, 3, 4, 5);
        Object obj2 = java.util.Set.of("a", "b", "c");
        Object obj3 = java.util.Map.of("chave1", "valor1", "chave2", "valor2");
        
        analyzeCollection(obj1);
        analyzeCollection(obj2);
        analyzeCollection(obj3);
    }
    
    private static void analyzeCollection(Object obj) {
        if (obj instanceof java.util.List<?> list && !list.isEmpty()) {
            System.out.println("Lista não vazia com " + list.size() + " elementos");
            System.out.println("  Primeiro elemento: " + list.get(0));
            System.out.println("  Último elemento: " + list.get(list.size() - 1));
        } else if (obj instanceof java.util.Set<?> set && set.size() > 2) {
            System.out.println("Set com mais de 2 elementos: " + set);
            System.out.println("  Contém 'a': " + set.contains("a"));
        } else if (obj instanceof java.util.Map<?, ?> map && !map.isEmpty()) {
            System.out.println("Map com " + map.size() + " entradas");
            map.forEach((k, v) -> System.out.println("  " + k + " -> " + v));
        } else {
            System.out.println("Objeto não é uma coleção suportada ou está vazio");
        }
    }
}

// Classes para demonstrar hierarquia
sealed interface Animal permits Cachorro, Gato, Passaro {}

record Cachorro(String nome, String raca) implements Animal {}
record Gato(String nome, boolean domestico) implements Animal {}
record Passaro(String nome, boolean podeVoar) implements Animal {}