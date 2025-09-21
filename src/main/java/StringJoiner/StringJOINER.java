package StringJoiner;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringJOINER{

    /**
     * - STRINGTOKENIZER:
     *
     * Classe pertencente ao pacote java.util, utilizada para construir sequências de
     * caracteres (Strings) de maneira eficiente e flexível. Ela permite concatenar
     * múltiplas strings com um delimitador especificado, além de oferecer opções
     * para prefixos e sufixos.
     */

    // EXEMPLO - 01
    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Apple");
        joiner.add("Banana");
        joiner.add("Cherry");
        System.out.println(joiner.toString()); // Output: [Apple, Banana, Cherry]

        String nome = "Blackcode, Dev, Java, Springboot, Angular, React, Vue";
        StringTokenizer st = new StringTokenizer(nome, ", ");// delimitador , e espaço
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

        // EXEMPLO - 02:  Média complexidade
        String nomes = "Alice,Bob,Charlie,David";
        StringTokenizer tokenizer = new StringTokenizer(nomes, ",");
        StringJoiner joiner2 = new StringJoiner(" | ", "<", ">");
        while (tokenizer.hasMoreTokens()) {
            joiner2.add(tokenizer.nextToken().trim());
        }
        System.out.println(joiner2.toString()); // Output: <Alice | Bob | Charlie | David>

        System.out.println("***********************************");

        // EXEMPLO - 03: Alta complexidade
        String data = "2024-06-15 14:30:00,2024-06-16 09:15:00,2024-06-17 18:45:00";
        StringTokenizer tokenizer3 = new StringTokenizer(data, ","); // delimitador vírgula
        StringJoiner joiner3 = new StringJoiner(" ; ", "{", "}"); // delimitador ponto e vírgula
        while (tokenizer3.hasMoreTokens()){
            String dateTime=tokenizer3.nextToken().trim();
            String[] parts=dateTime.split(" ");
            if (parts.length==2){
                String date=parts[0];
                String time=parts[1];
                joiner3.add("Date: "+date+", Time: "+time);

                // Output: {Date: 2024-06-15, Time: 14:30:00 ; Date: 2024-06-16, Time: 09:15:00 ; Date: 2024-06-17, Time: 18:45:00}
                System.out.println(joiner3.toString());
            }
        }

        System.out.println("***********************************");

        // EXEMPLO - 04: Alta complexidade com validação
        String produtos = "Laptop:1200.50, Smartphone:800.00, Tablet:450.75";
        StringTokenizer tokenizer4 = new StringTokenizer(produtos, ",");
        StringJoiner joiner4 = new StringJoiner(" | ", "<", ">");
        while (tokenizer4.hasMoreTokens()){
            String produtoPreco=tokenizer4.nextToken().trim();
            String[] parts=produtoPreco.split(":");
            if (parts.length==2){
                String produto=parts[0].trim();
                String precoStr=parts[1].trim();
                try{
                    double preco=Double.parseDouble(precoStr);
                    joiner4.add(produto+" ($"+String.format("%.2f",preco)+")");
                }catch (NumberFormatException e){
                    System.out.println("Preço inválido para o produto: "+produto);
                }
                // Output: <Laptop ($1200.50) | Smartphone ($800.00) | Tablet ($450.75)>
                System.out.println(joiner4.toString());
            }
        }

        System.out.println("***********************************");

    }
}
