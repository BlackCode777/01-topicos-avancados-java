package com.blackcode777.java21.records;

import java.time.LocalDate;
import java.util.List;

/**
 * Demonstra o uso de Record Patterns (conceito do Java 21)
 * 
 * NOTA: Este código simula record patterns usando Java 17.
 * No Java 21, record patterns são finalizados.
 */
public class RecordPatternsExamples {
    
    public static void demonstrateRecordPatterns() {
        System.out.println("--- Record Patterns ---");
        
        // Exemplo 1: Desestruturação básica de records
        demonstrateBasicRecordPatterns();
        
        // Exemplo 2: Record patterns aninhados
        demonstrateNestedRecordPatterns();
        
        // Exemplo 3: Record patterns com guards
        demonstrateRecordPatternsWithGuards();
        
        // Exemplo 4: Record patterns em switch expressions
        demonstrateRecordPatternsInSwitch();
    }
    
    private static void demonstrateBasicRecordPatterns() {
        System.out.println("\n--- Record Patterns Básicos (Simulação Java 21) ---");
        System.out.println("NOTA: No Java 21, seria possível desestruturar records diretamente");
        
        Pessoa[] pessoas = {
            new Pessoa("João", 25, "joao@email.com"),
            new Pessoa("Maria", 30, "maria@email.com"),
            new Pessoa("Ana", 35, "ana@email.com")
        };
        
        for (Pessoa pessoa : pessoas) {
            // Simulando desestruturação usando acessors normais
            var nome = pessoa.nome();
            var idade = pessoa.idade();
            var email = pessoa.email();
            
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade);
            System.out.println("Email: " + email);
            System.out.println("---");
        }
        
        // Usando métodos de record normalmente
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.nome() + " tem " + pessoa.idade() + " anos e email " + pessoa.email());
        }
    }
    
    private static void demonstrateNestedRecordPatterns() {
        System.out.println("\n--- Record Patterns Aninhados (Simulação Java 21) ---");
        
        Endereco endereco1 = new Endereco("Rua A", "São Paulo", "SP", "01000-000");
        Endereco endereco2 = new Endereco("Rua B", "Rio de Janeiro", "RJ", "20000-000");
        
        Cliente[] clientes = {
            new Cliente("João Silva", endereco1, List.of("11999999999")),
            new Cliente("Maria Santos", endereco2, List.of("21888888888", "21777777777"))
        };
        
        for (Cliente cliente : clientes) {
            // Simulando pattern matching aninhado usando acessors
            var nome = cliente.nome();
            var endereco = cliente.endereco();
            var telefones = cliente.telefones();
            
            var rua = endereco.rua();
            var cidade = endereco.cidade();
            var estado = endereco.estado();
            var cep = endereco.cep();
            
            System.out.println("Cliente: " + nome);
            System.out.println("Endereço: " + rua + ", " + cidade + "/" + estado + " - " + cep);
            System.out.println("Telefones: " + telefones);
            System.out.println("---");
        }
    }
    
    private static void demonstrateRecordPatternsWithGuards() {
        System.out.println("\n--- Record Patterns com Guards (Simulação Java 21) ---");
        
        Produto[] produtos = {
            new Produto("Notebook", 2500.00, Categoria.ELETRONICOS),
            new Produto("Livro", 50.00, Categoria.EDUCACAO),
            new Produto("Camiseta", 80.00, Categoria.ROUPAS),
            new Produto("Smartphone", 1200.00, Categoria.ELETRONICOS)
        };
        
        for (Produto produto : produtos) {
            String classificacao;
            var nome = produto.nome();
            var preco = produto.preco();
            var categoria = produto.categoria();
            
            if (preco > 1000 && categoria == Categoria.ELETRONICOS) {
                classificacao = "Eletrônico Premium: " + nome + " por R$ " + preco;
            } else if (preco < 100) {
                classificacao = "Produto Econômico: " + nome + " (" + categoria + ")";
            } else if (categoria == Categoria.EDUCACAO) {
                classificacao = "Material Educativo: " + nome + " por R$ " + preco;
            } else {
                classificacao = "Produto Regular: " + nome + " (" + categoria + ") - R$ " + preco;
            }
            
            System.out.println(classificacao);
        }
    }
    
    private static void demonstrateRecordPatternsInSwitch() {
        System.out.println("\n--- Record Patterns em Switch (Simulação Java 21) ---");
        
        Transacao[] transacoes = {
            new Deposito(1000.00, LocalDate.now(), "Salário"),
            new Saque(200.00, LocalDate.now(), "ATM Centro"),
            new Transferencia(500.00, LocalDate.now(), "João Silva", "12345-6"),
            new Pix(150.00, LocalDate.now(), "maria@email.com")
        };
        
        double saldoTotal = 0;
        
        for (Transacao transacao : transacoes) {
            double impacto;
            if (transacao instanceof Deposito d) {
                System.out.println("+ Depósito: R$ " + d.valor() + " (" + d.descricao() + ")");
                impacto = d.valor();
            } else if (transacao instanceof Saque s) {
                System.out.println("- Saque: R$ " + s.valor() + " em " + s.local());
                impacto = -s.valor();
            } else if (transacao instanceof Transferencia t) {
                System.out.println("- Transferência: R$ " + t.valor() + " para " + t.destinatario() + " (" + t.conta() + ")");
                impacto = -t.valor();
            } else if (transacao instanceof Pix p) {
                System.out.println("- PIX: R$ " + p.valor() + " para " + p.chave());
                impacto = -p.valor();
            } else {
                impacto = 0;
            }
            
            saldoTotal += impacto;
        }
        
        System.out.println("Saldo final: R$ " + String.format("%.2f", saldoTotal));
        
        // Análise de transações por tipo
        System.out.println("\nAnálise por tipo:");
        for (Transacao transacao : transacoes) {
            String analise;
            if (transacao instanceof Deposito d) {
                if (d.valor() > 500) {
                    analise = "Depósito alto: R$ " + d.valor();
                } else {
                    analise = "Depósito normal: R$ " + d.valor();
                }
            } else if (transacao instanceof Saque s) {
                if (s.valor() > 300) {
                    analise = "Saque alto em " + s.local();
                } else {
                    analise = "Saque normal em " + s.local();
                }
            } else if (transacao instanceof Transferencia t) {
                analise = "Transferência de R$ " + t.valor() + " para " + t.destinatario();
            } else if (transacao instanceof Pix p) {
                analise = "PIX de R$ " + p.valor();
            } else {
                analise = "Transação desconhecida";
            }
            
            System.out.println(analise);
        }
    }
}

// Records para demonstrar patterns
record Pessoa(String nome, int idade, String email) {}

record Endereco(String rua, String cidade, String estado, String cep) {}

record Cliente(String nome, Endereco endereco, List<String> telefones) {}

enum Categoria {
    ELETRONICOS, EDUCACAO, ROUPAS, CASA, ESPORTES
}

record Produto(String nome, double preco, Categoria categoria) {}

// Hierarquia de transações usando sealed interface
sealed interface Transacao 
    permits Deposito, Saque, Transferencia, Pix {}

record Deposito(double valor, LocalDate data, String descricao) implements Transacao {}

record Saque(double valor, LocalDate data, String local) implements Transacao {}

record Transferencia(double valor, LocalDate data, String destinatario, String conta) implements Transacao {}

record Pix(double valor, LocalDate data, String chave) implements Transacao {}