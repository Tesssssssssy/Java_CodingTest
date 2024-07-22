import java.io.*;

public class Main {
    /**
     *  - 앞으로의 모든 게임에서 지지 않는다.
     *  - 게임 기록은 다음과 같이 생겼다.
     *    - 게임 횟수 : X
     *    - 이긴 게임 : Y (Z%)
     *    - Z는 형택이의 승률이고, 소수점은 버린다.
     *      예를 들어, X=53, Y=47이라면, Z=88이다.
     *  - X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램.
     *
     *  [입력]
     *  정수 X / Y
     *
     *  [출력]
     *  게임을 최소 몇 판 더 해야하는지 출력한다.
     *  (만약 Z가 절대 변하지 않는다면 -1을 출력)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long X = Long.parseLong(input[0]); // 전체 게임 수
        long Y = Long.parseLong(input[1]); // 이긴 게임 수

        // 현재 승률 계산
        long Z = (100 * Y) / X;

        // 승률이 100%인 경우 변하지 않음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 0;
        long right = 2000000000; // 충분히 큰 수
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2; // 추가 게임 수 시도
            long newZ = (100 * (Y + mid)) / (X + mid); // 새로운 승률
            if (newZ > Z) { // 승률 변화가 있다면
                result = mid; // 결과 갱신
                right = mid - 1; // 더 작은 게임 수 찾기
            } else { // 변화가 없다면
                left = mid + 1; // 더 많은 게임 수 시도
            }
        }

        System.out.println(result);
    }
}