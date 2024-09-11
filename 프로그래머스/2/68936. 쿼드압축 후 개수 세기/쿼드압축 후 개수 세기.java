import java.util.*;

public class Solution {
    public static int[] solution(int[][] arr) {
        return compress(arr, 0, 0, arr.length);
    }

    private static int[] compress(int[][] arr, int x, int y, int size) {
        int[] result = new int[2];

        if (isUniform(arr, x, y, size)) {
            result[arr[x][y]]++;
            return result;
        }

        int newSize = size / 2;
        int[] topLeft = compress(arr, x, y, newSize);
        int[] topRight = compress(arr, x, y + newSize, newSize);
        int[] bottomLeft = compress(arr, x + newSize, y, newSize);
        int[] bottomRight = compress(arr, x + newSize, y + newSize, newSize);

        result[0] = topLeft[0] + topRight[0] + bottomLeft[0] + bottomRight[0];
        result[1] = topLeft[1] + topRight[1] + bottomLeft[1] + bottomRight[1];

        return result;
    }

    private static boolean isUniform(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {1,1,0,0},
                {1,0,0,0},
                {1,0,0,1},
                {1,1,1,1}
        };
        System.out.println(Arrays.toString(solution(arr1))); // [4, 9]

        int[][] arr2 = {
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        };
        System.out.println(Arrays.toString(solution(arr2))); // [10, 15]
    }
}
