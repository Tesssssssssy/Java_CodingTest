import java.util.Arrays;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        // 인접한 요소끼리 접두어 관계인지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }
}