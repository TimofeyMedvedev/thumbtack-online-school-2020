package net.thumbtack.school.introduction;

public class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return (x >= xLeft && x <= xRight) && (y >= yTop && y <= yBottom);
    }

    public int sum(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int summ = 0;
        for(int element : array) {
            summ += element;
        }
        return summ;
    }

    public int mul(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        int mull = 1;
        for(int element : array) {
            mull *= element;
        }
        return mull;
    }

    public int min(int[] array) {
        if(array.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for(int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    public int max(int[] array) {
        if(array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for(int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public double average(int[] array) {
        if(array.length == 0) {
            return 0;
        }
        return (double) sum(array) / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        if(array.length == 0) {
            return true;
        }
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void cube(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    public boolean find(int[] array, int value) {
        for(int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            int element = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = element;
        }
    }

    public boolean isPalindrome(int[] array) {
        for(int i = 0; i < array.length / 2; i++) {
            if(array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int summ = 0;
        for(int[] array : matrix) {
            summ += sum(array);
        }
        return summ;
    }

    public int max(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        if(matrix.length == 0) {
            return max;
        }

        for(int[] array : matrix) {
            int maxInArray;
            maxInArray = max(array);
            if (maxInArray > max) {
                max = maxInArray;
            }
        }
        return max;
    }

    public int diagonalMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        if(matrix.length == 0) {
            return max;
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i].length == 0) {
                return max;
            }

            if (matrix[i][i] > max) {
                max = matrix[i][i];
            }
        }
        return max;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        if(matrix.length == 0) {
            return true;
        }

        for(int[] array : matrix) {
            if(!isSortedDescendant(array)) {
                return false;
            }
        }
        return true;
    }
}
