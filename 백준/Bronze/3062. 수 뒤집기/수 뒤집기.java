import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());  
            String reversedStr = new StringBuilder(String.valueOf(N)).reverse().toString();
            int reversedN = Integer.parseInt(reversedStr);  // 뒤집힌 문자열을 숫자로 변환

            String sumStr = String.valueOf(N + reversedN);  // 원래 수와 뒤집힌 수의 합
            String reversedSumStr = new StringBuilder(sumStr).reverse().toString();

            if (sumStr.equals(reversedSumStr)) {  // 좌우 대칭인지 비교
                result.append("YES\n");
            } else {
                result.append("NO\n");
            }
        }

        System.out.print(result);  // 결과 출력
    }
}