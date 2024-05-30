import java.util.*;

public class Solution {
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int ar : arr) {
            if (stack.isEmpty() || stack.peek() != ar) {
                stack.push(ar);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}