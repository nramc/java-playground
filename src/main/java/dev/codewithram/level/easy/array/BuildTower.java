package dev.codewithram.level.easy.array;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class BuildTower {
    private static final IntUnaryOperator maxLength = n -> 2 * n - 1;
    private static final IntUnaryOperator noOfStars = r -> 2 * r - 1;
    private static final IntBinaryOperator noOfEqualSpaces = (n, r) -> Math.floorDiv(maxLength.applyAsInt(n) - noOfStars.applyAsInt(r), 2);
    private static final IntFunction<String> formStar = r -> "*".repeat(noOfStars.applyAsInt(r));
    private static final BiFunction<Integer, Integer, String> formSpace = (n, r) -> " ".repeat(noOfEqualSpaces.applyAsInt(n, r));
    private static final BiFunction<Integer, Integer, String> formRow = (n, r) -> formSpace.apply(n, r) + formStar.apply(r) + formSpace.apply(n, r);

    private BuildTower() {
    }

    public static String[] towerBuilder(int nFloors) {
        return IntStream.rangeClosed(1, nFloors)
                .boxed()
                .map(r -> formRow.apply(nFloors, r))
                .toArray(String[]::new);
    }

}
