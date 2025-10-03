package Java_11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MetodosReadStringWriteStringClasseFiles {

    public static void main(String[] args) {
        Path path = Paths.get("Files.txt");
        try {
            EscreverArquivo.escrever(path, "Hello, Mais do mesmo - World!");
            System.out.println("Arquivo escrito com sucesso!");
            String content = LerArquivo.ler(path);
            System.out.println("Conteúdo lido: " + content);
        } catch (IOException e) {
            System.err.println("Falha de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class LerArquivo {
    // Lê todo o arquivo como String (Java 11)
    static String ler(Path path) throws IOException {
        return Files.readString(path, StandardCharsets.UTF_8);
    }
}

class EscreverArquivo {
    // Escreve String no arquivo (cria ou sobrescreve)
    static void escrever(Path path, String content) throws IOException {
        Files.writeString(path, content, StandardCharsets.UTF_8);
    }
    // Sobrecarga conveniente
    static void escrever(Path path) throws IOException {
        escrever(path, "Hello, World!");
    }
}
