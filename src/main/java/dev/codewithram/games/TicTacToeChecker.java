package dev.codewithram.games;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved,
 * wouldn't we? Our goal is to create a function that will check that for us!
 * Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty,
 * 1 if it is an "X", or
 * 2 if it is an "O", like so:
 * [[0, 0, 1],
 * [0, 1, 2],
 * [2, 1, 0]]
 * We want our function to return:
 * -1 if the board is not yet finished AND no one has won yet (there are empty spots),
 * 1 if "X" won,
 * 2 if "O" won,
 * 0 if it's a cat's game (i.e. a draw).
 * You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.
 */
public class TicTacToeChecker {
    private TicTacToeChecker() {

    }

    private static final Predicate<int[][]> isFinished = matrix ->
            Arrays.stream(matrix).flatMap(m -> Arrays.stream(m).boxed()).allMatch(val -> val > 0);
    private static final UnaryOperator<int[][]> transpose = matrix -> {
        int[][] temp = new int[matrix.length][matrix.length];
        IntStream.range(0, matrix.length).forEach(r -> IntStream.range(0, matrix.length).boxed().forEach(c -> temp[c][r] = matrix[r][c]));
        return temp;
    };
    private static final BiPredicate<int[][], Integer> isRowValid = (matrix, element) ->
            Arrays.stream(matrix).anyMatch(row -> Arrays.stream(row).allMatch(value -> value == element));
    private static final BiPredicate<int[][], Integer> isColumnValid = (matrix, element) ->
            Arrays.stream(transpose.apply(matrix)).anyMatch(row -> Arrays.stream(row).allMatch(value -> value == element));
    private static final BiPredicate<int[][], Integer> isForwardDiagonalValid = (matrix, element) ->
            IntStream.range(0, matrix.length).allMatch(idx -> matrix[idx][idx] == element);
    private static final BiPredicate<int[][], Integer> isBackwardDiagonalValid = (matrix, element) ->
            IntStream.range(0, matrix.length).allMatch(idx -> matrix[idx][matrix.length - 1 - idx] == element);
    private static final BiPredicate<int[][], Integer> isValid = (matrix, element) ->
            isRowValid.or(isColumnValid).or(isForwardDiagonalValid).or(isBackwardDiagonalValid).test(matrix, element);

    public static int isSolved(int[][] board) {

        if (isValid.test(board, 1)) {
            return 1;
        } else if (isValid.test(board, 2)) {
            return 2;
        } else if (isFinished.test(board)) {
            return 0;
        } else {
            return -1;
        }
    }


}
