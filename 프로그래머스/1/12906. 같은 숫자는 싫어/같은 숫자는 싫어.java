import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
                Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            // 스택이 비어있거나 스택의 최상위 원소가 현재 숫자와 다를 때만 스택에 숫자 추가
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }

        // 스택에 저장된 결과를 배열로 전환
        int[] answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}