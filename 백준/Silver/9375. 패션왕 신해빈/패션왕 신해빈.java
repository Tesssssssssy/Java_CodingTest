import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine()); // 테스트 케이스 수.

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(br.readLine()); // 각 테스트 케이스에서 의상 수를 입력
            HashMap<String, Integer> clothes = new HashMap<>(); // 옷의 종류별로 개수를 저장할 해시맵

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                String[] inputs = line.split(" ");
                String type = inputs[1]; // 의상의 종류를 추출

                clothes.put(type, clothes.getOrDefault(type, 0) + 1); // 해시맵에 종류별 개수를 증가시킴.
            }

            int combinations = 1; // 가능한 조합의 수 초기화

            for (int count : clothes.values()) {
                combinations *= (count + 1); // 각 종류의 (개수 + 1)을 곱함
            }

            // 모든 옷을 안 입는 경우를 제외하고 출력
            System.out.println(combinations - 1);
        }

        br.close();
    }
}