import java.io.*;
import java.util.*;

class Main {
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] fireSpreadTime = new int[R][C];
        Queue<int[]> fireQueue = new LinkedList<>();
        int cloudX = -1, cloudY = -1;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(fireSpreadTime[i], -1); // -1로 초기화
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '@') {
                    fireQueue.offer(new int[]{i, j});
                    fireSpreadTime[i][j] = 0;
                } else if (map[i][j] == '&') {
                    cloudX = i;
                    cloudY = j;
                }
            }
        }

        // 불 번짐 시뮬레이션 (BFS)
        while (!fireQueue.isEmpty()) {
            int[] pos = fireQueue.poll();
            int x = pos[0], y = pos[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != '#' && fireSpreadTime[nx][ny] == -1) {
                    fireSpreadTime[nx][ny] = fireSpreadTime[x][y] + 1;
                    fireQueue.offer(new int[]{nx, ny});
                }
            }
        }

        // 구름이 주변의 불 번짐 시간 중 최소값을 찾음
        int minTime = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            int nx = cloudX + dx[d];
            int ny = cloudY + dy[d];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && fireSpreadTime[nx][ny] != -1) {
                minTime = Math.min(minTime, fireSpreadTime[nx][ny]);
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }
}
