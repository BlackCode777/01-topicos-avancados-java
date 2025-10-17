package Java_15;

/**
 * A partir do Java 15, embora os records sejam projetados para serem imutáveis,
 * é possível alterar seus valores usando reflexão (reflection).
 * No entanto, essa prática não é recomendada, pois viola o princípio de imutabilidade dos records
 * e pode levar a comportamentos inesperados no código.
 *
 * Exemplo:
 * Suponha que temos um record Produto com um campo final codigo.
 * Usando reflexão, podemos acessar esse campo e alterar seu valor, mesmo sendo final.
 *
 * Nota: Alterar campos finais via reflexão pode causar problemas de consistência e deve ser evitado em produção.
 *
 */
public class ReflexaoExemplo_ComoAlterarRecords{

    public static void main(String[] args) throws Exception{
        Produto produto = new Produto();
        System.out.println("Código original: " + produto.getCodigo());

        try{
            var field = Produto.class.getDeclaredField("codigo");
            field.setAccessible(true);

            // Removendo o modificador final usando reflexão
            var modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);

            // Alterando o valor do campo
            field.set(produto, 2002);

            System.out.println("Código alterado: " + produto.getCodigo());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}

class Produto{
    private final Integer codigo = 1001;
    public Integer getCodigo(){
        return codigo;
    }
}