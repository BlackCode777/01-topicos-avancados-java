package com.blackcode777.java8.optional;

import java.util.Optional;

/**
 * Demonstra o uso da classe Optional introduzida no Java 8
 */
public class OptionalExamples {
    
    public static void demonstrateOptional() {
        System.out.println("--- Optional ---");
        
        // Exemplo 1: Criando Optional
        Optional<String> nomePresente = Optional.of("João");
        Optional<String> nomeAusente = Optional.empty();
        Optional<String> nomeNullable = Optional.ofNullable(null);
        
        System.out.println("Nome presente: " + nomePresente.isPresent());
        System.out.println("Nome ausente: " + nomeAusente.isPresent());
        System.out.println("Nome nullable: " + nomeNullable.isPresent());
        
        // Exemplo 2: Usando ifPresent
        nomePresente.ifPresent(nome -> System.out.println("Olá, " + nome + "!"));
        
        // Exemplo 3: orElse e orElseGet
        String nomeDefault = nomeAusente.orElse("Usuário Padrão");
        System.out.println("Nome com default: " + nomeDefault);
        
        String nomeSupplied = nomeAusente.orElseGet(() -> "Usuário " + System.currentTimeMillis());
        System.out.println("Nome com supplier: " + nomeSupplied);
        
        // Exemplo 4: map e flatMap
        demonstrateOptionalTransformations();
        
        // Exemplo 5: filter
        demonstrateOptionalFiltering();
    }
    
    private static void demonstrateOptionalTransformations() {
        System.out.println("\n--- Transformações Optional ---");
        
        Optional<String> email = Optional.of("usuario@exemplo.com");
        
        // map - transforma o valor se presente
        Optional<String> dominio = email.map(e -> e.substring(e.indexOf('@') + 1));
        dominio.ifPresent(d -> System.out.println("Domínio: " + d));
        
        // flatMap - para transformações que retornam Optional
        Optional<Usuario> usuario = email.flatMap(OptionalExamples::buscarUsuarioPorEmail);
        usuario.ifPresent(u -> System.out.println("Usuário encontrado: " + u.getNome()));
    }
    
    private static void demonstrateOptionalFiltering() {
        System.out.println("\n--- Filtragem Optional ---");
        
        Optional<String> senha = Optional.of("123456");
        
        // filter - mantém o valor apenas se atender à condição
        Optional<String> senhaSegura = senha.filter(s -> s.length() >= 8);
        
        if (senhaSegura.isPresent()) {
            System.out.println("Senha é segura");
        } else {
            System.out.println("Senha não é segura - muito curta");
        }
    }
    
    private static Optional<Usuario> buscarUsuarioPorEmail(String email) {
        // Simulação de busca no banco de dados
        if (email.contains("@exemplo.com")) {
            return Optional.of(new Usuario("João Silva", email));
        }
        return Optional.empty();
    }
    
    // Classe auxiliar
    static class Usuario {
        private String nome;
        private String email;
        
        public Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }
        
        public String getNome() { return nome; }
        public String getEmail() { return email; }
        
        @Override
        public String toString() {
            return nome + " (" + email + ")";
        }
    }
}