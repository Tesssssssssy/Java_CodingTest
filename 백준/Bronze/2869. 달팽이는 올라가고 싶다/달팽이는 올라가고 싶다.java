import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken());

        // 마지막 날을 제외한 필요 일수 계산
        int days = (top - down) / (up - down);

        // 만약 나누어 떨어지지 않는다면 하루를 더 추가해야 함
        if ((top - down) % (up - down) != 0) {
            days++;
        }

        System.out.println(days);
    }
}