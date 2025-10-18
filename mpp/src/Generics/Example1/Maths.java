package Generics.Example1;

public class Maths implements Operation<Integer>{
    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer sub(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if(b==0) throw new UnsupportedOperationException("Unsupported type "+b.getClass());
        return a/b;
    }
}
