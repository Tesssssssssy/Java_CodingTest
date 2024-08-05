import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
     *  - 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택.
     *  - ex.)
     *        k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지.
     *        ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
     *
     *  [입력]
     *  첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수
     *  입력의 마지막 줄에는 0이 하나 주어진다.
     *
     *  [출력]
     *  각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력
     */
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;  // 입력의 끝 조건

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> temp = new ArrayList<>();
            findCombinations(S, 0, 0, temp);
            sb.append('\n');  // 각 테스트 케이스 사이에 빈 줄
        }

        System.out.print(sb.toString().trim());  // 마지막 빈 줄 제거 후 출력
    }

    private static void findCombinations(int[] S, int start, int depth, List<Integer> temp) {
        if (depth == 6) {  // 6개를 선택했을 때 출력
            for (int num : temp) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < S.length; i++) {
            temp.add(S[i]);
            findCombinations(S, i + 1, depth + 1, temp);
            temp.remove(temp.size() - 1);  // 백트래킹
        }
    }
}
