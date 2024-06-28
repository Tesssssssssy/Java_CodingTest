import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i <= N; i++) {
            int sum = i; // 현재 숫자 i를 sum에 더함
            int number = i; // 숫자를 각 자리수로 분해하기 위해 number에 저장

            // 숫자의 각 자리수를 더함
            while (number != 0) {
                sum += number % 10; // 마지막 자리수를 sum에 더함
                number /= 10; // 마지막 자리수를 제거
            }

            // 분해합이 N과 같으면 결과를 i로 설정하고 루프 종료
            if (sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}