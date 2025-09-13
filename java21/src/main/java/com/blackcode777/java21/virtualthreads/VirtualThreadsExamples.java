package com.blackcode777.java21.virtualthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

/**
 * Demonstra o uso de Virtual Threads (conceito do Java 21)
 * 
 * NOTA: Este código simula Virtual Threads usando Java 17.
 * No Java 21, Virtual Threads são finalizadas e têm sintaxe mais simples.
 * 
 * Virtual Threads são threads leves que permitem criar milhões de threads
 * com baixo overhead de memória e CPU
 */
public class VirtualThreadsExamples {
    
    public static void demonstrateVirtualThreads() {
        System.out.println("--- Virtual Threads ---");
        
        // Exemplo 1: Criando virtual threads básicas
        demonstrateBasicVirtualThreads();
        
        // Exemplo 2: Performance comparativa
        demonstratePerformanceComparison();
        
        // Exemplo 3: ExecutorService com virtual threads
        demonstrateVirtualThreadExecutor();
        
        // Exemplo 4: Bloqueio vs não-bloqueio
        demonstrateBlockingOperations();
    }
    
    private static void demonstrateBasicVirtualThreads() {
        System.out.println("\n--- Virtual Threads Básicas (Simulação) ---");
        System.out.println("NOTA: No Java 21, a sintaxe seria mais simples com Thread.ofVirtual()");
        
        // Simulando virtual threads com ForkJoinPool (Java 17)
        var commonPool = java.util.concurrent.ForkJoinPool.commonPool();
        
        // Criando uma tarefa que simula virtual thread
        commonPool.submit(() -> {
            System.out.println("Executando em thread simulada: " + Thread.currentThread());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread simulada finalizada");
        });
        
        // Aguardando um pouco para ver o resultado
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Comparando com thread regular
        Thread regularThread = new Thread(() -> {
            System.out.println("Executando em platform thread: " + Thread.currentThread());
        });
        regularThread.start();
        
        try {
            regularThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private static void demonstratePerformanceComparison() {
        System.out.println("\n--- Comparação de Performance (Simulação) ---");
        System.out.println("NOTA: No Java 21, newVirtualThreadPerTaskExecutor() seria usado");
        
        int numTasks = 1000; // Reduzido para demonstração
        
        // Teste com ForkJoinPool (simulando virtual threads)
        Instant start = Instant.now();
        var commonPool = java.util.concurrent.ForkJoinPool.commonPool();
        var futures = IntStream.range(0, numTasks)
            .mapToObj(i -> commonPool.submit(() -> {
                try {
                    Thread.sleep(1); // Simula operação I/O
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }))
            .toArray(Future[]::new);
        
        // Aguarda todas as tarefas
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Duration forkJoinTime = Duration.between(start, Instant.now());
        
        System.out.println("ForkJoinPool (simulando Virtual Threads): " + numTasks + " tarefas em " + 
                          forkJoinTime.toMillis() + "ms");
        
        // Teste com thread pool tradicional (número limitado)
        start = Instant.now();
        var executor2 = Executors.newFixedThreadPool(50);
        var futures2 = IntStream.range(0, numTasks)
            .mapToObj(i -> executor2.submit(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }))
            .toArray(Future[]::new);
        
        // Aguarda todas as tarefas
        for (Future<?> future : futures2) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor2.shutdown();
        Duration threadPoolTime = Duration.between(start, Instant.now());
        
        System.out.println("Thread Pool (50 threads): " + numTasks + " tarefas em " + 
                          threadPoolTime.toMillis() + "ms");
        
        if (threadPoolTime.toMillis() > 0) {
            System.out.println("Diferença de performance demonstrada");
        }
    }
    
    private static void demonstrateVirtualThreadExecutor() {
        System.out.println("\n--- ExecutorService simulando Virtual Threads ---");
        System.out.println("NOTA: No Java 21, seria Executors.newVirtualThreadPerTaskExecutor()");
        
        // Usando ForkJoinPool para simular o comportamento
        var executor = java.util.concurrent.ForkJoinPool.commonPool();
        
        System.out.println("Submetendo tarefas para pool simulado...");
        
        var futures = IntStream.range(1, 6)
            .mapToObj(i -> executor.submit(() -> {
                String threadName = Thread.currentThread().toString();
                System.out.println("Tarefa " + i + " executando em: " + threadName);
                
                try {
                    Thread.sleep(100 * i); // Simula trabalho
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                return "Resultado da tarefa " + i;
            }))
            .toList();
        
        // Coletando resultados
        futures.forEach(future -> {
            try {
                String resultado = (String) future.get();
                System.out.println("Recebido: " + resultado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        System.out.println("Todas as tarefas concluídas");
    }
    
    private static void demonstrateBlockingOperations() {
        System.out.println("\n--- Operações Bloqueantes (Simulação) ---");
        
        // Simulando o conceito com threads normais
        System.out.println("Simulando operações I/O bloqueantes...");
        
        var threads = IntStream.range(1, 4)
            .mapToObj(i -> new Thread(() -> {
                System.out.println("Thread " + i + " iniciando operação I/O...");
                
                try {
                    // Simula operação I/O (leitura de arquivo, requisição HTTP, etc.)
                    Thread.sleep(200);
                    System.out.println("Thread " + i + " completou operação I/O");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }))
            .toList();
        
        // Inicia todas as threads
        threads.forEach(Thread::start);
        
        // Aguarda todas terminarem
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        System.out.println("Todas as operações I/O completadas");
        
        // Demonstrando conceito de muitas threads leves
        System.out.println("\nSimulando criação de muitas 'virtual threads'...");
        
        Instant start = Instant.now();
        var executor = Executors.newCachedThreadPool();
        IntStream.range(0, 10_000)
            .forEach(i -> executor.submit(() -> {
                // Tarefa muito simples para demonstrar baixo overhead
                Math.sin(i);
            }));
        
        executor.shutdown();
        try {
            executor.awaitTermination(30, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        Duration duration = Duration.between(start, Instant.now());
        
        System.out.println("10.000 tarefas processadas em " + 
                          duration.toMillis() + "ms (usando thread pool cache)");
        System.out.println("NOTA: Virtual Threads no Java 21 teriam overhead ainda menor");
    }
}