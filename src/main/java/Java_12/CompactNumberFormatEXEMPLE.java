package Java_12;

import java.text.CompactNumberFormat;
import java.text.NumberFormat;
import java.util.Locale;

import static java.text.CompactNumberFormat.*;

public class CompactNumberFormatEXEMPLE {

    /**
     * Exemplo de formatação compacta de números (Java 12+).
     * EXEMPLO:
     * CompactNumberFormat brShortFormat = (CompactNumberFormat) NumberFormat.getCompactNumber
     * Instance(new Locale("pt", "BR"), Style.SHORT);
     * CompactNumberFormat brLongFormat  = (CompactNumberFormat) NumberFormat.getCompact
     * NumberInstance(new Locale("pt", "BR"), Style.LONG);
     * long brNumber = 1_234_567L;
     * System.out.println("Formato curto (BR): " + brShortFormat.format(brNumber));
     * System.out.println("Formato longo (BR): " + brLongFormat.format(brNumber));
     * Saída:
     * Formato curto (BR): 1,2M
     * Formato longo (BR): 1,2 milhões
     * Formatação para números US
     * CompactNumberFormat usShortFormat = (CompactNumberFormat) NumberFormat.getCompactNumber
     * Instance(Locale.US, Style.SHORT);
     * CompactNumberFormat usLongFormat  = (CompactNumberFormat) NumberFormat.getCompact
     * NumberInstance(Locale.US, Style.LONG);
     * long number = 1_234_567L;
     * System.out.println("Short format: " + usShortFormat.format(number));
     * System.out.println("Long format: " + usLongFormat.format(number));
     * Saída:
     * Short format: 1.2M
     * Long format: 1.2 millions
     * VANTAGENS:
     * - Formatação compacta para grandes números.
     * - Suporte a diferentes estilos (curto e longo).
     * - Localização para diferentes regiões.
     * OBSERVAÇÃO:
     * - Requer Java 12 ou superior.
     * - Nem todos os ambientes podem suportar essa funcionalidade.
     * - Útil para exibir números de forma mais legível em interfaces de usuário.
     * EXEMPLO DE USO:
     * CompactNumberFormat brShortFormat = (CompactNumberFormat) NumberFormat.getCompactNumber
     * Instance(new Locale("pt", "BR"), Style.SHORT);
     * CompactNumberFormat brLongFormat  = (CompactNumberFormat) NumberFormat.getCompact
     * NumberInstance(new Locale("pt", "BR"), Style.LONG);
     * long brNumber = 1_234_567L;
     * System.out.println("Formato curto (BR): " + brShortFormat.format(brNumber));
     * System.out.println("Formato longo (BR): " + brLongFormat.format(brNumber));
     * Saída:
     * Formato curto (BR): 1,2M
     * Formato longo (BR): 1,2 milhões
     */
    public static void main(String[] args) {

        // Formatação para números BR
        CompactNumberFormat brShortFormat = createCompactNumberFormat(new Locale("pt", "BR"), Style.SHORT);
        CompactNumberFormat brLongFormat  = createCompactNumberFormat(new Locale("pt", "BR"), Style.LONG);
        long brNumber = 1_234_567L;
        System.out.println("Formato curto (BR): " + brShortFormat.format(brNumber));
        System.out.println("Formato longo (BR): " + brLongFormat.format(brNumber));

        // Formatação para números US
        CompactNumberFormat usShortFormat = createCompactNumberFormat(Locale.US, Style.SHORT);
        CompactNumberFormat usLongFormat  = createCompactNumberFormat(Locale.US, Style.LONG);
        long number = 1_234_567L;
        System.out.println("Short format: " + usShortFormat.format(number));
        System.out.println("Long format: " + usLongFormat.format(number));

        // Formatação para números INDIA
        CompactNumberFormat inShortFormat = createCompactNumberFormat(new Locale("hi", "IN"), Style.SHORT);
        CompactNumberFormat inLongFormat  = createCompactNumberFormat(new Locale("hi", "IN"), Style.LONG);
        long inNumber = 1_23_45_67L;
        System.out.println("Short format (IN): " + inShortFormat.format(inNumber));
        System.out.println("Long format (IN): " + inLongFormat.format(inNumber));

        // Formatação para números JAPAN
        CompactNumberFormat jpShortFormat = createCompactNumberFormat(Locale.JAPAN, Style.SHORT);
        CompactNumberFormat jpLongFormat  = createCompactNumberFormat(Locale.JAPAN, Style.LONG);
        long jpNumber = 1_23_45_67L;
        System.out.println("Short format (JP): " + jpShortFormat.format(jpNumber));
        System.out.println("Long format (JP): " + jpLongFormat.format(jpNumber));

        // Formatação para números GERMANY
        CompactNumberFormat deShortFormat = createCompactNumberFormat(Locale.GERMANY, Style.SHORT);
        CompactNumberFormat deLongFormat  = createCompactNumberFormat(Locale.GERMANY, Style.LONG);
        long deNumber = 1_234_567L;
        System.out.println("Short format (DE): " + deShortFormat.format(deNumber));
        System.out.println("Long format (DE): " + deLongFormat.format(deNumber));

        // Formatação para números FRANCE
        CompactNumberFormat frShortFormat = createCompactNumberFormat(Locale.FRANCE, Style.SHORT);
        CompactNumberFormat frLongFormat  = createCompactNumberFormat(Locale.FRANCE, Style.LONG);
        long frNumber = 1_234_567L;
        System.out.println("Short format (FR): " + frShortFormat.format(frNumber));
        System.out.println("Long format (FR): " + frLongFormat.format(frNumber));

        // Formatação para números CHINA
        CompactNumberFormat cnShortFormat = createCompactNumberFormat(Locale.CHINA, Style.SHORT);
        CompactNumberFormat cnLongFormat  = createCompactNumberFormat(Locale.CHINA, Style.LONG);
        long cnNumber = 1_234_567L;
        System.out.println("Short format (CN): " + cnShortFormat.format(cnNumber));
        System.out.println("Long format (CN): " + cnLongFormat.format(cnNumber));

        // Formatação para números Tibetan
        CompactNumberFormat boShortFormat = createCompactNumberFormat(new Locale("bo", "CN"), Style.SHORT);
        CompactNumberFormat boLongFormat  = createCompactNumberFormat(new Locale("bo", "CN"), Style.LONG);
        long boNumber = 1_234_567L;
        System.out.println("Short format (BO): " + boShortFormat.format(boNumber));
        System.out.println("Long format (BO): " + boLongFormat.format(boNumber));

        // Formatação para números ARABIC
        CompactNumberFormat arShortFormat = createCompactNumberFormat(new Locale("ar", "AE"), Style.SHORT);
        CompactNumberFormat arLongFormat  = createCompactNumberFormat(new Locale("ar", "AE"), Style.LONG);
        long arNumber = 1_234_567L;
        System.out.println("Short format (AR): " + arShortFormat.format(arNumber));
        System.out.println("Long format (AR): " + arLongFormat.format(arNumber));

        // Formatação para números RUSSIAN
        CompactNumberFormat ruShortFormat = createCompactNumberFormat(new Locale("ru", "RU"), Style.SHORT);
        CompactNumberFormat ruLongFormat  = createCompactNumberFormat(new Locale("ru", "RU"), Style.LONG);
        long ruNumber = 1_234_567L;
        System.out.println("Short format (RU): " + ruShortFormat.format(ruNumber));
        System.out.println("Long format (RU): " + ruLongFormat.format(ruNumber));

        // Formatação para números PARAGUAI
        CompactNumberFormat pyShortFormat = createCompactNumberFormat(new Locale("es", "PY"), Style.SHORT);
        CompactNumberFormat pyLongFormat  = createCompactNumberFormat(new Locale("es", "PY"), Style.LONG);
        long pyNumber = 1_234_567L;
        System.out.println("Short format (PY): " + pyShortFormat.format(pyNumber));
        System.out.println("Long format (PY): " + pyLongFormat.format(pyNumber));
    }

    private static CompactNumberFormat createCompactNumberFormat(Locale locale, Style style) {
        return (CompactNumberFormat) NumberFormat.getCompactNumberInstance(locale, style);
    }
}
