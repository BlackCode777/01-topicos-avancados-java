package Java_12;

import java.nio.file.Path;

import static java.nio.file.Files.mismatch;

public class MisMatchExemple{

    /**
     * Compara se dois arquivos são diferentes de acordo com a posição do primeiro byte diferente.
     * Retorna o índice do primeiro byte diferente ou -1 se os arquivos forem idênticos.
     * VANTAGENS:
     * - Método simples para comparar arquivos.
     * - Retorna a posição exata da primeira diferença.
     * - Útil para verificar integridade de arquivos.
     * OBSERVAÇÃO:
     * - Requer Java 12 ou superior.
     * - Funciona apenas com arquivos binários.
     * - Pode lançar IOException se houver problemas de leitura dos arquivos.
     * - Útil para comparar arquivos de configuração, dados ou binários.
     * - Pode ser usado em scripts de verificação de integridade.
     * EXEMPLO DE USO:
     * - Path path1 = Paths.get("arquivo1.bin");
     * - Path path2 = Paths.get("arquivo2.bin");
     * - long mismatchIndex = Files.mismatch(path1, path2);
     * - if (mismatchIndex == -1) {
     * -     System.out.println("Arquivos são idênticos.");
     * - } else {
     * -     System.out.println("Arquivos são diferentes. Diferença na posição: " + mismatchIndex);
     * - }
     */
    public static void main(String[] args) {
        Path path1 = Path.of("C:\\CAMINHO\\texto01.txt");
        Path path2 = Path.of("C:\\\\CAMINHO\\texto02.txt");
        try {

            long mismatchIndex = mismatch(path1, path2);

            if (mismatchIndex == -1) {
                System.out.println("Os arquivos são idênticos.");
            } else {
                System.out.println("Os arquivos são diferentes. Diferença na posição: " + mismatchIndex);
            }
        } catch (Exception e) {
            System.err.println("Erro ao comparar arquivos: " + e.getMessage());
        }

    }

}
