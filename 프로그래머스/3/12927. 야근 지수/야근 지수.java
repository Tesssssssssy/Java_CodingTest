import java.util.*;

public class Solution {
    /**
     *  회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
     *  야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
     *  Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
     *  Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
     *  퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해
     *  야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
     */
    public static long solution(int n, int[] works) {
        // 작업량이 큰 것부터 처리하기 위해 우선순위 큐를 내림차순으로 설정
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 모든 작업을 큐에 추가
        for (int work : works) {
            maxHeap.add(work);
        }

        /*
            남은 n시간 동안 작업 처리
            n이 0이 될 때까지 최대 작업량을 하나씩 줄인다.
        */
        while (n > 0 && !maxHeap.isEmpty()) {
            int maxWork = maxHeap.poll();  // 가장 큰 작업량 꺼내기

            if (maxWork > 0) {
                maxWork--;  // 작업량 1 줄이기
                n--;  // 1시간 사용
                maxHeap.add(maxWork);  // 줄인 작업량 다시 큐에 추가
            } else {
                break;
            }
        }

        /*
            최종 야근 피로도 계산
            모든 작업량의 제곱 합을 계산하여 최종 야근 피로도를 구힌다.
        */
        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[] works1 = {4, 3, 3};
        System.out.println(solution(n1, works1)); // 12

        int n2 = 1;
        int[] works2 = {2, 1, 2};
        System.out.println(solution(n2, works2)); // 6

        int n3 = 3;
        int[] works3 = {1, 1};
        System.out.println(solution(n3, works3)); // 0
    }
}