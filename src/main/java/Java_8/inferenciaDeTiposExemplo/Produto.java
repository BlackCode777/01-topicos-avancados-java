package Java_8.inferenciaDeTiposExemplo;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Anotações repetíveis em Java permitem que você aplique a mesma anotação
 * múltiplas vezes ao mesmo elemento (classe, método, campo, etc.).
 * Isso é útil quando você deseja associar várias instâncias de uma anotação a um único elemento.
 * Para criar uma anotação repetível, você precisa definir uma anotação contêiner
 * que agrupa as instâncias da anotação repetível.
 * A anotação contêiner deve ser anotada com `@Retention(RetentionPolicy.RUNTIME)`
 * e `@Target(ElementType.TYPE)` (ou outro elemento apropriado).
 *
 * <p>
 *     * Exemplo:
 *     * ```java
 *    @Repeatable(Voltagens.class)
 *    @interface Voltagem {
 *        String tensao();
 *    }
 *    @Retention(RetentionPolicy.RUNTIME)
 *    @interface Voltagens {
 *        Voltagem[] value();
 *    }
 *    @Voltagem(tensao = "110V")
 *    @Voltagem(tensao = "220V")
 *    public class Produto {
 *        // campos e métodos da classe
 *    }
 *    ```
 * </p>
 *
 * @author gustavo
 * @version 1.0
 *
 * @since 2024-06-26
 * @return void
 * @throws Exception
 *
 */

@Repeatable(Voltagens.class)
@interface Voltagem{
    String tensao();
}

/**
 * Contêiner para a anotação Voltagem
 * @author gustavo
 * @version 1.0
 * @since 2024-06-26
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Voltagens{
    Voltagem[] value();
}

@Voltagem(tensao = "110V")
@Voltagem(tensao = "220V")
public class Produto{

    /**
     * * Classe Produto com anotações repetíveis de voltagem
     * * A classe Produto representa um produto com nome e preço.
     * * Ela é anotada com a anotação repetível Voltagem para indicar as voltagens disponíveis para o produto.
     * * A anotação Voltagem é usada para especificar diferentes tensões, como "110V" e "220V".
     * * A classe possui um construtor para inicializar os campos nome e preço,
     * * bem como métodos getters para acessar esses valores.
     * * No método main, as anotações de voltagem são recuperadas e exibidas no console.
     */
    private String nome;
    private double preco;

    public Produto(String nome,double preco){
        this.nome=nome;
        this.preco=preco;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }

    public static void main(String[] args){
        Voltagem[] voltagens = Produto.class.getAnnotationsByType(Voltagem.class);
        for(Voltagem v : voltagens){
            System.out.println("Tensão: " + v.tensao());
        }
    }

}
