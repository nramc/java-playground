package dev.codewithram.level.easy.numbers;

import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

import static org.slf4j.LoggerFactory.getLogger;

public class AddBigNumbers {
    private static final Logger log = getLogger(AddBigNumbers.class);
    private static final Function<String, Integer[]> fnToIntArray = val ->
            Arrays.stream(val.split("")).map(Integer::parseInt).toArray(Integer[]::new);

    private AddBigNumbers() {
    }

    public static String add(String valOne, String valTwo) {
        Integer[] arrayOfValOne = fnToIntArray.apply(valOne);
        log.info("int array of {} is {}", valOne, arrayOfValOne);

        Integer[] arrayOfValTwo = fnToIntArray.apply(valTwo);
        log.info("int array of {} is {}", valTwo, arrayOfValTwo);

        Integer[] largerArray = arrayOfValOne.length >= arrayOfValTwo.length ? arrayOfValOne : arrayOfValTwo;

        Arrays.stream(largerArray).sorted(Collections.reverseOrder()).toArray();

        return "not yet";
    }
}
