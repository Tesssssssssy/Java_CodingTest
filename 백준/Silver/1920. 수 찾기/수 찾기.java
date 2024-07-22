import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
     *    이 안에 X라는 정수가 존재하는지 알아내는 프로그램
     *
     *  [입력]
     *  - 자연수 N(1 ≤ N ≤ 100,000)
     *  - 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]
     *  - 다음 줄에는 M(1 ≤ M ≤ 100,000)
     *  - 다음 줄에는 M개의 수
     *
     *  이 수들이 A안에 존재하는지 알아내면 된다.
     *  모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
     *
     *  [출력]
     *  M개의 줄에 답을 출력한다.
     *  (존재하면 1을, 존재하지 않으면 0을 출력)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N개의 정수 입력 받기
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // M개의 정수 입력 받기
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}
