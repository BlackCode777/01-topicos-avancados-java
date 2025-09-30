package inferenciaDeTiposExemplo;

import java.util.ArrayList;
import java.util.List;

public class InferenciaDeTipos{

    /**
     * * A inferência de tipos em Java permite que o compilador deduza automaticamente o tipo de uma variável com base no contexto em que ela é usada.
     * * Isso é especialmente útil em expressões lambda e na criação de coleções genéricas, onde o tipo pode ser inferido a partir dos argumentos ou do contexto.
     * * A inferência de tipos ajuda a reduzir a verbosidade do código, tornando-o mais legível e conciso.
     * * Introduzida no Java 10, a palavra-chave `var` permite a declaração de variáveis locais sem especificar explicitamente o tipo,
     * * desde que o tipo possa ser inferido a partir do valor atribuído.
     * * Exemplo:
     * * ```java
     * * var lista = List.of("Ana", "Pedro", "Juliana"); // O compilador infere que 'lista' é do tipo List<String>
     * * ```
     * * A inferência de tipos é limitada a variáveis locais e não pode ser usada para campos de classe ou parâmetros de método.
     * * Embora a inferência de tipos possa melhorar a legibilidade do código, é importante usá-la com moderação para evitar ambiguidades e manter a clareza do código.
     * * Em resumo, a inferência de tipos em Java é uma funcionalidade que permite ao compilador deduzir automaticamente o tipo de uma variável com base no contexto,
     * facilitando a escrita de código mais conciso e legível.
     *
     * @param args
     * @return void
     * @throws Exception
     */

    public static void main(String[] args){

        // Usando classe produto
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", 2500.00));
        produtos.add(new Produto("Smartphone", 1500.00));
        produtos.add(new Produto("Tablet", 800.00));
        produtos.add(new Produto("Monitor", 1200.00));
        produtos.add(new Produto("Teclado", 200.00));
        produtos.add(new Produto("Mouse", 100.00));
        produtos.add(new Produto("Headset", 300.00));

        // Usando var para inferência de tipos
        var total = 0.0;
        for (var produto : produtos){
            total+=produto.getPreco();
        }
        System.out.println("Total dos produtos: " + total);
        ImprimeProdutos.imprime(produtos);
    }
}

class  ImprimeProdutos{
    public static void imprime(List<Produto> lista){
        if(!lista.isEmpty()){
            lista.forEach(p -> System.out.println("Produto: " + p.getNome() + " - Preço: " + p.getPreco()));
        }
        else {
            System.out.println("Lista vazia.");
        }
    }
}

