import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] parkingLot = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        // 주차장 정보 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                parkingLot[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS로 구역 탐색 및 점수 계산
        int maxScore = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && parkingLot[i][j] != 1) {
                    int score = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        // 점수 계산
                        if (parkingLot[x][y] == 0) score += 1;
                        else if (parkingLot[x][y] == 2) score -= 2;

                        // 주변 탐색
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && parkingLot[nx][ny] != 1) {
                                visited[nx][ny] = true;
                                queue.offer(new int[] {nx, ny});
                            }
                        }
                    }

                    // 최대 점수 갱신
                    maxScore = Math.max(maxScore, score);
                }
            }
        }

        // 결과 출력
        System.out.println(Math.max(maxScore, 0));
    }
}