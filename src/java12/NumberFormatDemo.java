package java12;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        System.out.println("Formatting numbers: Locale.US ");
        formatForLocale(Locale.US);
        System.out.println("...........................................");
        System.out.println("\nFormatting numbers: Locale.GERMANY ");
        formatForLocale(Locale.GERMANY);
    }
    private static void formatForLocale(Locale locale) {
        List<Integer> numbers = List.of(100000, 10000000, 1000000001);

        //compact formatting
        System.out.printf("\nSHORT format = %s\n", locale);
        numbers.stream().forEach((num) -> {
            NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
            String format = nf.format(num);
            System.out.println(format);
        });

        System.out.printf("\nLONG format = %s\n", locale);
        numbers.stream().forEach((num) -> {
            NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.LONG);
            String format = nf.format(num);
            System.out.println(format);
        });

        //formatting with rounding
        System.out.println("\nFormatting with rounding ");
        numbers = List.of(1500, 1500000, 1200000000);
        System.out.printf("\nSHORT format = %s\n", locale);
        numbers.stream().forEach((num) -> {
            NumberFormat nf = NumberFormat.getCompactNumberInstance(locale, NumberFormat.Style.SHORT);
            String format = nf.format(num);
            System.out.println(format);
        });

        //short compact parsing
        NumberFormat nf = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        try {
            System.out.println(nf.parse("1K"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //parseWithGrouping
        nf.setGroupingUsed(true);
        try {
            System.out.println(nf.parse("1,00K"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
