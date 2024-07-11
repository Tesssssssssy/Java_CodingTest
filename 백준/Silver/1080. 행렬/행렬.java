import java.io.*;
import java.util.*;

public class Main {
    /**
     *  1. 0과 1로만 이루어진 행렬 A, B
     *  2. 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] matrixA = new char[N][];
        char[][] matrixB = new char[N][];

        // 행렬 A 입력
        for (int i = 0; i < N; i++) {
            matrixA[i] = br.readLine().toCharArray();
        }

        // 행렬 B 입력
        for (int i = 0; i < N; i++) {
            matrixB[i] = br.readLine().toCharArray();
        }

        // 연산 횟수를 계산
        int operationCount = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    flip3x3(matrixA, i, j);
                    operationCount++;
                }
            }
        }

        // 최종 결과가 같은지 확인
        if (check(matrixA, matrixB)) {
            System.out.println(operationCount);
        } else {
            System.out.println(-1);
        }
    }

    private static void flip3x3(char[][] matrix, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                matrix[i][j] = matrix[i][j] == '0' ? '1' : '0';
            }
        }
    }

    private static boolean check(char[][] matrixA, char[][] matrixB) {
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
