import java.util.*;

public class Solution {
    public static String[] solution(String[] files) {
        Arrays.sort(files, (file1, file2) -> {
            // 파일명을 HEAD, NUMBER, TAIL로 분리
            String[] file1Parts = splitFileName(file1);
            String[] file2Parts = splitFileName(file2);

            // HEAD 비교 (대소문자 구분하지 않음)
            int headComparison = file1Parts[0].compareToIgnoreCase(file2Parts[0]);
            if (headComparison != 0) {
                return headComparison;
            }

            // HEAD가 같다면 NUMBER 비교 (숫자로 비교)
            int number1 = Integer.parseInt(file1Parts[1]);
            int number2 = Integer.parseInt(file2Parts[1]);
            return Integer.compare(number1, number2);
        });
        return files;
    }

    private static String[] splitFileName(String file) {
        // 정규식으로 HEAD와 NUMBER, TAIL 부분 나누기
        String head = "";
        String number = "";
        String tail = "";

        int i = 0;

        // HEAD 추출 (숫자가 나오기 전까지)
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        // NUMBER 추출 (숫자가 나오는 동안)
        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }

        // TAIL 추출 (나머지 부분)
        if (i < file.length()) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }

    public static void main(String[] args) {
        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files1)));
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]

        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(solution(files2)));
        // ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
    }
}