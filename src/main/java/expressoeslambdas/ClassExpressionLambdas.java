package expressoeslambdas;

import java.util.List;

public class ClassExpressionLambdas{

    // main method
    public static void main(String[] args) {

        // exemplo de uso de expressões lambdas com streams
        String frase = "Java é uma linguagem de programação funcional";
        System.out.println("--------------------------------------------------");
        System.out.println("Frase original: " + frase);
        long count = frase.chars() // transforma a string em um stream de caracteres
                .filter(c -> c == 'a' || c == 'A') // filtra os caracteres 'a' ou 'A'
                .count(); // conta quantos caracteres passaram pelo filtro

        System.out.println("Número de letras 'a' ou 'A' na frase: " + count);

        System.out.println("--------------------------------------------------");

        // tratando listas com expressões lambdas
        String[] nomes = {"Ana", "Pedro", "Juliana", "Luca", "Mariana"};
        List<String> listaNomes = List.of(nomes);
        System.out.println("--------------------------------------------------");
        listaNomes.stream()
                .filter(nome -> nome.startsWith("A")) // filtro
                .forEach(nome -> System.out.println("Nome que começa com A: " + nome));
        System.out.println("--------------------------------------------------");

        // Runnable tradicional: classes anonimas
        Runnable tarefaTradicional = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Executando tarefa na thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Tradicional: lambdas com threads com argumentos usando ->
        Runnable tarefa = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Executando tarefa na thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        // lambda expression to implement the interface
        Operacao soma = (a, b) -> a + b;
        Operacao subtracao = (a, b) -> a - b;
        Operacao multiplicacao = (a, b) -> a * b;
        Operacao divisao = (a, b) -> a / b;

        System.out.println("10 + 5 = " + soma.operar(10, 5));
        System.out.println("10 - 5 = " + subtracao.operar(10, 5));
        System.out.println("10 * 5 = " + multiplicacao.operar(10, 5));
        System.out.println("10 / 5 = " + divisao.operar(10, 5));

    }

    public interface Operacao {
        int operar(int a, int b);
    }

}
