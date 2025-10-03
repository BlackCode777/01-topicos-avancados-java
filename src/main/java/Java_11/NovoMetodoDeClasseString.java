package Java_11;

/**
 * Novos métodos da classe String em Java 11
 * EXEMPLO:
 * isBlank(): Verifica se a string está vazia ou contém apenas espaços em branco.
 * lines(): Retorna um stream de linhas da string.
 * strip(): Remove espaços em branco do início e do fim da string.
 * repeat(int count): Repete a string um número especificado de vezes.
 * EXEMPLO DE USO:
 * String str = "   Hello, World!   ";
 * System.out.println(str.isBlank()); // false
 * System.out.println(str.strip()); // "Hello, World!"
 * System.out.println(str.repeat(3)); // "   Hello, World!      Hello, World!      Hello, World!   "
 * String multiline = "Line1\nLine2\nLine3";
 * multiline.lines().forEach(System.out::println);
 * Saída:
 * Line1
 * Line2
 * Line3
 */
public class NovoMetodoDeClasseString{

    public static void main(String[] args) {

        String str = "         ";
        String str1 = "";
        String str2 = "Hello, World!";

        String multiLine = "Line1\nLine2\nLine3";
        multiLine.lines().forEach(System.out::println);

        System.out.println(str.isBlank());
        System.out.println(str1.isBlank());
        System.out.println(str2.isBlank());

        System.out.println(str.strip());
        System.out.println(str1.strip());
        System.out.println(str2.strip());

        System.out.println(str.repeat(3));
        System.out.println(str1.repeat(3));
        System.out.println(str2.repeat(3));

    }

}
