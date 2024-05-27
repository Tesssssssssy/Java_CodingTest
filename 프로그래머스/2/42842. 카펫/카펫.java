import java.util.Arrays;

class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; 
        // 가로, 세로 크기를 저장할 배열

        int total = brown + yellow; 
        // 전체 격자의 수

        // 전체 격자의 수에 대해 가능한 세로 길이를 검토
        for (int height = 3; height <= (int) Math.sqrt(total); height++) {
            if (total % height == 0) { 
                // 세로 길이가 전체 격자 수의 약수인 경우
                
                int width = total / height; 
                // 가로 길이 계산
                
                if ((width - 2) * (height - 2) == yellow) {
                    // brown 계산 공식을 사용해 검증
                    
                    answer[0] = width; // 가로 길이
                    answer[1] = height; // 세로 길이
                    break; // 조건에 맞는 크기를 찾으면 반복 종료
                }
            }
        }

        return answer; // 계산된 가로, 세로 길이 반환
    }
}