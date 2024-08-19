public class Solution {
    /**
     *  자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
     *  1 + 2 + 3 + 4 + 5 = 15
     *  4 + 5 + 6 = 15
     *  7 + 8 = 15
     *  15 = 15
     *
     *  자연수 n이 매개변수로 주어질 때,
     *  연속된 자연수들로 n을 표현하는 방법의 수를 return 하는 solution 완성
     */
    public static int solution(int n) {
        int answer = 0;
        int start = 1; // 시작 포인터
        int end = 1;   // 끝 포인터
        int sum = 1;   // 현재 합

        while (start <= n) {
            if (sum == n) {
                answer++;  // 합이 n과 같으면 방법을 찾음
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end; // 합이 n보다 작으면 끝 포인터를 증가시켜 더 큰 합으로
            } else {
                sum -= start;
                start++;  // 합이 n보다 크면 시작 포인터를 증가시켜 작은 합으로
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n)); // 4
    }
}