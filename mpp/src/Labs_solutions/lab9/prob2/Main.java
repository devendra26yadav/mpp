package Labs_solutions.lab9.prob2;

public class Main {
    public static void main(String[] args) {
        Expression expr = new Multiply(
                new Add(
                        new Constant(2),
                        new Constant(3)),
                new Constant(4));
        int result = EvaluateExpression.eval(expr);
        System.out.println("Test 1");
        System.out.println("Expression: (2+3) * 4 = "+result);

        System.out.println("Test 2");
        Expression complex = new Multiply(
                new Add(new Constant(2), new Constant(3)),
                new Add(new Constant(4), new Constant(1))
        );
        System.out.println("Expression : ((2 + 3) * (4 + 1)) = "+EvaluateExpression.eval(complex));
    }
}
