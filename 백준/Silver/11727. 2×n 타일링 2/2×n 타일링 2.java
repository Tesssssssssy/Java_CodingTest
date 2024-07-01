import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1; // 세로로 한 개의 2×1 타일로 채울 수 있다.
        dp[2] = 3;
        /*
            - 2×1 타일 두 개를 가로로 놓는 방법
            - 1×2 타일 두 개를 세로로 놓는 방법
            - 하나의 2×2 타일을 놓는 방법
         */

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            // 주어진 문제에서는 모듈러 연산 필요
            // 2 * dp[i - 2])는 2×1 타일 두 개나 2×2 타일 하나를 추가하는 경우 의미
        }

        System.out.println(dp[n]);
    }
}