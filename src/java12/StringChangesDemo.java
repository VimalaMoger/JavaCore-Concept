package java12;

public class StringChangesDemo {
    public static void main(String[] args) {
        String stringTest = "a test string";
        System.out.println(stringTest.length());
        stringTest = stringTest.indent(5);
        System.out.println(stringTest.length());

        //quote the string
        System.out.printf("'%s'%n", stringTest);
        System.out.println(stringTest.startsWith("\n"));

        //multiline string
        stringTest = "a test\nstring";
        System.out.println(stringTest);
        stringTest = stringTest.indent(5);
        System.out.println(stringTest);

        //negative n
        stringTest = stringTest.indent(-2); //unindent by two spaces
        System.out.println(stringTest);

        //transforming strings
        final String stringTransform = "true";
        Boolean bool = stringTransform.transform(Boolean::parseBoolean);
        System.out.println(bool);

    }
}
