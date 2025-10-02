package Java_9_sistemademodulos_Jigsaw.inferenciaDeTiposEmClassesInternasAnonimas;

public interface SomaTudo_ITCIA<T>{

    /**
     * New feature in Java 9: Type inference in anonymous inner classes
     * This allows the compiler to infer the type parameter T from the context
     * when creating an instance of the anonymous inner class.
     */
    T soma(T a, T b);

}
