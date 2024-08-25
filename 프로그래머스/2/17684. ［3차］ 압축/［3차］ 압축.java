import java.util.*;

public class Solution {
    public static int[] solution(String msg) {
        // 사전을 초기화합니다.
        Map<String, Integer> dictionary = new HashMap<>();
        int dictSize = 26; // 초기 사전의 크기 (A-Z)

        // A-Z를 사전에 등록합니다.
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        String w = ""; // 현재 입력 중 일치하는 가장 긴 문자열

        for (int i = 0; i < msg.length(); i++) {
            String c = String.valueOf(msg.charAt(i)); // 다음 글자
            String wc = w + c;

            // 사전에 현재 wc가 있는지 확인
            if (dictionary.containsKey(wc)) {
                w = wc;
            } else {
                // 사전에 없으면, w의 색인 번호를 결과에 추가하고, wc를 사전에 추가
                result.add(dictionary.get(w));
                dictSize++;
                dictionary.put(wc, dictSize);
                w = c; // w를 현재 글자로 초기화
            }
        }

        // 마지막으로 남은 w의 색인 번호를 결과에 추가
        if (!w.isEmpty()) {
            result.add(dictionary.get(w));
        }

        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO"))); 
        // [11, 1, 27, 15]
        
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT"))); 
        // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        
        System.out.println(Arrays.toString(solution("ABABABABABABABAB"))); 
        // [1, 2, 27, 29, 28, 31, 30]
    }
}