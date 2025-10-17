package Java_15;

/**
 * Preview:
 * sealed classes (classes seladas) foram introduzidas no Java 15 como uma funcionalidade de pré-visualização (preview feature).
 * Elas permitem que você defina uma hierarquia de classes mais controlada, especificando quais classes podem estender ou implementar uma classe ou interface selada.
 * Isso é útil para impor restrições de design e garantir que apenas um conjunto específico de classes possa herdar de uma classe base.
 * Para declarar uma classe como selada, você usa a palavra-chave "sealed" na declaração da classe, seguida pela palavra-chave "permits"
 * para listar as classes que podem estendê-la. As classes que estendem uma classe selada devem ser declaradas como "final", "sealed" ou "non-sealed".
 * Aqui está um exemplo simples de como usar classes seladas no Java 15:
 * * ```java
 * * public sealed class Forma permits Circulo, Retangulo {
 * *     // código da classe Forma
 * * }
 *
 * sealed:
 * O sealed indica que a classe pode ser estendida apenas por um conjunto específico de subclasses.
 * Essas subclasses devem ser listadas na cláusula permits da declaração da classe selada.
 * As subclasses podem ser declaradas como final (não podem ser estendidas),
 * sealed (podem ser estendidas por um conjunto específico de subclasses) ou non-sealed (podem ser estendidas livremente).
 * final:
 *
 * EXEMPLO:
 * public final class Circulo extends Forma {
 *    // código da classe Circulo
 *    }
 *
 * non-sealed:
 * O non-sealed indica que a classe pode ser estendida livremente, sem restrições.
 * Isso significa que qualquer classe pode estender essa classe, independentemente de sua posição na hierarquia.
 * EXEMPLO:
 * public non-sealed class Triangulo extends Forma {
 *   // código da classe Triangulo
 *   }
 *
 * permits:
 * A cláusula permits é usada na declaração de uma classe selada para listar as classes que têm permissão para estendê-la.
 * Essas classes devem ser declaradas como final, sealed ou non-sealed.
 * EXEMPLO:
 * public sealed class Forma permits Circulo, Retangulo {
 *  // código da classe Forma
 *  }
 *
 * O objetivo principal do sealed é fornecer um controle mais rigoroso sobre a hierarquia de classes,
 * permitindo que os desenvolvedores definam explicitamente quais classes podem estender uma classe base
 * e garantindo que a estrutura do código permaneça consistente e previsível.
 *
 */
public class ClassesSeladas_JEP360{

    // Aplicando o instanceof com correspondência de padrões
    public static void main(String[] args){
        Forma forma1 = new Circulo(5);
        Forma forma2 = new Retangulo(4, 6);

        if(forma1 instanceof Circulo c){
            System.out.println("Círculo com raio: " + c.raio);
        }

        System.out.println("Área do Círculo: " + forma1.area());
        System.out.println("Área do Retângulo: " + forma2.area());
    }

}

abstract sealed class Forma permits Circulo, Retangulo{
    abstract double area();
}

final class Circulo extends Forma{
    protected final double raio;

    public Circulo(double raio){
        this.raio=raio;
    }

    @Override
    double area(){
        return Math.PI * raio * raio;
    }
}

non-sealed class Retangulo extends Forma{
    private final double largura;
    private final double altura;

    public Retangulo(double largura, double altura){
        this.largura=largura;
        this.altura=altura;
    }

    @Override
    double area(){
        return largura * altura;
    }
}
