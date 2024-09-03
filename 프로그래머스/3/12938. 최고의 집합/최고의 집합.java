import java.util.*;

public class Solution {
    public static int[] solution(int n, int s) {
        // 예외 처리: 자연수 n개의 합이 s가 될 수 없는 경우
        if (n > s) {
            return new int[]{-1};
        }

        // 몫과 나머지 구하기
        int q = s / n;
        int r = s % n;

        // 결과 배열 초기화
        int[] result = new int[n];
        Arrays.fill(result, q);

        // 나머지를 분배하여 최대 곱 만들기
        for (int i = 0; i < r; i++) {
            result[i]++;
        }

        // 결과 배열 반환
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));  // [4, 5]
        System.out.println(Arrays.toString(solution(2, 1)));  // [-1]
        System.out.println(Arrays.toString(solution(2, 8)));  // [4, 4]
    }
}
