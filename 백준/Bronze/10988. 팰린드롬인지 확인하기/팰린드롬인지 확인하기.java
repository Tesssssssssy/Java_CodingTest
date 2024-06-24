import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine(); // 원본 문자열 읽기

        StringBuilder sb = new StringBuilder(original); // StringBuilder로 문자열 생성
        String reversed = sb.reverse().toString(); // 문자열을 뒤집어 새로운 문자열 생성

        int answer = original.equals(reversed) ? 1 : 0; // 원본과 뒤집은 문자열 비교

        System.out.println(answer);
    }
}