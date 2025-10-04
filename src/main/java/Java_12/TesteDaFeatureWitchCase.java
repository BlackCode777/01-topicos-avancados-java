package Java_12;

import java.util.Scanner;

/**
 * Exemplo de uso do switch com múltiplas labels e expressão switch em Java 12
 * EXEMPLO:
 * switch (variable) {
 *     case "value1", "value2" -> // ação para value1 ou value2
 *     case "value3" -> // ação para value3
 *     default -> // ação padrão
 * }
 *
 * VANTAGENS:
 * - Sintaxe mais concisa e legível.
 * - Permite múltiplas labels em um único case.
 * - Suporta expressões que retornam valores.
 *
 * OBSERVAÇÃO:
 * - Requer Java 12 ou superior.
 * - Nem todos os ambientes podem suportar essa sintaxe.
 * - Útil para simplificar lógica de seleção baseada em valores discretos.
 * EXEMPLO DE USO:
 * String resultado = switch (dia) {
 *     case "1", "2", "3", "4", "5" -> "Dia útil";
 *     case "6", "7" -> "Final de semana";
 *     default -> "Dia inválido";
 * };
 */
public class TesteDaFeatureWitchCase{

    public static void main(String[] args) {
        System.out.println("Digite o dia da semana (1-7):");

        Scanner scanner = new Scanner(System.in);
        String dia = scanner.nextLine();

        scanner.close();

        String resultado = "";
        switch (dia) {
            case "1", "2", "3", "4", "5" -> resultado = "Dia útil";
            case "6", "7" -> resultado = "Final de semana";
            default -> resultado = "Dia inválido";
        }
        System.out.println("Resultado: " + resultado);

        switch (dia) {
            case "1" -> resultado = "Segunda-feira";
            case "2" -> resultado = "Terça-feira";
            case "3" -> resultado = "Quarta-feira";
            case "4" -> resultado = "Quinta-feira";
            case "5" -> resultado = "Sexta-feira";
            case "6" -> resultado = "Sábado";
            case "7" -> resultado = "Domingo";
            default -> resultado = "Dia inválido";
        };

        System.out.println("Dia da semana: " + resultado);
    }

}
