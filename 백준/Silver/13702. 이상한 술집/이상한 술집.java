import java.io.*;

public class Main {
    /**
     *  1. 막걸리를 시키면 주전자의 용량은 똑같으나 안에 있는 막걸리 용량은 랜덤.
     *  2. 막걸리 N 주전자를 주문하고, 자신을 포함한 K 명에게 똑같은 양으로 나누어준다.
     *  3. 분배 후 주전자에 막걸리가 조금 남아있다면 그냥 버린다.
     *     (한 번 주문한 막걸리에 남은 걸 모아서 다시 주는 경우 x)
     *  4. ex.)
     *     5명이 3 주전자를 주문해 1002, 802, 705가 담겨져 나왔고
     *     이를 401로 동일하게 나눴을 경우
     *     각 주전자에서 200, 0, 304 만큼 남는데, 버린다.
     *  5. 이 때, K 명에게 최대한 많은 양의 막걸리르 분배할 수 있는 용량 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 주전자 개수
        int K = Integer.parseInt(firstLine[1]); // 사람 수

        long[] volumes = new long[N];
        long maxVolume = 0;

        for (int i = 0; i < N; i++) {
            volumes[i] = Long.parseLong(br.readLine());
            maxVolume = Math.max(maxVolume, volumes[i]);
        }

        long left = 1;
        long right = maxVolume;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            int count = 0;
            for (long v : volumes) {
                count += v / mid;
            }
            if (count >= K) {
                result = mid; // 가능하면 결과 갱신
                left = mid + 1; // 더 큰 값을 찾기 위해 left 갱신
            } else {
                right = mid - 1; // mid 값이 너무 크면 줄임
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}