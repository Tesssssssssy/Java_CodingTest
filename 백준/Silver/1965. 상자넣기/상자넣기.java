import java.io.*;

public class Main {
    /**
     *  1. 정육면체 상자가 일렬로 늘어서 있다.
     *  2. 상자마다 크기가 있는데, 앞 상자의 크기가 뒤 상자의 크기보다 작으면
     *     앞 상자를 뒤 상자 안에 넣을 수 있다.
     *     ex.) 1, 5, 2, 3, 7  5개의 상자가 있다면
     *          1 상자를 5 상자에 넣고, 다시 5 상자를 7상자에 넣을 수 있다.
     *  3. 이렇게 상자를 넣을 수 있는 방법은 여러 가지가 있을 수 있다.
     *     ex.) 1, 5, 2, 3, 7  5개의 상자가 있을 때
     *          크기 순으로 1, 2, 3, 7을 선택하면 총 4개의 상자가 한 개의 상자에 들어간다.
     *  4. 한 번에 넣을 수 있는 최대의 상자 개수 출력
     *
     *  [풀이]
     *  1. 가장 긴 증가하는 부분 수열(Longest Increasing Subsequence, LIS) 문제
     *  2. 최대로 겹쳐 넣을 수 있는 상자의 개수를 찾는 건,
     *     해당 배열에서 가장 긴 증가하는 부분 수열의 길이를 찾는 것과 동일
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputStr = br.readLine().split(" ");

        int[] boxes = new int[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(inputStr[i]);
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        /*
            상자의 크기가 증가하는 순서대로 증가하는 부분 수열을 구하려면,
            각 상자 i에 대해 그 앞에 있는 모든 상자 j (0 ≤ j < i)를 검사해서,
            boxes[j]가 boxes[i]보다 작을 경우에만 dp[i]를 업데이트해야 함.
        */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}