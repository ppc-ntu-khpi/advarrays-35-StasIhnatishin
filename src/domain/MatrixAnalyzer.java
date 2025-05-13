package domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Клас MatrixAnalyzer обчислює число, яке зустрічається найчастіше
 * в цілочисельній матриці розміром N x M.
 * <p>
 * Вхідні дані: двовимірний масив типу {@code int[][]}.
 * Вихідні дані: число, що має найбільшу кількість повторень.
 */
public class MatrixAnalyzer {

    /**
     * Повертає елемент матриці, який повторюється найчастіше.
     *
     * @param matrix двовимірний масив цілих чисел
     * @return число з найбільшою кількістю повторень
     * @throws IllegalArgumentException якщо матриця порожня
     */
    public static int findMostFrequentNumber(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матриця не повинна бути порожньою.");
        }

        // Перетворення 2D масиву в потік цілих чисел
        return Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();
    }
}
