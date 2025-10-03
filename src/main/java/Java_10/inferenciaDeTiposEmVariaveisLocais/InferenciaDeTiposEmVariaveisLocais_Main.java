package Java_10.inferenciaDeTiposEmVariaveisLocais;

/**
 * Inferência de Tipos em Variáveis Locais (Java 10+)
 * Com a introdução do Java 10, foi adicionada a capacidade de usar a inferência
 * de tipos em variáveis locais usando a palavra-chave `var`. Isso permite que
 * o compilador deduza o tipo da variável com base no valor atribuído a ela,
 * tornando o código mais conciso e legível.
 */

public class InferenciaDeTiposEmVariaveisLocais_Main{

    public static void main(String[] args) {

        // Com a inferência de tipos em variáveis locais (Java 10+), podemos usar 'var'
        var outraMensagem = "Olá, Java 10!";
        System.out.println(outraMensagem);

        // Antes do Java 10, era necessário declarar o tipo explicitamente
        String mensagem = "Olá, Mundo!";
        System.out.println(mensagem);

        // A inferência de tipos também funciona com coleções
        var lista = new java.util.ArrayList<String>();
        lista.add("Item 1");
        lista.add("Item 2");
        System.out.println(lista);
    }

}
