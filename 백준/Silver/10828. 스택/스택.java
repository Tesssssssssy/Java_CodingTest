import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - push X: 정수 X를 스택에 넣는 연산.
     *    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력.
     *         만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력.
     *    size: 스택에 들어있는 정수의 개수를 출력.
     *    empty: 스택이 비어있으면 1, 아니면 0을 출력.
     *    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 명령의 수 N을 입력받음
        Stack<Integer> stack = new Stack<>();    // 정수를 저장할 스택 생성
        StringBuilder sb = new StringBuilder();  // 출력을 위한 StringBuilder

        for (int i = 0; i < N; i++) {
            String input = br.readLine();  // 명령 읽기
            if (input.startsWith("push")) { // push 명령인 경우
                int value = Integer.parseInt(input.split(" ")[1]); // 정수 X 추출
                stack.push(value);  // 스택에 push
            } else if (input.equals("pop")) { // pop 명령인 경우
                if (stack.isEmpty()) {
                    sb.append("-1\n"); // 스택이 비어있으면 -1 출력
                } else {
                    sb.append(stack.pop() + "\n"); // 스택에서 pop 하고 값 출력
                }
            } else if (input.equals("size")) { // size 명령인 경우
                sb.append(stack.size() + "\n"); // 스택의 크기 출력
            } else if (input.equals("empty")) { // empty 명령인 경우
                sb.append((stack.isEmpty() ? "1" : "0") + "\n"); // 스택이 비어있으면 1, 아니면 0 출력
            } else if (input.equals("top")) { // top 명령인 경우
                if (stack.isEmpty()) {
                    sb.append("-1\n"); // 스택이 비어있으면 -1 출력
                } else {
                    sb.append(stack.peek() + "\n"); // 스택의 top 출력
                }
            }
        }

        System.out.print(sb);
    }
}