import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int solution(int n, int[][] wires) {
        // 주어진 전력망을 끊어 두 부분으로 나누고, 두 부분 간의 송전탑 개수 차이의 최소값을 반환.

        int minDifference = Integer.MAX_VALUE;
        // 최소 차이를 최대 값으로 초기화

        List<List<Integer>> graph = new ArrayList<>();
        // 그래프를 리스트의 리스트 형태로 초기화. 각 노드가 연결된 노드들의 목록을 보관.

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 전선 정보를 이용하여 양방향 그래프를 구성.
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        // 각 전선을 차례로 끊어보며 두 전력망의 크기 차이를 계산.
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            // 방문 여부를 체크할 배열을 초기화.

            // 현재 끊을 전선 정보를 변수에 저장.
            int nodeA = wire[0];
            int nodeB = wire[1];

            // 끊을 전선을 그래프에서 제거.
            graph.get(nodeA).remove((Integer) nodeB);
            graph.get(nodeB).remove((Integer) nodeA);

            // DFS를 통해 한쪽 네트워크의 크기를 계산.
            int componentSize = dfs(nodeA, graph, visited);

            // 전체 노드에서 한쪽 네트워크의 크기를 빼면 다른 네트워크의 크기.
            int otherComponentSize = n - componentSize;

            // 두 네트워크의 크기 차이를 계산.
            int difference = Math.abs(componentSize - otherComponentSize);
            // 찾은 차이가 이전에 찾은 최소 차이보다 작다면 갱신.
            minDifference = Math.min(minDifference, difference);

            // 끊었던 전선을 그래프에 다시 추가하여 원상 복구.
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        // 계산된 최소 차이를 반환.
        return minDifference;
    }

    // dfs 함수: 깊이 우선 탐색을 수행하여 연결된 컴포넌트의 크기를 반환.
    private static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        // 현재 노드를 방문 처리.
        visited[node] = true;
        // 컴포넌트의 크기를 1(현재 노드)로 시작.
        int size = 1;

        // 현재 노드에 연결된 모든 이웃 노드에 대해 반복.
        for (int neighbor : graph.get(node)) {
            // 아직 방문하지 않은 이웃이 있다면 DFS를 재귀적으로 호출.
            if (!visited[neighbor]) {
                size += dfs(neighbor, graph, visited);
            }
        }

        // 연결된 컴포넌트의 전체 크기를 반환.
        return size;
    }
}