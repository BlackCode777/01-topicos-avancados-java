package Java_8.inferenciaDeTiposExemplo.reflexaoDeMetodosParametrosExemplo;

import Java_8.inferenciaDeTiposExemplo.Produto;

import java.lang.reflect.Method;

public class ReflexaoDeMetodosParametros{

    /**
     * * A reflexão de métodos com parâmetros em Java permite que você inspecione e manipule métodos de uma classe em tempo de execução, mesmo que você não conheça os detalhes da classe em tempo de compilação.
     * * Isso é feito usando a API de reflexão do Java, que fornece classes como `Method` e `Parameter` para acessar informações sobre os métodos e seus parâmetros.
     * * Com a reflexão, você pode obter uma lista dos métodos disponíveis em uma classe, verificar seus nomes, tipos de retorno e tipos de parâmetros, e até mesmo invocar esses métodos dinamicamente.
     * * A reflexão é útil em cenários onde você precisa trabalhar com classes desconhecidas ou quando está desenvolvendo frameworks e bibliotecas que precisam ser flexíveis e adaptáveis a diferentes tipos de objetos.
     * * No entanto, o uso excessivo da reflexão pode levar a problemas de desempenho e segurança, pois envolve operações mais complexas do que o acesso direto aos métodos.
     * * Exemplo:
     * * ```java
     * * import java.lang.reflect.Method;
     * * import java.lang.reflect.Parameter;
     * *
     * * public class ExemploReflexao {
     * *     public void meuMetodo(String nome, int idade) {
     * *         // implementação do método
     * *     }
     * *
     * *     public static void main(String[] args) throws Exception {
     * *         Class<?> clazz = ExemploReflexao.class;
     * *         Method metodo = clazz.getMethod("meuMetodo", String.class, int.class);
     * *
     * *         System.out.println("Nome do método: " + metodo.getName());
     * *
     * *         Parameter[] parametros = metodo.getParameters();
     * *         for (Parameter parametro : parametros) {
     * *             System.out.println("Parâmetro: " + parametro.getName() + ", Tipo: " + parametro.getType().getName());
     * *         }
     * *
     * *         // Invocando o método dinamicamente
     * *         ExemploReflexao instancia = new ExemploReflexao();
     * *         metodo.invoke(instancia, "João", 30);
     * *     }
     * * }
     * * ```
     *
     * @param args
     * @return void
     * @throws Exception
     *
     *  Usaremos a classe produto em 'package inferenciaDeTiposExemplo;'
    */

    public static void main(String[] args) throws Exception{
        Produto produto = new Produto("Notebook", 2500.00);
        Class cl = produto.getClass();
        Method[] method = cl.getDeclaredMethods();


        for(Method m : method){
            System.out.println("Nome do método: " + m.getName());
            System.out.println("Tipo de retorno: " + m.getReturnType().getName());
            System.out.println("Parâmetros:");
            java.lang.reflect.Parameter[] parametros = m.getParameters();
            for(java.lang.reflect.Parameter p : parametros){
                System.out.println(" - " + p.getName() + ": " + p.getType().getName());
            }
            System.out.println("--------------------------------------------------");
        }
    }



}
