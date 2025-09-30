package inferenciaDeTiposExemplo;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Repeatable(Voltagens.class)
@interface Voltagem{
    String tensao();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Voltagens{
    Voltagem[] value();
}

@Voltagem(tensao = "110V")
@Voltagem(tensao = "220V")
public class Produto{
    private String nome;
    private double preco;

    public Produto(String nome,double preco){
        this.nome=nome;
        this.preco=preco;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }

    public static void main(String[] args){
        Voltagem[] voltagens = Produto.class.getAnnotationsByType(Voltagem.class);
        for(Voltagem v : voltagens){
            System.out.println("Tensão: " + v.tensao());
        }
    }

}
