import java.util.*;

public class Solution {
    /**
     *  연산자 추출: 수식에서 사용된 연산자를 추출하고, 그 연산자의 우선순위 조합을 구합니다.
     *  수식 파싱: 숫자와 연산자를 따로 리스트에 저장합니다.
     *  우선순위에 따라 계산: 각 연산자 우선순위 조합에 대해 해당 우선순위에 맞춰 계산을 수행합니다.
     *  결과 비교: 모든 우선순위 조합에 대한 결과 중 절댓값이 가장 큰 결과를 반환합니다.
     */
    public static long solution(String expression) {
        // 1. 연산자를 추출하고, 우선순위 조합을 만든다.
        List<Character> ops = Arrays.asList('+', '-', '*');
        List<String> priorities = new ArrayList<>();
        permutation(ops, "", 3, priorities);

        // 2. 연산식에서 숫자와 연산자를 분리한다.
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        parseExpression(expression, numbers, operators);

        // 3. 각 우선순위에 따라 계산하고 최대 절댓값을 구한다.
        long maxResult = 0;
        for (String priority : priorities) {
            maxResult = Math.max(maxResult, Math.abs(calculate(numbers, operators, priority)));
        }
        return maxResult;
    }

    // 연산자의 우선순위를 적용하여 계산하는 함수
    private static long calculate(List<Long> numbers, List<Character> operators, String priority) {
        // 숫자와 연산자의 복사본을 사용한다.
        List<Long> numCopy = new ArrayList<>(numbers);
        List<Character> opCopy = new ArrayList<>(operators);

        for (char op : priority.toCharArray()) {
            for (int i = 0; i < opCopy.size();) {
                if (opCopy.get(i) == op) {
                    long result = applyOp(numCopy.remove(i), numCopy.remove(i), opCopy.remove(i));
                    numCopy.add(i, result);
                } else {
                    i++;
                }
            }
        }
        return numCopy.get(0);
    }

    // 연산자에 따른 계산 처리
    private static long applyOp(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    // 수식을 숫자와 연산자로 분리하는 함수
    private static void parseExpression(String expression, List<Long> numbers, List<Character> operators) {
        StringBuilder num = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                numbers.add(Long.parseLong(num.toString()));
                num.setLength(0);
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(num.toString())); // 마지막 숫자 추가
    }

    // 연산자 우선순위의 모든 조합을 구하는 함수 (순열)
    private static void permutation(List<Character> ops, String current, int length, List<String> results) {
        if (current.length() == length) {
            results.add(current);
            return;
        }
        for (Character op : ops) {
            if (!current.contains(op.toString())) {
                permutation(ops, current + op, length, results);
            }
        }
    }

    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        System.out.println(solution(expression1)); // 60420

        String expression2 = "50*6-3*2";
        System.out.println(solution(expression2)); // 300
    }
}
