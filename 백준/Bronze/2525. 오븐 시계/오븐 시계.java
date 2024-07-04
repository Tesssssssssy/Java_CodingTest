import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] timeStr = br.readLine().split(" ");
        int hour = Integer.parseInt(timeStr[0]);
        int minute = Integer.parseInt(timeStr[1]);
        int cookingTime = Integer.parseInt(br.readLine());

        minute += cookingTime;

        // 분이 60을 초과하는 경우 시간으로 옮깁니다
        hour += minute / 60;
        minute %= 60;

        // 시간이 24를 초과하는 경우를 처리합니다
        hour %= 24;

        // 결과 출력
        System.out.println(hour + " " + minute);
    }
}