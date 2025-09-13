package com.blackcode777.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Demonstra o uso da nova Date/Time API introduzida no Java 8
 */
public class DateTimeExamples {
    
    public static void demonstrateDateTime() {
        System.out.println("--- Date/Time API ---");
        
        // Exemplo 1: LocalDate, LocalTime, LocalDateTime
        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now();
        LocalDateTime agoraCompleto = LocalDateTime.now();
        
        System.out.println("Hoje: " + hoje);
        System.out.println("Agora: " + agora);
        System.out.println("Agora completo: " + agoraCompleto);
        
        // Exemplo 2: Criando datas específicas
        LocalDate natal = LocalDate.of(2024, 12, 25);
        LocalTime meianoite = LocalTime.of(0, 0, 0);
        LocalDateTime natalMeianoite = LocalDateTime.of(natal, meianoite);
        
        System.out.println("Natal 2024: " + natal);
        System.out.println("Natal à meia-noite: " + natalMeianoite);
        
        // Exemplo 3: Manipulação de datas
        demonstrateDateManipulation();
        
        // Exemplo 4: Formatação
        demonstrateDateFormatting();
        
        // Exemplo 5: Cálculos
        demonstrateDateCalculations();
        
        // Exemplo 6: ZonedDateTime
        demonstrateZonedDateTime();
    }
    
    private static void demonstrateDateManipulation() {
        System.out.println("\n--- Manipulação de Datas ---");
        
        LocalDate hoje = LocalDate.now();
        
        LocalDate proximaSemana = hoje.plusWeeks(1);
        LocalDate mesPassado = hoje.minusMonths(1);
        LocalDate proximoAno = hoje.plusYears(1);
        
        System.out.println("Hoje: " + hoje);
        System.out.println("Próxima semana: " + proximaSemana);
        System.out.println("Mês passado: " + mesPassado);
        System.out.println("Próximo ano: " + proximoAno);
        
        // Modificando campos específicos
        LocalDate primeiroDiaMes = hoje.withDayOfMonth(1);
        LocalDate ultimoDiaMes = hoje.withDayOfMonth(hoje.lengthOfMonth());
        
        System.out.println("Primeiro dia do mês: " + primeiroDiaMes);
        System.out.println("Último dia do mês: " + ultimoDiaMes);
    }
    
    private static void demonstrateDateFormatting() {
        System.out.println("\n--- Formatação de Datas ---");
        
        LocalDateTime agora = LocalDateTime.now();
        
        // Formatadores predefinidos
        System.out.println("ISO_LOCAL_DATE: " + agora.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("ISO_LOCAL_TIME: " + agora.format(DateTimeFormatter.ISO_LOCAL_TIME));
        
        // Formatadores customizados
        DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatoTexto = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy");
        
        System.out.println("Formato Brasil: " + agora.format(formatoBrasil));
        System.out.println("Formato texto: " + agora.format(formatoTexto));
    }
    
    private static void demonstrateDateCalculations() {
        System.out.println("\n--- Cálculos com Datas ---");
        
        LocalDate inicio = LocalDate.of(2024, 1, 1);
        LocalDate fim = LocalDate.of(2024, 12, 31);
        
        long diasEntre = ChronoUnit.DAYS.between(inicio, fim);
        long semanasEntre = ChronoUnit.WEEKS.between(inicio, fim);
        long mesesEntre = ChronoUnit.MONTHS.between(inicio, fim);
        
        System.out.println("Entre " + inicio + " e " + fim + ":");
        System.out.println("Dias: " + diasEntre);
        System.out.println("Semanas: " + semanasEntre);
        System.out.println("Meses: " + mesesEntre);
        
        // Period para datas
        Period periodo = Period.between(inicio, fim);
        System.out.println("Período: " + periodo.getYears() + " anos, " + 
                          periodo.getMonths() + " meses, " + 
                          periodo.getDays() + " dias");
        
        // Duration para tempos
        LocalTime inicio2 = LocalTime.of(9, 0);
        LocalTime fim2 = LocalTime.of(17, 30);
        Duration duracao = Duration.between(inicio2, fim2);
        System.out.println("Duração do trabalho: " + duracao.toHours() + " horas e " + 
                          duracao.toMinutesPart() + " minutos");
    }
    
    private static void demonstrateZonedDateTime() {
        System.out.println("\n--- ZonedDateTime ---");
        
        ZonedDateTime agoraSaoPaulo = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime agoraNovaYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime agoraTokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss (z)");
        
        System.out.println("São Paulo: " + agoraSaoPaulo.format(formatter));
        System.out.println("Nova York: " + agoraNovaYork.format(formatter));
        System.out.println("Tóquio: " + agoraTokio.format(formatter));
        
        // Conversão entre time zones
        ZonedDateTime emTokio = agoraSaoPaulo.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Horário de SP convertido para Tóquio: " + emTokio.format(formatter));
    }
}