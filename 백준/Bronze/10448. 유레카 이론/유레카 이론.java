import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        // 삼각수를 저장할 HashSet
        Set<Integer> triangularNumbers = new HashSet<>();
        int maxK = 1000; // K의 최대 가능 값
        int n = 1;
        // 가능한 모든 삼각수를 계산하고 저장
        while (true) {
            int triangular = n * (n + 1) / 2;
            if (triangular > maxK) {
                break; // 삼각수가 maxK을 초과하면 반복 중단
            }
            triangularNumbers.add(triangular); // 삼각수 추가
            n++;
        }

        // 각 테스트 케이스에 대해 수행
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine()); // K 값을 입력 받음
            boolean found = false;

            // 두 삼각수의 합을 저장할 HashSet
            Set<Integer> twoSumSet = new HashSet<>();
            for (Integer a : triangularNumbers) {
                for (Integer b : triangularNumbers) {
                    if (a + b <= K) { // 합이 K 이하인 경우만 저장
                        twoSumSet.add(a + b);
                    }
                }
            }

            // 두 삼각수의 합과 하나의 삼각수의 합이 K가 되는지 검사
            for (Integer sum : twoSumSet) {
                if (triangularNumbers.contains(K - sum)) { // K-sum이 삼각수인지 검사
                    bw.write("1\n"); // 조건을 만족하면 1 출력
                    found = true;
                    break;
                }
            }

            if (!found) {
                bw.write("0\n"); // 조건을 만족하는 조합이 없으면 0 출력
            }
        }

        br.close();
        bw.flush(); // 버퍼에 남아있는 데이터를 출력
        bw.close();
    }
}