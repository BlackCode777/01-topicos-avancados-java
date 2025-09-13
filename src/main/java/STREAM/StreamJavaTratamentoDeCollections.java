package STREAM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJavaTratamentoDeCollections{

    /**
     * Stream API em Java é uma poderosa ferramenta introduzida no Java 8 que
     * permite processar coleções de dados de maneira funcional e declarativa.
     * Ela facilita operações como filtragem, mapeamento, redução e coleta de dados,
     * tornando o código mais legível e conciso.
     *
     * Exemplo básico de uso da Stream API:
     *
     * import java.util.Arrays;
     * import java.util.List;
     * import java.util.stream.Collectors;
     *
     * public class StreamExample {
     *    public static void main(String[] args) {
     *    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
     *    List<Integer> evenNumbers = numbers.stream() // Cria uma stream a partir da lista
     *    .filter(n -> n % 2 == 0) // Filtra apenas os números pares
     *    .map(n -> n * n) // Mapeia para o quadrado dos números
     *    .collect(Collectors.toList()); // Coleta os resultados em uma nova lista
     *    System.out.println(evenNumbers); // Saída: [4, 16, 36]
     *    }
     */

    public static void main(String[] args) {

        List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Diana", "Eduardo");
        List<Integer> idades = List.of(23, 30, 18, 25, 40);
        List<Double> salarios = List.of(2500.0, 3200.5, 1500.75, 4000.0, 5000.25);
        List<String> emails = List.of(
                " emai_01@email.com ",
                " email_02@email.com ",
                " email_03@email.com ",
                " email_04@email.com",
                "email_05@email.com"
        );

        // Colete as listas heterogêneas em uma só
        List<List<?>> listas = List.of(nomes, idades, salarios, emails);

        // Saída achatada
        List<Object> listagem = new ArrayList<>();

        for (List<?> sub : listas) {
            if (sub.isEmpty()) continue;
            Object first = sub.get(0);

            if (first instanceof String) {
                for (Object o : sub) {
                    String s = ((String) o).trim().toUpperCase();
                    listagem.add(s);
                }
            } else if (first instanceof Integer) {
                for (Object o : sub) {
                    int i = (Integer) o;
                    if (i >= 18) {
                        listagem.add(i);
                    }
                }
            } else if (first instanceof Double) {
                for (Object o : sub) {
                    double d = (Double) o;
                    listagem.add(d * 1.10); // +10%
                }
            } else {
                // Tipo não tratado: adiciona como está
                listagem.addAll(sub);
            }
        }

        // Imprime listagem numerada
        for (int i = 0; i < listagem.size(); i++) {
            System.out.printf("%03d: %s%n", i + 1, listagem.get(i));
        }
    }
}