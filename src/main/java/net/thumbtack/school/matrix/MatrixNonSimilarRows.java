package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Number>, int[]> map = new HashMap<>();

        for(int i = matrix.length - 1; i >= 0; i--) {
            Set<Number> numbers = new HashSet<>();
            for(int numb : matrix[i]) {
                numbers.add(numb);
            }
            map.put(numbers, matrix[i]);
        }

        return new HashSet<>(map.values());
    }
}
