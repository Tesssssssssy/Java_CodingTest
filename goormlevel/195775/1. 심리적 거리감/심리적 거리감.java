import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        
        int N = Integer.parseInt(st.nextToken());  // 섬의 개수
        int M = Integer.parseInt(st.nextToken());  // 다리의 개수
        int K = Integer.parseInt(st.nextToken());  // 구름이가 사는 섬의 번호

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int si = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            graph.get(si).add(ei);
        }

        // 최단 거리를 저장할 배열, 접근 불가능한 경우를 고려해 큰 값으로 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        // BFS를 이용한 최단 거리 계산
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(K);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }

        // 심리적 거리감 계산 및 최댓값 찾기
        int maxDistance = -1;
        int maxIsland = -1;
        for (int i = 1; i <= N; i++) {
            if (i != K && dist[i] != Integer.MAX_VALUE) {
                int psychologicalDistance = dist[i] + Math.abs(K - i);
                if (psychologicalDistance > maxDistance) {
                    maxDistance = psychologicalDistance;
                    maxIsland = i;
                } else if (psychologicalDistance == maxDistance) {
                    if (i > maxIsland) {
                        maxIsland = i;
                    }
                }
            }
        }

        System.out.println(maxIsland == -1 ? -1 : maxIsland);
    }
}