import java.io.*;
import java.util.*;

public class Main {
    /**
     *  1. 숫자 N개를 갖고 있다.
     *  2. 정수 M개가 주어졌을 떄, 이 수가 적혀있는 숫자 카드를
     *     몇 개 가지고 있는지 출력.
     *     
     *  [풀이]
     *  해시맵 사용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> cardCnt = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (cardCnt.containsKey(card)) {
                cardCnt.put(card, cardCnt.get(card) + 1);
            } else {
                cardCnt.put(card, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] queries = new int[M];

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < M; i++) {
            queries[i] = Integer.parseInt(st.nextToken());
            output.append(cardCnt.getOrDefault(queries[i], 0)).append(" ");
        }

        System.out.println(output);
    }
}
