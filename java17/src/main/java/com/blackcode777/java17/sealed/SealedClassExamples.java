package com.blackcode777.java17.sealed;

/**
 * Demonstra o uso de Sealed Classes introduzidas no Java 17
 * 
 * Sealed Classes permitem controlar quais classes podem estender/implementar uma classe/interface
 */
public class SealedClassExamples {
    
    public static void demonstrateSealedClasses() {
        System.out.println("--- Sealed Classes ---");
        
        // Criando instâncias das classes seladas
        Forma circulo = new Circulo(5.0);
        Forma retangulo = new Retangulo(4.0, 6.0);
        Forma triangulo = new Triangulo(3.0, 4.0, 5.0);
        
        System.out.println("Círculo - Área: " + calcularArea(circulo));
        System.out.println("Retângulo - Área: " + calcularArea(retangulo));
        System.out.println("Triângulo - Área: " + calcularArea(triangulo));
        
        // Demonstrar veiculo selado
        demonstrateVehicle();
        
        // Demonstrar resultado selado
        demonstrateResult();
    }
    
    private static double calcularArea(Forma forma) {
        // Pattern matching com sealed classes usando instanceof (Java 17)
        if (forma instanceof Circulo c) {
            return Math.PI * c.raio() * c.raio();
        } else if (forma instanceof Retangulo r) {
            return r.largura() * r.altura();
        } else if (forma instanceof Triangulo t) {
            // Fórmula de Heron
            double s = (t.lado1() + t.lado2() + t.lado3()) / 2.0;
            return Math.sqrt(s * (s - t.lado1()) * (s - t.lado2()) * (s - t.lado3()));
        } else {
            throw new IllegalArgumentException("Tipo de forma não suportado");
        }
    }
    
    private static void demonstrateVehicle() {
        System.out.println("\n--- Sealed Vehicle ---");
        
        Veiculo carro = new Carro("Honda", "Civic", 4);
        Veiculo moto = new Motocicleta("Yamaha", "MT-07", 689);
        Veiculo bicicleta = new Bicicleta("Trek", "FX 3", false);
        
        System.out.println("Carro: " + descreverVeiculo(carro));
        System.out.println("Moto: " + descreverVeiculo(moto));
        System.out.println("Bicicleta: " + descreverVeiculo(bicicleta));
    }
    
    private static String descreverVeiculo(Veiculo veiculo) {
        if (veiculo instanceof Carro c) {
            return String.format("%s %s com %d portas", c.marca(), c.modelo(), c.portas());
        } else if (veiculo instanceof Motocicleta m) {
            return String.format("%s %s com motor %dcc", m.marca(), m.modelo(), m.cilindradas());
        } else if (veiculo instanceof Bicicleta b) {
            return String.format("%s %s %s", b.marca(), b.modelo(), 
                               b.eletrica() ? "(elétrica)" : "(convencional)");
        } else {
            return "Veículo desconhecido";
        }
    }
    
    private static void demonstrateResult() {
        System.out.println("\n--- Sealed Result ---");
        
        Resultado<String> sucesso = new Sucesso<>("Operação realizada com sucesso!");
        Resultado<String> erro = new Erro<>("Falha na operação");
        
        System.out.println("Sucesso: " + processarResultado(sucesso));
        System.out.println("Erro: " + processarResultado(erro));
    }
    
    private static <T> String processarResultado(Resultado<T> resultado) {
        if (resultado instanceof Sucesso<T> s) {
            return "✓ " + s.valor();
        } else if (resultado instanceof Erro<T> e) {
            return "✗ " + e.mensagem();
        } else {
            return "Resultado desconhecido";
        }
    }
}

// Sealed classes para formas geométricas
sealed interface Forma 
    permits Circulo, Retangulo, Triangulo {
}

record Circulo(double raio) implements Forma {}
record Retangulo(double largura, double altura) implements Forma {}
record Triangulo(double lado1, double lado2, double lado3) implements Forma {}

// Sealed classes para veículos
sealed abstract class Veiculo 
    permits Carro, Motocicleta, Bicicleta {
    
    private final String marca;
    private final String modelo;
    
    protected Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public String marca() { return marca; }
    public String modelo() { return modelo; }
}

final class Carro extends Veiculo {
    private final int portas;
    
    public Carro(String marca, String modelo, int portas) {
        super(marca, modelo);
        this.portas = portas;
    }
    
    public int portas() { return portas; }
}

final class Motocicleta extends Veiculo {
    private final int cilindradas;
    
    public Motocicleta(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }
    
    public int cilindradas() { return cilindradas; }
}

final class Bicicleta extends Veiculo {
    private final boolean eletrica;
    
    public Bicicleta(String marca, String modelo, boolean eletrica) {
        super(marca, modelo);
        this.eletrica = eletrica;
    }
    
    public boolean eletrica() { return eletrica; }
}

// Sealed classes para representar resultado de operações
sealed interface Resultado<T> 
    permits Sucesso, Erro {
}

record Sucesso<T>(T valor) implements Resultado<T> {}
record Erro<T>(String mensagem) implements Resultado<T> {}