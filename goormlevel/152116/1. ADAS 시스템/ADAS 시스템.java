import java.io.*;
import java.util.*;

class Main {
		static int W, H;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        W = Integer.parseInt(size[0]);
        H = Integer.parseInt(size[1]);
        grid = new char[W][H];
        visited = new boolean[W][H];

        int startX = 0, startY = 0;
        for (int i = 0; i < W; i++) {
            grid[i] = br.readLine().toCharArray();
            for (int j = 0; j < H; j++) {
                if (grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int riskScore = simulate(startX, startY);
        System.out.println(Math.max(0, riskScore)); // Negative risk score is set to 0
    }

    static int simulate(int startX, int startY) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startX, startY, 0, 0));
        visited[startX][startY] = true;
        int riskScore = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (grid[current.x][current.y] == 'E') break;

            // Calculate risk for current node
            if (grid[current.x][current.y] == '0' || grid[current.x][current.y] == 'P') {
                int pCount = countP(current.x, current.y);
                if (grid[current.x][current.y] == '0') {
                    riskScore += pCount;
                } else {
                    riskScore += (pCount - 3);
                }
            }

            // Check all possible directions
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int priority = (grid[nx][ny] == 'E' ? 1 : grid[nx][ny] == 'P' ? 2 : 3);
                    queue.add(new Node(nx, ny, priority, nx * H + ny));
                }
            }
        }
        return riskScore;
    }

    static int countP(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int nx = x + i, ny = y + j;
                if (nx >= 0 && nx < W && ny >= 0 && ny < H && grid[nx][ny] == 'P') {
                    count++;
                }
            }
        }
        return count;
    }

    static class Node implements Comparable<Node> {
        int x, y, priority, index;

        Node(int x, int y, int priority, int index) {
            this.x = x;
            this.y = y;
            this.priority = priority;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.priority != other.priority)
                return Integer.compare(this.priority, other.priority);
            return Integer.compare(this.index, other.index);
        }
    }
}