import java.io.*;
import java.util.*;

public class Main {
    /**
     *  1. 메세지는 숫자 N개로 이루어진 수열
     *     숫자는 모두 C 보다 작거나 같다.
     *  2. 이 숫자를 자주 등장하는 빈도순대로 정렬
     *  3. 수열의 두 수 X, Y가 있을 때,
     *     X가 Y보다 수열에서 많이 등장하면 X가 Y보다 앞에 있어야 함.
     *  4. 등장하는 횟수가 같다면, 먼저 나온 것이 앞에 있어야 한다.
     *  5. 수열을 정렬한 후 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 수열의 길이
        int C = Integer.parseInt(st.nextToken());  // 수의 최대값 (사용 x)

        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());  // 숫자들을 읽어 StringTokenizer 생성
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Integer> firstAppearance = new HashMap<>();

        for (int i = 0; i < sequence.length; i++) {
            int num = sequence[i];
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            firstAppearance.putIfAbsent(num, i);  // 최초 등장 위치 저장
        }

        // 정렬 기준 설정: 빈도 높은 순, 빈도 같으면 최초 등장 위치 낮은 순
        List<Integer> list = new ArrayList<>(frequency.keySet());
        list.sort((a, b) -> {
            if (frequency.get(a).equals(frequency.get(b))) {
                return firstAppearance.get(a) - firstAppearance.get(b);
            } else {
                return frequency.get(b) - frequency.get(a);
            }
        });

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            for (int i = 0; i < frequency.get(num); i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}