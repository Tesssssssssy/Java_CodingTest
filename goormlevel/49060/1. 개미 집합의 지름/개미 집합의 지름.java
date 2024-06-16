import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 D 값을 읽음
        String[] firstLine = br.readLine().split(" ");
        int D = Integer.parseInt(firstLine[1]); // 개미 집합의 최대 지름 D

        // 두 번째 줄에서 개미의 위치를 읽음
        String[] positionsStr = br.readLine().split(" ");
        int[] positions = new int[positionsStr.length];

        // 문자열 배열에서 정수 배열로 변환
        for (int i = 0; i < positions.length; i++) {
            positions[i] = Integer.parseInt(positionsStr[i]);
        }

        // 개미 위치를 오름차순으로 정렬
        Arrays.sort(positions);

        // 최소 제거 개미 수를 최대 개미 수로 초기화
        int minRemove = positions.length;

        // 투 포인터 초기화
        int left = 0;
        int right = 0;

        // right 포인터를 배열 끝까지 이동시키면서 조건을 검사
        while (right < positions.length) {
            // 현재 left와 right 사이의 거리가 D 이하인 경우, right 포인터를 증가시키며 범위 확장
            while (right < positions.length && positions[right] - positions[left] <= D) {
                right++;
            }
            // 현재 left부터 right-1까지의 집합은 지름 D 이하를 만족
            // 전체 개미 수에서 현재 범위의 개미 수를 빼 제거할 개미 수를 계산
            minRemove = Math.min(minRemove, positions.length - (right - left));
            // left 포인터를 증가시켜 새로운 범위 탐색 시작
            left++;
        }

        // 최소로 제거해야 하는 개미 수 출력
        System.out.println(minRemove);
    }
}