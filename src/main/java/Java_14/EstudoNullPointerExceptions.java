package Java_14;


/**
 * A partir do java 14, a JVM fornece mais detalhes sobre onde exatamente a NullPointerException ocorreu.
 * Isso ajuda muito na hora de debugar o código.
 * Antes do Java 14, a mensagem de erro simplesmente indicava que uma NullPointerException ocorreu,
 * sem fornecer informações adicionais sobre a linha específica ou a expressão que causou o problema.
 * Com o Java 14, a mensagem de erro agora inclui detalhes como o nome da variável ou expressão que era nula,
 * bem como a linha exata do código onde a exceção foi lançada. Isso facilita a identificação e correção do problema.
 *
 * Exemplo:
 *
 * Antes do Java 14:
 * Exception in thread "main" java.lang.NullPointerException
 *     at Java_14.EstudoNullPointerExceptions.main(EstudoNullPointerExceptions.java:10)
 *
 * Após o Java 14:
 * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.substring(int, int)" because "a.getNome()" is null
 *    at Java_14.EstudoNullPointerExceptions.main(EstudoNullPointerExceptions.java:10)
 *
 */

public class EstudoNullPointerExceptions{

    public static void main(String[] args){
        Aluno a = new Aluno();
        a.getNome().substring(0,1);
    }
}

class Aluno{
    String nome;

    public Aluno(){
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
}