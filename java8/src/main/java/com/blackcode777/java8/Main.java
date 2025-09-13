package com.blackcode777.java8;

import com.blackcode777.java8.lambda.LambdaExamples;
import com.blackcode777.java8.streams.StreamExamples;
import com.blackcode777.java8.optional.OptionalExamples;
import com.blackcode777.java8.datetime.DateTimeExamples;

/**
 * Classe principal para demonstrar as funcionalidades do Java 8
 * 
 * Principais funcionalidades:
 * - Lambda Expressions
 * - Stream API
 * - Optional
 * - Date/Time API
 * - Default Methods
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== Java 8 - Tópicos Avançados ===\n");
        
        System.out.println("1. Lambda Expressions:");
        LambdaExamples.demonstrateLambdas();
        
        System.out.println("\n2. Stream API:");
        StreamExamples.demonstrateStreams();
        
        System.out.println("\n3. Optional:");
        OptionalExamples.demonstrateOptional();
        
        System.out.println("\n4. Date/Time API:");
        DateTimeExamples.demonstrateDateTime();
    }
}