package optional;

import java.util.Optional;

public class OptionalEstudo{

    /**
     * Java Optional é uma classe contêiner introduzida no Java 8 que pode ou não
     * conter um valor não nulo. Ela é usada para evitar problemas relacionados a
     * valores nulos, como NullPointerException, e para representar a presença ou
     * ausência de um valor de forma mais explícita.
     *
     * Principais características do Optional:
     * - Criação: Você pode criar um Optional usando os métodos estáticos
     *   Optional.of(valor) (para valores não nulos), Optional.ofNullable(valor)
     *   (para valores que podem ser nulos) e Optional.empty() (para um Optional
     *   vazio).
     *   - Verificação de Presença: Você pode verificar se um valor está presente
     *   usando o método isPresent() ou ifPresent(Consumer).
     *   - Acesso ao Valor: Para acessar o valor contido em um Optional, você pode
     *   usar o método get(), mas é recomendado usar métodos como orElse(valor
     *   padrão), orElseGet(Supplier) ou orElseThrow(Supplier) para lidar com a
     *   ausência de valor de forma mais segura.
     *   - Transformação: Você pode transformar o valor contido em um Optional
     *   usando o método map(Function) ou flatMap(Function).
     *   - Filtragem: Você pode filtrar o valor contido em um Optional usando o
     *   método filter(Predicate).
     *   - Uso Com Coleções: Optional pode ser usado em conjunto com streams e outras
     *   operações de coleção para manipular valores de forma funcional.
     */

    public static void main(String[] args){
        // Exemplo básico de uso do Optional
        Optional<String> optionalNome=Optional.of("Blackcode");
        optionalNome.ifPresent(nome->System.out.println("Nome: "+nome));

        System.out.println("***********************************");

        // Exemplo com valor ausente
        Optional<String> optionalVazio=Optional.empty();
        System.out.println("Valor presente? "+optionalVazio.isPresent());

        System.out.println("***********************************");

        // Usando orElse para fornecer um valor padrão
        String nomeOuPadrao=optionalVazio.orElse("Nome Padrão");
        System.out.println("Nome ou padrão: "+nomeOuPadrao);

        System.out.println("***********************************");

        // Usando map para transformar o valor se presente
        Optional<Integer> comprimentoNome=optionalNome.map(String::length);
        comprimentoNome.ifPresent(len->System.out.println("Comprimento do nome: "+len));

        System.out.println("***********************************");

        Optional<Optional<String>> optionalAninhado = Optional.of(Optional.of("Valor Interno"));
        Optional<String> valorDesaninhado = optionalAninhado.flatMap(opt->opt);
        valorDesaninhado.ifPresent(val->System.out.println("Valor desaninhado: "+val));

        System.out.println("Conteúdo do optionalNome: " + optionalNome.orElse("Vazio"));
        System.out.println("Conteúdo do optionalVazio: " + optionalVazio.orElse("Vazio"));
        System.out.println("Conteúdo do comprimentoNome: " + comprimentoNome.orElse(-1));
        System.out.println("Conteúdo do valorDesaninhado: " + valorDesaninhado.orElse("Vazio"));



    }

}
