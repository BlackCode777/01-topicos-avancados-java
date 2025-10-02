package Java_9_sistemademodulos_Jigsaw.inferenciaDeTiposEmClassesInternasAnonimas;

public class MainSomaTudo_ITCIA{

    /**
     * New feature in Java 9: Type inference in anonymous inner classes
     * This allows the compiler to infer the type parameter T from the context
     * when creating an instance of the anonymous inner class.
     */
    public static void main(String[] args) {

        /**
         * Before Java 9, you would have to specify the type parameter explicitly like this:
         * SomaTudo_ITCIA<Integer> somaInteiros = new SomaTudo_ITCIA<Integer>() {
         *     @Override
         *     public Integer soma(Integer a, Integer b) {
         *         return a + b;
         *     }
         * };
         */
        SomaTudo_ITCIA<String> somaString = new SomaTudo_ITCIA<>() {
            @Override
            public String soma(String a, String b) {
                return (a+b);
            }
        };

        System.out.println(somaString.soma("Anderson", " Olá Mundo!"));
    }

}
