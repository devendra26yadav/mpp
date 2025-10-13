package Labs_solutions.lab9.prob2;

public class EvaluateExpression {
    public static int eval(Expression expr){
        if(expr instanceof Constant(int value)){
            return value;
        }else if(expr instanceof Add(Expression left, Expression right)){
            return eval(left)+eval(right);
        }else if(expr instanceof Multiply m){
            return eval(m.left())*eval(m.right());
        }else{
            throw new IllegalArgumentException("Not valid expression type");
        }

/* // using switch to find expression value
        return switch (expr) {
            case Constant(int value) -> value;
            case Add(Expression left, Expression right) -> eval(left) + eval(right);
            case Multiply m -> eval(m.left()) * eval(m.right());
            case null, default -> throw new IllegalArgumentException("Not valid expression type");
        };

 */
    }
}
