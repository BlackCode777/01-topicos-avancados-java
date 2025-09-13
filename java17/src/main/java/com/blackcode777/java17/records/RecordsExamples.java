package com.blackcode777.java17.records;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

/**
 * Demonstra o uso de Records introduzidos no Java 17 (finalizados)
 * 
 * Records são classes de dados imutáveis que reduzem o boilerplate code
 */
public class RecordsExamples {
    
    public static void demonstrateRecords() {
        System.out.println("--- Records ---");
        
        // Exemplo básico
        demonstrateBasicRecord();
        
        // Record com validação
        demonstrateValidatedRecord();
        
        // Record com métodos customizados
        demonstrateCustomMethods();
        
        // Record com herança/interfaces
        demonstrateRecordWithInterface();
        
        // Record aninhado
        demonstrateNestedRecord();
    }
    
    private static void demonstrateBasicRecord() {
        System.out.println("\n--- Record Básico ---");
        
        // Criando pessoas
        Pessoa pessoa1 = new Pessoa("João Silva", 30, "joao@email.com");
        Pessoa pessoa2 = new Pessoa("Maria Santos", 25, "maria@email.com");
        Pessoa pessoa3 = new Pessoa("João Silva", 30, "joao@email.com"); // igual a pessoa1
        
        System.out.println("Pessoa 1: " + pessoa1);
        System.out.println("Pessoa 2: " + pessoa2);
        System.out.println("Pessoa 3: " + pessoa3);
        
        // Métodos gerados automaticamente
        System.out.println("Nome da pessoa 1: " + pessoa1.nome());
        System.out.println("Idade da pessoa 2: " + pessoa2.idade());
        System.out.println("Email da pessoa 3: " + pessoa3.email());
        
        // Equals e hashCode automáticos
        System.out.println("Pessoa 1 equals Pessoa 3: " + pessoa1.equals(pessoa3));
        System.out.println("Pessoa 1 equals Pessoa 2: " + pessoa1.equals(pessoa2));
        System.out.println("HashCode pessoa 1: " + pessoa1.hashCode());
        System.out.println("HashCode pessoa 3: " + pessoa3.hashCode());
    }
    
    private static void demonstrateValidatedRecord() {
        System.out.println("\n--- Record com Validação ---");
        
        try {
            // Record com validação no construtor
            ContaBancaria conta1 = new ContaBancaria("12345-6", "João Silva", 1000.00);
            ContaBancaria conta2 = new ContaBancaria("78910-1", "Maria Santos", 250.50);
            
            System.out.println("Conta 1: " + conta1);
            System.out.println("Conta 2: " + conta2);
            
            // Tentativa com dados inválidos
            ContaBancaria contaInvalida = new ContaBancaria("", "Nome", -100);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
    
    private static void demonstrateCustomMethods() {
        System.out.println("\n--- Record com Métodos Customizados ---");
        
        Produto produto1 = new Produto("Notebook", 2500.00, "Eletrônicos");
        Produto produto2 = new Produto("Livro Java", 89.90, "Educação");
        
        System.out.println("Produto 1: " + produto1);
        System.out.println("Produto 1 formatado: " + produto1.formatarPreco());
        System.out.println("Produto 1 é caro: " + produto1.eCaro());
        
        System.out.println("Produto 2: " + produto2);
        System.out.println("Produto 2 formatado: " + produto2.formatarPreco());
        System.out.println("Produto 2 é caro: " + produto2.eCaro());
        
        // Método estático
        System.out.println("Produto gratuito: " + Produto.criarGratuito("Amostra grátis", "Promocional"));
    }
    
    private static void demonstrateRecordWithInterface() {
        System.out.println("\n--- Record com Interface ---");
        
        Funcionario func1 = new Funcionario("Ana Costa", LocalDate.of(1990, 5, 15), 5500.00);
        Funcionario func2 = new Funcionario("Carlos Lima", LocalDate.of(1985, 12, 3), 7200.00);
        
        System.out.println("Funcionário 1: " + func1);
        System.out.println("Idade: " + func1.calcularIdade() + " anos");
        System.out.println("Descrição: " + func1.descrever());
        
        System.out.println("Funcionário 2: " + func2);
        System.out.println("Idade: " + func2.calcularIdade() + " anos");
        System.out.println("Descrição: " + func2.descrever());
    }
    
    private static void demonstrateNestedRecord() {
        System.out.println("\n--- Record Aninhado ---");
        
        Endereco endereco1 = new Endereco("Rua das Flores, 123", "São Paulo", "SP", "01234-567");
        Endereco endereco2 = new Endereco("Av. Paulista, 1000", "São Paulo", "SP", "01310-100");
        
        Cliente cliente = new Cliente(
            "Empresa XYZ Ltda",
            "12.345.678/0001-90",
            endereco1,
            List.of(
                new Cliente.Contato("João", "joao@xyz.com", "(11) 99999-9999"),
                new Cliente.Contato("Maria", "maria@xyz.com", "(11) 88888-8888")
            )
        );
        
        System.out.println("Cliente: " + cliente.nome());
        System.out.println("CNPJ: " + cliente.cnpj());
        System.out.println("Endereço: " + cliente.endereco().formatarCompleto());
        System.out.println("Contatos:");
        cliente.contatos().forEach(contato -> 
            System.out.println("  - " + contato.nome() + ": " + contato.email() + " / " + contato.telefone())
        );
    }
}

// Record básico
record Pessoa(String nome, int idade, String email) {}

// Record com validação
record ContaBancaria(String numero, String titular, double saldo) {
    public ContaBancaria {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número da conta não pode ser vazio");
        }
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular não pode ser vazio");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo não pode ser negativo");
        }
    }
}

// Record com métodos customizados
record Produto(String nome, double preco, String categoria) {
    
    // Método de instância customizado
    public String formatarPreco() {
        return String.format("R$ %.2f", preco);
    }
    
    public boolean eCaro() {
        return preco > 1000.0;
    }
    
    // Método estático
    public static Produto criarGratuito(String nome, String categoria) {
        return new Produto(nome, 0.0, categoria);
    }
}

// Interface para demonstrar Records implementando interfaces
interface Pessoa2 {
    String descrever();
    int calcularIdade();
}

// Record implementando interface
record Funcionario(String nome, LocalDate nascimento, double salario) implements Pessoa2 {
    
    @Override
    public String descrever() {
        return String.format("%s, %d anos, salário %s", 
                           nome, calcularIdade(), formatarSalario());
    }
    
    @Override
    public int calcularIdade() {
        return Period.between(nascimento, LocalDate.now()).getYears();
    }
    
    public String formatarSalario() {
        return String.format("R$ %.2f", salario);
    }
}

// Records aninhados
record Endereco(String logradouro, String cidade, String estado, String cep) {
    public String formatarCompleto() {
        return String.format("%s, %s/%s - %s", logradouro, cidade, estado, cep);
    }
}

record Cliente(String nome, String cnpj, Endereco endereco, List<Contato> contatos) {
    
    // Record aninhado
    record Contato(String nome, String email, String telefone) {
        public Contato {
            Objects.requireNonNull(nome, "Nome não pode ser nulo");
            Objects.requireNonNull(email, "Email não pode ser nulo");
        }
    }
}