package java9.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class RegexMatch {
    public static void main(String[] args) {
        //matches phone numbers
        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        String input = "111-111-1111 222-222-2222 333-333-3333 444-444-444";
        Matcher matcher = pattern.matcher(input);
        String s = matcher.results()
                .map(MatchResult::group)
                .dropWhile(str -> !str.startsWith("222"))
                .takeWhile(str -> !str.startsWith("444"))
                .collect(Collectors.joining(", "));
        System.out.println(s);

        //finds all integers and add together
        Pattern patterN = Pattern.compile("\\d+");
        String inpuT = "a 1 b 2 c 3 d 4 e 5 f 6";
        Matcher matcheR = patterN.matcher(inpuT);
        int sum = matcheR.results()
                .map(MatchResult::group)
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);
    }
}
