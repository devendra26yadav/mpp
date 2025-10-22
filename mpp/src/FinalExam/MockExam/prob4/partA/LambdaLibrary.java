package FinalExam.MockExam.prob4.partA;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class LambdaLibrary {
    public static final Function<List<Employee>,Double> netSalary =
            list-> Optional.ofNullable(list)
                    .orElse(List.of())
                    .stream()
                    .filter(Objects::nonNull)
                    .mapToDouble(e->e.getSalary()*0.88)
                    .sum();
}
