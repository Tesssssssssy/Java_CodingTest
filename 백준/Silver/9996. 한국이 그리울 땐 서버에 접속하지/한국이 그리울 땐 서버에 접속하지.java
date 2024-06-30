import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        // 중요: 별표 '*'의 위치를 찾고, 패턴을 두 부분으로 나눔
        int starIndex = pattern.indexOf('*');
        String startPattern = pattern.substring(0, starIndex);
        String endPattern = pattern.substring(starIndex + 1);

        String[] isCorrect = new String[N];

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();
            if (fileName.startsWith(startPattern) &&
                    fileName.endsWith(endPattern) &&
                    fileName.length() >= startPattern.length() + endPattern.length()) {
                isCorrect[i] = "DA";
            } else {
                isCorrect[i] = "NE";
            }
        }

        for (String str : isCorrect) {
            System.out.println(str);
        }
    }
}