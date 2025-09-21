package metodoReferencia;

public class ClassMetodoReferencia{

    public static void main(String[] args) {
        // Reference to a static method
        Operacion operacionSuma = Calculadora::somar; // Static method reference
        int resultadoSuma = operacionSuma.operar(5, 3);

        System.out.println("Resultado de la suma: " + resultadoSuma);

        // Reference to an instance method
        Calculadora calculadora = new Calculadora();
        Operacion operacionResta = calculadora::restar; // Instance method reference
        int resultadoResta = operacionResta.operar(5, 3);
        System.out.println("Resultado de la resta: " + resultadoResta);

        // Reference to a constructor
        FabricaOperacion fabrica = () -> (a, b) -> a * b; // Default multiplication operation
        Operacion operacionMultiplicacion = fabrica.crearOperacion();
        int resultadoMultiplicacion = operacionMultiplicacion.operar(5, 3);
        System.out.println("Resultado de la multiplicación: " + resultadoMultiplicacion);
    }

    @FunctionalInterface
    public interface Operacion {
        int operar(int a, int b);
    }

    public static class Calculadora {
        public static int somar(int a, int b) {
            return a + b;
        }

        public int restar(int a, int b) {
            return a - b;
        }
    }

    @FunctionalInterface
    public interface FabricaOperacion {
        Operacion crearOperacion();
    }

}
