package com.blackcode777.java17;

import com.blackcode777.java17.sealed.SealedClassExamples;
import com.blackcode777.java17.pattern.PatternMatchingExamples;
import com.blackcode777.java17.records.RecordsExamples;

/**
 * Classe principal para demonstrar as funcionalidades do Java 17
 * 
 * Principais funcionalidades:
 * - Sealed Classes (final)
 * - Pattern Matching for instanceof (final)
 * - Records (final)
 * - Text Blocks (final)
 * - Switch Expressions (final)
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java 17 (LTS) - Tópicos Avançados ===\n");
        
        System.out.println("1. Sealed Classes:");
        SealedClassExamples.demonstrateSealedClasses();
        
        System.out.println("\n2. Pattern Matching for instanceof:");
        PatternMatchingExamples.demonstratePatternMatching();
        
        System.out.println("\n3. Records:");
        RecordsExamples.demonstrateRecords();
        
        System.out.println("\n4. Text Blocks:");
        demonstrateTextBlocks();
    }
    
    private static void demonstrateTextBlocks() {
        System.out.println("--- Text Blocks ---");
        
        // Text block básico
        String json = """
                {
                    "nome": "João Silva",
                    "idade": 30,
                    "endereco": {
                        "rua": "Rua das Flores, 123",
                        "cidade": "São Paulo",
                        "cep": "01234-567"
                    },
                    "linguagens": ["Java", "Python", "JavaScript"]
                }
                """;
        
        System.out.println("JSON usando Text Block:");
        System.out.println(json);
        
        // HTML text block
        String html = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Java 17 Text Blocks</title>
                </head>
                <body>
                    <h1>Olá, Java 17!</h1>
                    <p>Este HTML foi criado usando Text Blocks.</p>
                    <ul>
                        <li>Múltiplas linhas</li>
                        <li>Preserva formatação</li>
                        <li>Sem escape de aspas</li>
                    </ul>
                </body>
                </html>
                """;
        
        System.out.println("HTML usando Text Block:");
        System.out.println(html);
        
        // SQL text block
        String sql = """
                SELECT p.nome, p.idade, e.cidade
                FROM pessoas p
                INNER JOIN enderecos e ON p.id = e.pessoa_id
                WHERE p.idade >= 18
                  AND e.cidade = 'São Paulo'
                ORDER BY p.nome
                """;
        
        System.out.println("SQL usando Text Block:");
        System.out.println(sql);
    }
}