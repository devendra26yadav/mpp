package FinalExam.MyOwnInterface;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceWithStreams {

    @FunctionalInterface
    interface StringTransform{
        String transform(String input);
    }
    @FunctionalInterface
    interface StringFilter{
        boolean test(String input);
    }
    @FunctionalInterface
    interface StringConsumer{
        void accept(String input);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("stream", "java", "functional", "interface", "lambda", "code");
        StringTransform toUpper = str->str.toUpperCase();
        StringFilter greaterThan5 = str->str.length()>5;
        StringConsumer printWithBrackets = str-> System.out.println("[ "+ str+" ]");

        words.stream()
                .filter(greaterThan5::test)
                .map(toUpper::transform)
                .forEach(printWithBrackets::accept);
    }
}
