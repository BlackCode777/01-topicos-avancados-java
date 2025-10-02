package Java_9_sistemademodulos_Jigsaw.melhoriasDoMetodoTryCatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MelhoriasDoMetodoTryCatch_NoJava07{

    public static void main(String[] args) {

        String fileTXT = ".\\src\\main\\java\\Java_9_sistemademodulos_Jigsaw\\melhoriasDoMetodoTryCatch\\file.txt";

        try{
            MelhoriasDoMetodoTryCatch_NoJava07.lerArquivo(fileTXT);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Antes do Java 7, o gerenciamento de recursos como arquivos exigia um bloco finally
     * para garantir que os recursos fossem fechados corretamente, mesmo em caso de exceção.
     * Isso resultava em código mais verboso e propenso a erros.
     * Exemplo:
     * BufferedReader reader = null;
     * try {
     *     reader = new BufferedReader(new FileReader("arquivo.txt"));
     *     String linha;
     *     while ((linha = reader.readLine()) != null) {
     *         System.out.println(linha);
     *     }
     * } catch (IOException e) {
     *     e.printStackTrace();
     * } finally {
     *     if (reader != null) {
     *         try {
     *             reader.close();
     *         } catch (IOException e) {
     *             e.printStackTrace();
     *         }
     *     }
     * }
     * @param path
     * @throws IOException
     */
    public static void lerArquivo(String path) throws IOException{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Melhorias do método try-catch no Java 7: try-with-resources
     * O bloco try-with-resources foi introduzido no Java 7 para simplificar
     * o gerenciamento de recursos que precisam ser fechados após o uso, como
     * arquivos, conexões de banco de dados, etc.
     * Com o try-with-resources, você pode declarar e inicializar recursos
     * dentro dos parênteses do bloco try, e esses recursos serão automaticamente
     * fechados ao final do bloco, mesmo que uma exceção seja lançada.
     * Isso elimina a necessidade de um bloco finally separado para fechar os recursos,
     * tornando o código mais limpo e menos propenso a erros.
     * Exemplo:
     * try (BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"))) {
     *     String linha;
     *     while ((linha = reader.readLine()) != null) {
     *         System.out.println(linha);
     *     }
     * } catch (IOException e) {
     *     e.printStackTrace();
     * }
     * Neste exemplo, o BufferedReader é declarado dentro do bloco try-with-resources,
     * e será automaticamente fechado ao final do bloco, mesmo que uma IOException
     * seja lançada durante a leitura do arquivo.
     * @param path
     * @throws IOException
     */
    public static void lerArquivoBlocoTryWithRecursos(String path) throws IOException{
        String linha;
        BufferedReader reader=new BufferedReader(new FileReader(path));
        try (reader){
            while ((linha=reader.readLine())!=null){
                System.out.println(linha);
            }
        }
    }

}

