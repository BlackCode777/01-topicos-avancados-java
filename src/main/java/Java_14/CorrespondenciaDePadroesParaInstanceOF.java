package Java_14;

/**
 * A partir do Java 14, o operador "instanceof" foi aprimorado para incluir correspondência de padrões (pattern matching).
 * Isso significa que você pode combinar a verificação de tipo com a declaração de uma variável em uma única expressão.
 *
 * Antes do Java 14, você precisava fazer uma verificação de tipo e, em seguida, fazer um cast explícito:
 *
 * if (obj instanceof String) {
 *     String str = (String) obj;
 *     // use str
 * }
 *
 * Com o Java 14 e o pattern matching para "instanceof", você pode simplificar isso:
 *
 * if (obj instanceof String str) {
 *     // use str diretamente
 * }
 *
 * Isso torna o código mais conciso e legível, eliminando a necessidade de um cast explícito.
 * Além disso, a variável declarada (neste caso, "str") só está disponível dentro do bloco onde a verificação é verdadeira.
 *
 * Exemplo:
 * * Object obj = "Hello, World!";
 * * if (obj instanceof String str) {
 * *     System.out.println(str.toUpperCase());
 * * }
 * Neste exemplo, se "obj" for uma instância de String, a variável "str" será automaticamente declarada e inicializada com o valor de "obj",
 * permitindo o uso direto dentro do bloco "if".
 *
 * Essa funcionalidade melhora a clareza do código e reduz a possibilidade de erros relacionados a casts incorretos.
 *
 */
public class CorrespondenciaDePadroesParaInstanceOF{

    public static void main(String[] args){
        Animal animal1 = new Animal("Gato");
        Animal animal2 = new Animal("Cachorro");

        if (animal1 instanceof Animal a && a.getEspecie().equals("Gato")){
            Gato gato = new Gato("Mingau", 3);
            System.out.println("É um gato chamado: "+gato.getNome()+" com idade: "+gato.getIdade());
            gato.miar();
        }

        if (animal2 instanceof Animal a && a.getEspecie().equals("Cachorro")){
            Cachorro cachorro = new Cachorro("Rex", 5);
            System.out.println("É um cachorro chamado: "+cachorro.getNome()+" com idade: "+cachorro.getIdade());
            cachorro.latir();
        }
    }

}

class Animal{
    String especie;

    public Animal(String especie){
        this.especie=especie;
    }

    public String getEspecie(){return especie;}
}

class Gato{
    String nome;
    int idade;

    public Gato(String nome, int idade){
        this.nome=nome;
        this.idade=idade;
    }

    public void miar(){System.out.println("Miau Miau!");}
    public String getNome(){return nome;}
    public int getIdade(){return idade;}
}

class Cachorro{
    String nome;
    int idade;

    public Cachorro(String nome, int idade){
        this.nome=nome;
        this.idade=idade;
    }

    public void latir(){System.out.println("Au Au!");}
    public String getNome(){return nome;}
    public int getIdade(){return idade;}
}