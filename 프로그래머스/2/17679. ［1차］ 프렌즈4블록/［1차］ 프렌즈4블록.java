public class Solution {
    public static int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int totalRemoved = 0;

        while (true) {
            boolean[][] toRemove = new boolean[m][n];
            int removed = 0;

            // 2x2 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char block = map[i][j];
                    if (block != ' ' && block == map[i][j + 1] && block == map[i + 1][j] && block == map[i + 1][j + 1]) {
                        toRemove[i][j] = toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = toRemove[i + 1][j + 1] = true;
                    }
                }
            }

            // 제거할 블록 체크 및 제거
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toRemove[i][j]) {
                        map[i][j] = ' ';
                        removed++;
                    }
                }
            }

            // 제거된 블록이 없다면 종료
            if (removed == 0) {
                break;
            }

            totalRemoved += removed;

            // 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        char temp = map[i][j];
                        map[i][j] = ' ';
                        map[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }

        return totalRemoved;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 5,
                new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"})); // 14
        System.out.println(solution(6, 6,
                new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"})); // 15
    }
}