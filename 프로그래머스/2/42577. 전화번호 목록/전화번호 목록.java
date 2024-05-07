import java.util.Arrays;

class Solution {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        // 정렬된 목록에서 인접한 요소끼리 접두어 관계인지 검사
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 접두어 관계가 없으면 true 반환
        return true;
    }
}