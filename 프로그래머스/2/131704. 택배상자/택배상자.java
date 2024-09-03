import java.util.*;

public class Solution {
    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int index = 0; // order 배열을 순차적으로 접근하기 위한 인덱스

        for (int boxNumber = 1; boxNumber <= order.length; boxNumber++) {
            // 상자를 순차적으로 보조 컨테이너 벨트에 추가
            stack.push(boxNumber);

            // 현재 보조 컨테이너 벨트의 맨 위 상자가 트럭에 실어야 하는 상자와 일치할 때, 실음
            while (!stack.isEmpty() && stack.peek() == order[index]) {
                stack.pop();
                index++;
            }
        }

        return index; // 최종적으로 트럭에 실린 상자의 개수 반환
    }

    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        System.out.println(solution(order1)); // 2

        int[] order2 = {5, 4, 3, 2, 1};
        System.out.println(solution(order2)); // 5
    }
}