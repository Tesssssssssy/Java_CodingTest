import java.util.*;

class Solution {
    public static boolean solution(String[] phone_book) {
        // 해시맵을 사용하여 전화번호 목록을 저장.
        HashMap<String, Integer> map = new HashMap<>();

        // 각 전화번호를 해시맵에 추가.
        // 각 번호를 키로 사용하고, 값으로 1을 설정.
        for (String number : phone_book) {
            map.put(number, 1);
        }

        // 각 전화번호에 대해 접두사가 다른 전화번호의 접두사로 존재하는지 확인.
        for (String number : phone_book) {
            // 전화번호의 각 접두사를 확인. (1자리부터 n-1자리까지)
            for (int i = 1; i < number.length(); i++) {
                // 현재 접두사가 해시맵에 키로 존재하면, 다른 전화번호의 접두사.
                if (map.containsKey(number.substring(0, i))) {
                    // 접두사가 존재한다는 것 출력. (디버깅용)
                    System.out.println(map.containsKey(number.substring(0, i)) + ", " + i);
                    // 접두사가 존재하면 false 반환.
                    return false;
                }
            }
        }

        // 모든 접두사를 검사한 후에도 문제가 없으면 true 반환.
        return true;
    }
}