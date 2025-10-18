package Generics.Example1;

import java.math.BigDecimal;

@SuppressWarnings("unchecked")
public class Calculator<T extends Number> {
    public T add(T a, T b) {
        if(a instanceof Integer){
            return (T) Integer.valueOf( a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue()+b.doubleValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        }else if(a instanceof BigDecimal){
            return (T) ((BigDecimal) a).add((BigDecimal) b);
        }
        else{
            throw new UnsupportedOperationException("Unsupported type "+a.getClass());
        }
    }

    public double sub(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double div(T a, T b) {
        if (b.doubleValue() == 0) throw new ArithmeticException("Denominator cannot be zero");
        return a.doubleValue() / b.doubleValue();
    }

}
