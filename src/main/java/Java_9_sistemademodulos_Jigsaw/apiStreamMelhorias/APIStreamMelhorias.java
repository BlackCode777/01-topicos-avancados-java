package Java_9_sistemademodulos_Jigsaw.apiStreamMelhorias;

import Java_8.inferenciaDeTiposExemplo.Produto;

import java.util.ArrayList;
import java.util.List;

public class APIStreamMelhorias{

    public static void main(String[] args) {

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto A", 10.0));
        produtos.add(new Produto("Produto B", 20.0));
        produtos.add(new Produto("Produto C", 30.0));
        produtos.add(new Produto("Produto D", 40.0));
        produtos.add(new Produto("Produto E", 50.0));

        // Exemplo de uso do método takeWhile
        System.out.println("Produtos com preço menor que 35.0:");
        produtos.stream()
                .takeWhile(p -> p.getPreco() < 35.0)
                .forEach(p -> System.out.println(p.getNome() + ": " + p.getPreco()));

        // Exemplo de uso do método dropWhile
        System.out.println("\nProdutos com preço maior ou igual a 30.0:");
        produtos.stream()
                .dropWhile(p -> p.getPreco() < 30.0)
                .forEach(p -> System.out.println(p.getNome() + ": " + p.getPreco()));

        // Exemplo de uso do método ofNullable
        Produto produtoNulo = null;
        System.out.println("\nUsando ofNullable com um produto nulo:");
        java.util.stream.Stream.ofNullable(produtoNulo)
                .forEach(p -> System.out.println(p != null ? p.getNome() : "Produto é nulo"));

        produtoNulo = new Produto("Produto F", 60.0);
        System.out.println("\nUsando ofNullable com um produto não nulo:");
        java.util.stream.Stream.ofNullable(produtoNulo)
                .forEach(p -> System.out.println(p.getNome() + ": " + p.getPreco()));
    }

}
