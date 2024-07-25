import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - 학교 홈페이지에 추천받은 학생의 사진을 게시할 수 있는 사진틀을 후보의 수만큼 만들었다.
     *
     *  - 학생들이 추천을 시작하기 전에 모든 사진틀은 비어있다.
     *  - 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
     *  - 비어있는 사진틀이 없는 경우에는 현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제하고,
     *    그 자리에 새롭게 추천받은 학생의 사진을 게시한다.
     *    이때, 현재까지 추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는
     *         그러한 학생들 중 게시된 지 가장 오래된 사진을 삭제한다.
     *  - 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
     *  - 사진틀에 게시된 사진이 삭제되는 경우에는 해당 학생이 추천받은 횟수는 0으로 바뀐다.
     *
     *  - 후보의 수 즉, 사진틀의 개수와 전체 학생의 추천 결과가 추천받은 순서대로 주어졌을 때,
     *    최종 후보가 누구인지 결정하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int totalRecommendCnt = Integer.parseInt(br.readLine()); // 총 추천 횟수

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // 저장된 순서를 기억하는 map -> LinkedHashMap

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < totalRecommendCnt; i++) {
            int student = Integer.parseInt(st.nextToken());
            // 추천을 받은 학생의 사진이 이미 틀에 있으면 추천 수 증가
            if (map.containsKey(student)) {
                map.put(student, map.get(student) + 1);
            } else {
                if (map.size() == N) {
                    // 사진틀이 꽉 차있다면, 가장 오래되고 추천 수가 가장 적은 학생을 제거
                    int minId = map.entrySet().stream()
                            .min(Map.Entry.comparingByValue())
                            .get()
                            .getKey();
                    map.remove(minId);
                }
                // 새 학생을 사진틀에 추가
                map.put(student, 1);
            }
        }

        // 출력: 사진틀에 있는 학생들을 ID 오름차순으로 출력
        map.keySet().stream().sorted().forEach(id -> System.out.print(id + " "));

        /*
        TreeSet<Integer> sortedKeys = new TreeSet<>(map.keySet());
        for (Integer id : sortedKeys) {
            System.out.print(id + " ");
        }
        */
    }
}