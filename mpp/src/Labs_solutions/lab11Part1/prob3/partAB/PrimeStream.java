package Labs_solutions.lab11Part1.prob3.partAB;

import java.util.stream.Stream;

public class PrimeStream {
    private final Stream<Integer> primes=Stream.iterate(2,PrimeStream::nextPrime);

    private static int nextPrime(int n) {
        int candidate = n + 1;
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    private Stream<Integer> generateStream(){
        return Stream.iterate(2,PrimeStream::nextPrime);
    }

    public void printFirstNPrimes(Long n){
        generateStream().limit(n).forEach(el-> System.out.print(el+" "));
    }
}
