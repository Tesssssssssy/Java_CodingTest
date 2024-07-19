import java.io.*;
import java.util.*;

public class Main {
    /**
     *  1. 스티커 2n개를 구매 / 2행 n열로 배치
     *  2. 스티커 한 장을 떼면, 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게 된다.
     *     즉, 뗀 스티커의 왼쪽, 오른쪽, 위, 아래에 있는 스티커는 사용할 수 없게 된다.
     *  3. 모든 스티커를 붙일 수 없게된 상냥이는 각 스티커에 점수를 매기고,
     *     점수의 합이 최대가 되게 스티커를 떼어내려고 한다.
     *  4. 각 스티커에 점수를 매겼다. 상냥이가 뗄 수 있는 스티커의 점수의 최댓값 출력.
     *     2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
     *  5. ex.)
     *     50, 50, 100, 60인 스티커를 고르면,
     *     점수는 260이 되고 이 것이 최대 점수이다.
     *     가장 높은 점수를 가지는 두 스티커 (100과 70)은 변을 공유하기 때문에, 동시에 뗄 수 없다.
     *
     *  [풀이]
     *  조합
     *  - 해당 열의 어느 스티커도 선택하지 않는 경우.
     *  - 해당 열의 위쪽 스티커만 선택하는 경우.
     *  - 해당 열의 아래쪽 스티커만 선택하는 경우.
     *
     *  [정의]
     *  - dp[i][0]: i번째 열까지 고려했을 때, i번째 열에서 스티커를 선택하지 않는 경우의 최대 점수.
     *  - dp[i][1]: i번째 열까지 고려했을 때, i번째 열에서 위쪽 스티커만 선택하는 경우의 최대 점수.
     *  - dp[i][2]: i번째 열까지 고려했을 때, i번째 열에서 아래쪽 스티커만 선택하는 경우의 최대 점수.
     *  
     *  [점화식]
     *  - dp[i][0] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
     *  - dp[i][1] = max(dp[i-1][0], dp[i-1][2]) + sticker[0][i]
     *  - dp[i][2] = max(dp[i-1][0], dp[i-1][1]) + sticker[1][i]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[3][n + 1];

            // 스티커 점수 입력
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sticker[i][j - 1] = Integer.parseInt(st.nextToken());
                }
            }

            // DP 초기 설정
            dp[0][1] = 0;
            dp[1][1] = sticker[0][0];
            dp[2][1] = sticker[1][0];

            // DP 배열을 사용하여 최대 점수 계산
            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[0][j - 1], Math.max(dp[1][j - 1], dp[2][j - 1]));
                dp[1][j] = Math.max(dp[0][j - 1], dp[2][j - 1]) + sticker[0][j - 1];
                dp[2][j] = Math.max(dp[0][j - 1], dp[1][j - 1]) + sticker[1][j - 1];
            }

            // 최대값을 결과 문자열에 추가
            int maxResult = Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n]));
            sb.append(maxResult).append('\n');
        }
        System.out.println(sb);
    }
}