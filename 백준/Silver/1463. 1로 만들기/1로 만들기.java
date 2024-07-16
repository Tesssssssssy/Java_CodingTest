import java.io.*;

public class Main {
    /**
     *  1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
     *     X가 2로 나누어 떨어지면, 2로 나눈다.
     *     1을 뺀다.
     *  2. 정수 N이 주어졌을 때,
     *     위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
     *     연산을 사용하는 횟수의 최솟값을 출력.
     *
     *  [풀이]
     *  동적계획법
     *      i-1에서 1을 더하는 연산 (1을 뺀다는 의미)
     *      i/2에서 1을 더하는 연산 (만약 i가 2로 나누어 떨어진다면)
     *      i/3에서 1을 더하는 연산 (만약 i가 3으로 나누어 떨어진다면)
     *
     *      => 각 숫자에 대해 이 중 최소값을 dp 배열에 저장하며, 최종적으로 dp[N]을 출력.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        // 1을 만드는 경우 연산 횟수는 0이므로 dp[1]은 0으로 초기화.
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 먼저 1을 빼는 경우를 기본으로 설정

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누어 떨어지는 경우
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누어 떨어지는 경우
            }
        }

        // N을 1로 만드는데 필요한 최소 연산 횟수 출력
        System.out.println(dp[N]);
    }
}
