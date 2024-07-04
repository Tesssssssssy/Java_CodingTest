import java.io.*;
import java.math.BigInteger;

public class Main {
    /**
     *  피보나치 수열 문제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // n 입력 받기

        if (n == 0) {
            System.out.println(0);  // n이 0일 경우 0을 출력
        } else if (n == 1) {
            System.out.println(1);  // n이 1일 경우 1을 출력
        } else {
            BigInteger[] fib = new BigInteger[n + 1];  // 피보나치 수열을 저장할 배열
            fib[0] = BigInteger.ZERO;;  // 첫 번째 피보나치 수
            fib[1] = BigInteger.ONE;;  // 두 번째 피보나치 수

            for (int i = 2; i <= n; i++) {
                fib[i] = fib[i - 2].add(fib[i - 1]);  // i번째 피보나치 수 계산
            }

            System.out.println(fib[n]);  // n번째 피보나치 수 출력
        }
    }
}