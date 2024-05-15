import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int answer = 0;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                answer++;
            }
            return;
        }

        // 현재 숫자를 더하는 경우
        dfs(numbers, target, index + 1, currentSum + numbers[index]);
        // 현재 숫자를 빼는 경우
        dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}