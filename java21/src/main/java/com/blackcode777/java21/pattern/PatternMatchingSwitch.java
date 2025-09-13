package com.blackcode777.java21.pattern;

/**
 * Demonstra o uso de Pattern Matching for switch (conceito do Java 21)
 * 
 * NOTA: Este código usa Java 17 e simula recursos que estarão no Java 21.
 * No Java 21, pattern matching in switch é finalizado.
 */
public class PatternMatchingSwitch {
    
    public static void demonstratePatternMatchingSwitch() {
        System.out.println("--- Pattern Matching for switch ---");
        
        // Exemplo 1: Pattern matching básico
        demonstrateBasicPatternMatching();
        
        // Exemplo 2: Pattern matching com guarded patterns
        demonstrateGuardedPatterns();
        
        // Exemplo 3: Pattern matching com sealed classes
        demonstrateSealedClassPatterns();
    }
    
    private static void demonstrateBasicPatternMatching() {
        System.out.println("\n--- Pattern Matching Básico (Simulação Java 21) ---");
        System.out.println("NOTA: No Java 21, a sintaxe seria mais concisa");
        
        Object[] objetos = {
            "Hello World",
            42,
            3.14,
            java.util.List.of(1, 2, 3),
            new int[]{1, 2, 3, 4, 5},
            null
        };
        
        for (Object obj : objetos) {
            String resultado;
            if (obj instanceof String s) {
                resultado = "String com " + s.length() + " caracteres: '" + s + "'";
            } else if (obj instanceof Integer i) {
                resultado = "Integer: " + i + " (par: " + (i % 2 == 0) + ")";
            } else if (obj instanceof Double d) {
                resultado = "Double: " + d + " (inteiro: " + (d % 1 == 0) + ")";
            } else if (obj instanceof java.util.List<?> list) {
                resultado = "Lista com " + list.size() + " elementos";
            } else if (obj instanceof int[] array) {
                resultado = "Array de int com " + array.length + " elementos";
            } else if (obj == null) {
                resultado = "Valor nulo";
            } else {
                resultado = "Tipo não reconhecido: " + obj.getClass().getSimpleName();
            }
            
            System.out.println(resultado);
        }
    }
    
    private static void demonstrateGuardedPatterns() {
        System.out.println("\n--- Guarded Patterns (Simulação Java 21) ---");
        
        Object[] objetos = {
            "Java",
            "Hello World", 
            "",
            42,
            -5,
            0,
            java.util.List.of(),
            java.util.List.of(1, 2, 3, 4, 5, 6)
        };
        
        for (Object obj : objetos) {
            String resultado;
            if (obj instanceof String s) {
                if (s.isEmpty()) {
                    resultado = "String vazia";
                } else if (s.length() < 5) {
                    resultado = "String curta: '" + s + "'";
                } else if (s.length() >= 10) {
                    resultado = "String longa: '" + s + "'";
                } else {
                    resultado = "String média: '" + s + "'";
                }
            } else if (obj instanceof Integer i) {
                if (i > 0) {
                    resultado = "Número positivo: " + i;
                } else if (i < 0) {
                    resultado = "Número negativo: " + i;
                } else {
                    resultado = "Zero";
                }
            } else if (obj instanceof java.util.List<?> list) {
                if (list.isEmpty()) {
                    resultado = "Lista vazia";
                } else if (list.size() > 5) {
                    resultado = "Lista grande com " + list.size() + " elementos";
                } else {
                    resultado = "Lista pequena com " + list.size() + " elementos";
                }
            } else {
                resultado = "Outro tipo: " + obj.getClass().getSimpleName();
            }
            
            System.out.println(resultado);
        }
    }
    
    private static void demonstrateSealedClassPatterns() {
        System.out.println("\n--- Sealed Class Patterns (Simulação Java 21) ---");
        
        Forma[] formas = {
            new Circulo(5.0),
            new Retangulo(4.0, 6.0),
            new Triangulo(3.0, 4.0, 5.0)
        };
        
        for (Forma forma : formas) {
            double area;
            if (forma instanceof Circulo c) {
                System.out.println("Calculando área do círculo com raio " + c.raio());
                area = Math.PI * c.raio() * c.raio();
            } else if (forma instanceof Retangulo r) {
                System.out.println("Calculando área do retângulo " + r.largura() + "x" + r.altura());
                area = r.largura() * r.altura();
            } else if (forma instanceof Triangulo t) {
                System.out.println("Calculando área do triângulo com lados " + t.lado1() + ", " + t.lado2() + ", " + t.lado3());
                double s = (t.lado1() + t.lado2() + t.lado3()) / 2.0;
                area = Math.sqrt(s * (s - t.lado1()) * (s - t.lado2()) * (s - t.lado3()));
            } else {
                area = 0;
            }
            
            System.out.println("Área: " + String.format("%.2f", area));
            System.out.println();
        }
        
        // Exemplo com classificação
        for (Forma forma : formas) {
            String classificacao;
            if (forma instanceof Circulo c) {
                if (c.raio() > 10) {
                    classificacao = "Círculo grande";
                } else if (c.raio() > 5) {
                    classificacao = "Círculo médio";
                } else {
                    classificacao = "Círculo pequeno";
                }
            } else if (forma instanceof Retangulo r) {
                if (r.largura() == r.altura()) {
                    classificacao = "Quadrado " + r.largura() + "x" + r.altura();
                } else if (r.largura() > r.altura()) {
                    classificacao = "Retângulo horizontal";
                } else {
                    classificacao = "Retângulo vertical";
                }
            } else if (forma instanceof Triangulo t) {
                if (t.lado1() == t.lado2() && t.lado2() == t.lado3()) {
                    classificacao = "Triângulo equilátero";
                } else if (t.lado1() == t.lado2() || t.lado2() == t.lado3() || t.lado1() == t.lado3()) {
                    classificacao = "Triângulo isósceles";
                } else {
                    classificacao = "Triângulo escaleno";
                }
            } else {
                classificacao = "Forma desconhecida";
            }
            
            System.out.println(classificacao);
        }
    }
}

// Sealed classes para demonstrar pattern matching
sealed interface Forma 
    permits Circulo, Retangulo, Triangulo {
}

record Circulo(double raio) implements Forma {
    public Circulo {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser positivo");
        }
    }
}

record Retangulo(double largura, double altura) implements Forma {
    public Retangulo {
        if (largura <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Dimensões devem ser positivas");
        }
    }
}

record Triangulo(double lado1, double lado2, double lado3) implements Forma {
    public Triangulo {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new IllegalArgumentException("Lados devem ser positivos");
        }
        if (lado1 + lado2 <= lado3 || lado1 + lado3 <= lado2 || lado2 + lado3 <= lado1) {
            throw new IllegalArgumentException("Não forma um triângulo válido");
        }
    }
}