import java.io.*;
import java.util.*;

public class Main {
    /**
     *  1. 해안가를 따라 원형으로 마을들이 위치해 있다.
     *  2. A -> B 가기 위해서는 왼쪽 또는 오른쪽 도로를 통해 해안갈르 따라 섬을 돌아야 한다.
     *  3. 마을 -> 마을 이동비용이 주어질 때, 최소한의 이동비용으로 섬의 모든 마을을 관광하려면
     *     얼마의 이동비용을 준비해야 하는지 출력
     *
     *  [풀이]
     *  - 섬이 원형이므로 어디서 시작하든 동일한 비용이 발생
     *  - 한 방향으로의 순회만 고려해서  비용의 총합을 계산
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            max = Math.max(max, num);
        }
        sum -= max;
        System.out.print(sum);
    }
}