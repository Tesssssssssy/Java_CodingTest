import java.io.*;

public class Main {
    /**
     *  - N마리 고양이 키움.
     *  - [마법] 생성 (최초 1마리 생성)
     *  - [마법] k마리 존재 -> 0마리 이상 k마리 이하 고양이 추가 가능
     *  - 정확히 N마리 있어야 함.
     *  - 최소 행동 횟수 출력 (마법 횟수)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int magicCount = 0;
        long catCount = 0;

        if (N == 0) {
            System.out.println(0);
            return;
        }

        catCount += 1;
        magicCount += 1;

        while (catCount < N) {
            long K = catCount;
            if (catCount + K <= N) {
                catCount += K;  // 고양이 수를 두 배로 늘릴 수 있는 경우
            } else {
                // 고양이 수를 N으로 설정하는 대신, N까지 필요한 만큼만 추가
                catCount += (N - catCount);
            }
            magicCount++;
        }

        System.out.println(magicCount);
    }
}