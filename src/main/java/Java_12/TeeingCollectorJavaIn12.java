package Java_12;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingCollectorJavaIn12{

    /**
     * Exemplo de uso do Teeing Collector (Java 12+).
     * EXEMPLO:
     * List<String> names = List.of("Alice", "Bob", "Charlie", "David");
     * Map<String, Integer> result = names.stream()
     *     .collect(Collectors.teeing(
     *         Collectors.counting(),
     *         Collectors.summingInt(String::length),
     *         (count, totalLength) -> Map.of("count", count.intValue(), "totalLength", totalLength)
     *     ));
     * System.out.println(result);
     * Saída: {count=4, totalLength=16}
     * VANTAGENS:
     * - Permite combinar dois coletores em um único coletor.
     * - Útil para calcular múltiplas estatísticas em uma única passagem pelo stream.
     * - Melhora a legibilidade do código ao evitar múltiplas operações de coleta.
     * OBSERVAÇÃO:
     * - Requer Java 12 ou superior.
     * - Pode ser usado com qualquer tipo de stream.
     * - Útil para cenários onde múltiplas agregações são necessárias.
     * EXEMPLO DE USO:
     * List<String> names = List.of("Alice", "Bob", "Charlie", "David");
     * Map<String, Integer> result = names.stream()
     *     .collect(Collectors.teeing(
     *         Collectors.counting(),
     *         Collectors.summingInt(String::length),
     *         (count, totalLength) -> Map.of("count", count.intValue(), "totalLength", totalLength)
     *     ));
     * System.out.println(result);
     * Saída: {count=4, totalLength=16}
     */

    // Usar BiFunction para combinar os resultados dos dois coletores e retornar um Map com as estatísticas desejadas
    public static void main(String[] args){

        // Collector.teeing(soma, qtde, média);
        double resultadoStream = Stream.of(20, 30, 50, 120, 11, 22, 99, 100)
                .collect(Collectors.teeing(Collectors
                        .summingDouble(i -> i),
                        Collectors.counting(),
                        (soma, qtde) -> soma / qtde));
        System.out.println("Média: " + resultadoStream);
    }

}
