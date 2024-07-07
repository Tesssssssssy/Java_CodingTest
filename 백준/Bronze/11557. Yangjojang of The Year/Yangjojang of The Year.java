import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1. 가장 술 소비가 많은 학교 이름 출력
     * 2. 1) 입력 첫 줄: 테스트 케이스의 숫자 T
     * 2) 매 입력의 첫 줄에는 학교의 숫자 정수 N
     * 3) N줄에 걸쳐 학교 이름, 한 해 소비한 술의 양
     * 3. 소비한 술의 양이 같은 학교는 없다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  // 각 테스트 케이스에서의 학교 수

            Map<Integer, String> schoolAlcohol = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcoholAmount = Integer.parseInt(st.nextToken());
                schoolAlcohol.put(alcoholAmount, schoolName);
            }

            // TreeMap에서 value로 최대값 찾고
            int maxAlcoholAmount = Collections.max(schoolAlcohol.keySet());
            System.out.println(schoolAlcohol.get(maxAlcoholAmount));
        }
    }
}
