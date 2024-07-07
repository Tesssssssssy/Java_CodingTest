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

            /*
                문제에서 소비한 술의 양이 같은 학교가 없다고 했으므로 술의 양을 key로 한다.
                TreeMap 자료구조를 사용할 것이고 자동으로 키 값을 기준으로 정렬이 되기 때문에
                해당하는 키 값으로 학교 이름(value)을 찾는다.
            */
            TreeMap<Integer, String> schoolAlcohol = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int alcoholAmount = Integer.parseInt(st.nextToken());
                schoolAlcohol.put(alcoholAmount, schoolName);
            }

            System.out.println(schoolAlcohol.get(schoolAlcohol.lastKey()));
        }
    }
}