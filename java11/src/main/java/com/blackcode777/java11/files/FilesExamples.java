package com.blackcode777.java11.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Demonstra os novos métodos da classe Files introduzidos no Java 11
 */
public class FilesExamples {
    
    public static void demonstrateFilesMethods() {
        System.out.println("--- Novos Métodos Files ---");
        
        try {
            // Exemplo 1: Files.writeString() e Files.readString()
            demonstrateStringMethods();
            
            // Exemplo 2: Files.isSameFile() melhorado
            demonstrateSameFile();
            
        } catch (IOException e) {
            System.err.println("Erro ao trabalhar com arquivos: " + e.getMessage());
        }
    }
    
    private static void demonstrateStringMethods() throws IOException {
        System.out.println("\n--- writeString() e readString() ---");
        
        // Criar diretório temporário
        Path tempDir = Files.createTempDirectory("java11-files");
        Path arquivo = tempDir.resolve("exemplo.txt");
        
        // Conteúdo para escrever
        String conteudo = "Olá, Java 11!\n" +
                         "Este arquivo foi criado usando Files.writeString().\n" +
                         "\n" +
                         "Funcionalidades demonstradas:\n" +
                         "- Escrita simples de String em arquivo\n" +
                         "- Leitura completa de arquivo como String\n" +
                         "- Append de conteúdo\n";
        
        System.out.println("Escrevendo arquivo em: " + arquivo);
        
        // Escrever string no arquivo
        Files.writeString(arquivo, conteudo);
        
        // Ler string do arquivo
        String conteudoLido = Files.readString(arquivo);
        System.out.println("Conteúdo lido:");
        System.out.println(conteudoLido);
        
        // Append mais conteúdo
        String novoConteudo = "\nConteúdo adicionado com append!\n";
        Files.writeString(arquivo, novoConteudo, StandardOpenOption.APPEND);
        
        // Ler novamente
        String conteudoFinal = Files.readString(arquivo);
        System.out.println("Conteúdo após append:");
        System.out.println("Tamanho: " + conteudoFinal.length() + " caracteres");
        System.out.println("Últimas linhas: " + 
                          conteudoFinal.substring(conteudoFinal.lastIndexOf("Conteúdo adicionado")));
        
        // Limpeza
        Files.deleteIfExists(arquivo);
        Files.deleteIfExists(tempDir);
        
        System.out.println("Arquivo temporário removido.");
    }
    
    private static void demonstrateSameFile() throws IOException {
        System.out.println("\n--- Comparação de Arquivos ---");
        
        // Criar arquivos temporários
        Path temp1 = Files.createTempFile("file1", ".txt");
        Path temp2 = Files.createTempFile("file2", ".txt");
        
        // Escrever mesmo conteúdo nos dois arquivos
        String conteudo = "Mesmo conteúdo nos dois arquivos";
        Files.writeString(temp1, conteudo);
        Files.writeString(temp2, conteudo);
        
        System.out.println("Arquivo 1: " + temp1);
        System.out.println("Arquivo 2: " + temp2);
        
        // Comparar arquivos
        boolean saoIguais = Files.isSameFile(temp1, temp2);
        System.out.println("Os arquivos são o mesmo? " + saoIguais);
        
        // Comparar conteúdo
        String conteudo1 = Files.readString(temp1);
        String conteudo2 = Files.readString(temp2);
        boolean conteudoIgual = conteudo1.equals(conteudo2);
        System.out.println("O conteúdo é igual? " + conteudoIgual);
        
        // Comparar mesmo arquivo
        boolean mesmoArquivo = Files.isSameFile(temp1, temp1);
        System.out.println("Arquivo comparado consigo mesmo: " + mesmoArquivo);
        
        // Informações dos arquivos
        System.out.println("Tamanho arquivo 1: " + Files.size(temp1) + " bytes");
        System.out.println("Tamanho arquivo 2: " + Files.size(temp2) + " bytes");
        System.out.println("Arquivo 1 existe: " + Files.exists(temp1));
        System.out.println("Arquivo 2 é legível: " + Files.isReadable(temp2));
        
        // Limpeza
        Files.deleteIfExists(temp1);
        Files.deleteIfExists(temp2);
        
        System.out.println("Arquivos temporários removidos.");
    }
}