package com.blackcode777.java8.lambda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Testes para funcionalidades de Lambda Expressions do Java 8
 */
class LambdaExamplesTest {

    @Test
    @DisplayName("Deve ordenar lista usando lambda")
    void deveOrdenarListaUsandoLambda() {
        // Arrange
        List<String> nomes = Arrays.asList("Carlos", "Ana", "Bruno");
        List<String> esperado = Arrays.asList("Ana", "Bruno", "Carlos");
        
        // Act
        nomes.sort((a, b) -> a.compareTo(b));
        
        // Assert
        assertEquals(esperado, nomes);
    }
    
    @Test
    @DisplayName("Deve filtrar nomes usando Predicate")
    void deveFiltrarNomesUsandoPredicate() {
        // Arrange
        Predicate<String> isLongName = name -> name.length() > 5;
        
        // Act & Assert
        assertTrue(isLongName.test("Carlos"));
        assertFalse(isLongName.test("Ana"));
        assertTrue(isLongName.test("Roberto"));
    }
    
    @Test
    @DisplayName("Deve transformar string em maiúscula usando method reference")
    void deveTransformarStringEmMaiusculaUsandoMethodReference() {
        // Arrange
        List<String> palavras = Arrays.asList("java", "lambda", "stream");
        
        // Act
        List<String> maiusculas = palavras.stream()
            .map(String::toUpperCase)
            .collect(java.util.stream.Collectors.toList());
        
        // Assert
        List<String> esperado = Arrays.asList("JAVA", "LAMBDA", "STREAM");
        assertEquals(esperado, maiusculas);
    }
}