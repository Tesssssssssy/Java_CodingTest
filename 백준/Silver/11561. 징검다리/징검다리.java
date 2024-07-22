import java.io.*;

public class Main {
    /**
     *  1. 수영을 못하기 때문에, 강에 놓인 징검다리를 밟고 건너갈 것.
     *  2. 원하는 어느 곳으로든지 점프해서 바로 갈 수가 있다.
     *  3. 강엔 1번부터 시작해 2번, 3번, ... , N번 징검다리
     *  4. 적절한 개수의 징검다리만을 밟고 가기로 했다.
     *  5. 더 재미있게 강을 건너기 위해 승택이는 다음과 같은 규칙
     *     - 첫 징검다리는 점프해서 아무 것이나 밟을 수 있다. 이 점프가 첫 점프이다.
     *     - 두 번째 점프부터는 이전에 점프한 거리보다 1 이상 더 긴 거리를 뛰어야만 한다.
     *     - N번 징검다리는 반드시 밟아야 한다.
     *     - N번 징검다리를 밟은 후 강 건너로 이동할 땐 점프를 하지 않으므로 위의 규칙이 적용되지 않는다.
     *  6. 승택이가 위의 규칙을 지키며 강을 건널 때, 밟을 수 있는 징검다리의 최대 수는 몇 개일까?
     *
     *  [입력]
     *  테스트 케이스의 수 T
     *  각 테스트 케이스는 정수 한 개로 이루어져 있으며, 징검다리의 총 수 N을 의미
     *
     *  [출력]
     *  각 테스트 케이스마다 한 줄에 승택이가 밟을 수 있는 최대 징검다리 수를 출력
     *  
     *  시간 복잡도: O(log N)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());  // 징검다리의 총 수

            long left = 1, right = 2000000000;  // k 값의 탐색 범위
            long answer = 1;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                // mid 값을 계산하여 k * (k + 1) / 2가 N보다 작거나 같은지 확인

                if (mid * (mid + 1) / 2 <= N) {
                    answer = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // 가능한 경우 answer를 업데이트하고 left를 조정하며, 그렇지 않은 경우 right를 조정
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}