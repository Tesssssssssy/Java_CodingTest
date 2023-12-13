import java.util.Arrays;

public class Solution {
    static final int INF = 500001;
    boolean[] visited;
    int[] costs;
    int[] path;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[] res = findPath(N, road);
        for (int i = 0; i < res.length; i++) {
            if (res[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    public int[] findPath(int N, int[][] graph) {
        visited = new boolean[N];
        costs = new int[N];
        path = new int[N];

        Arrays.fill(costs, INF);

        int startNode = 0;
        costs[startNode] = 0;

        for (int i = 0; i < N-1; i++) {
            int minNode = findMinNode(costs, visited);

            visited[minNode] = true;

            for (int[] edge : graph) {
                int from = 0;
                int to = 0;
                int cost = 0;

                if (minNode == edge[0] - 1) {
                    from = edge[0] - 1;
                    to = edge[1] - 1;
                    cost = edge[2];
                } else if (minNode == edge[1] - 1) {
                    from = edge[1] - 1;
                    to = edge[0] - 1;
                    cost = edge[2];
                }

                if (!visited[to] && from == minNode && costs[from] + cost < costs[to]) {
                    costs[to] = costs[from] + cost;
                    path[to] = from;
                }
            }
        }
        return costs;
    }

    private int findMinNode(int[] costs, boolean[] visited) {
        int minCost = INF;
        int minNode = -1;

        for (int i = 0; i < costs.length; i++) {
            if (!visited[i] && costs[i] < minCost) {
                minCost = costs[i];
                minNode = i;
            }
        }
        return minNode;
    }
}