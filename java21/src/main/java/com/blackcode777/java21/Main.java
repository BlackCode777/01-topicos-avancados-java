package com.blackcode777.java21;

import com.blackcode777.java21.virtualthreads.VirtualThreadsExamples;
import com.blackcode777.java21.pattern.PatternMatchingSwitch;
import com.blackcode777.java21.records.RecordPatternsExamples;

/**
 * Classe principal para demonstrar as funcionalidades do Java 21
 * 
 * NOTA: Este módulo está compilando com Java 17 por limitações do ambiente,
 * mas demonstra conceitos que estarão disponíveis no Java 21:
 * - Virtual Threads (disponível via preview)
 * - Pattern Matching for switch (simulado)
 * - Record Patterns (simulado)
 * - Sequenced Collections (simulado)
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java 21 (LTS) - Tópicos Avançados ===\n");
        
        System.out.println("1. Virtual Threads:");
        VirtualThreadsExamples.demonstrateVirtualThreads();
        
        System.out.println("\n2. Pattern Matching for switch:");
        PatternMatchingSwitch.demonstratePatternMatchingSwitch();
        
        System.out.println("\n3. Record Patterns:");
        RecordPatternsExamples.demonstrateRecordPatterns();
        
        System.out.println("\n4. Sequenced Collections:");
        demonstrateSequencedCollections();
    }
    
    private static void demonstrateSequencedCollections() {
        System.out.println("--- Sequenced Collections (Java 21 Concept) ---");
        System.out.println("NOTA: Demonstração conceitual - funcionalidade disponível no Java 21");
        
        // Simulando sequenced collections usando Java 17
        var lista = new java.util.ArrayList<String>();
        lista.add("primeiro");
        lista.add("segundo");
        lista.add("terceiro");
        
        System.out.println("Lista: " + lista);
        System.out.println("Primeiro (get(0)): " + lista.get(0));
        System.out.println("Último (get(size-1)): " + lista.get(lista.size() - 1));
        
        // Simulando addFirst e addLast
        lista.add(0, "novo primeiro");
        lista.add("novo último");
        System.out.println("Após adicionar: " + lista);
        
        // Simulando removeFirst e removeLast
        String removidoPrimeiro = lista.remove(0);
        String removidoUltimo = lista.remove(lista.size() - 1);
        System.out.println("Removido primeiro: " + removidoPrimeiro);
        System.out.println("Removido último: " + removidoUltimo);
        System.out.println("Lista final: " + lista);
        
        // Lista reversa (disponível no Java 8+)
        var listaReversa = new java.util.ArrayList<>(lista);
        java.util.Collections.reverse(listaReversa);
        System.out.println("Lista reversa: " + listaReversa);
        
        // Set ordenado
        var set = new java.util.LinkedHashSet<Integer>();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println("Set: " + set);
        System.out.println("Primeiro do set: " + set.iterator().next());
        // Para último, precisamos iterar até o final
        Integer ultimo = null;
        for (Integer i : set) {
            ultimo = i;
        }
        System.out.println("Último do set: " + ultimo);
    }
}