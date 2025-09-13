package STREAM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<String> emails = List.of(" emai_01@email.com ",
                " email_02@email.com ", " email_03@email.com ",
                " email_04@email.com", "email_05@email.com" );

        List<Object> pessoas =Collections.singletonList(new ArrayList<>(List.of(nomes,idades,salarios,emails))
                .stream()
                .map(lista->{
                    if (lista instanceof List){
                        List<?> lst=(List<?>)lista;
                        if (!lst.isEmpty()){
                            Object firstElement=lst.get(0);
                            if (firstElement instanceof String){
                                return ((List<String>)lst).stream()
                                        .map(String::trim) // Remove espaços em branco
                                        .map(String::toUpperCase) // Converte para maiúsculas
                                        .toList();
                            }else if (firstElement instanceof Integer){
                                return ((List<Integer>)lst).stream()
                                        .filter(age->age>=18) // Filtra maiores de idade
                                        .toList();
                            }else if (firstElement instanceof Double){
                                return ((List<Double>)lst).stream()
                                        .map(salary->salary*1.1) // Aumenta o salário em 10%
                                        .toList();
                            }
                        }
                    }
                    return lista; // Retorna a lista original se não for processada
                }).toList());

        System.out.println("Lista de pessoas: " + pessoas);

    }


}
