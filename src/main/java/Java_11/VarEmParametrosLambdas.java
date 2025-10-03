package Java_11;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Uso de 'var' em parâmetros de expressões lambda em Java 11
 * EXEMPLO:
 * Antes do Java 11, os parâmetros de expressões lambda precisavam ter seus tipos explicitamente declarados ou inferidos.
 * Com o Java 11, é possível usar 'var' para declarar parâmetros de expressões lambda, o que pode melhorar a legibilidade do código.
 * EXEMPLO DE USO:
 * BiFunction<Integer, Integer, Integer> sum = (var a, var b) -> a + b;
 * System.out.println(sum.apply(5, 10)); // Saída: 15
 *
 * BiFunction<String, String, String> concat = (var s1, var s2) -> s1 + s2;
 * System.out.println(concat.apply("Hello, ", "World!")); // Saída: Hello, World!
 *
 */
public class VarEmParametrosLambdas{

    public static void main(String[] args) {

        var x = 100;
        Function<String, String> func = (var s) -> s + x;
        System.out.println(func.apply("Valor: ")); // Saída: Valor: 100

        BiFunction<Integer, Integer, Integer> sum = (var a, var b) -> a + b;
        System.out.println(sum.apply(5, 10)); // Saída: 15

        BiFunction<String, String, String> concat = (var s1,var s2) -> s1 + s2;
        System.out.println(concat.apply("Hello, ", "World!")); // Saída: Hello, World!

    }

}
