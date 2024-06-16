import java.util.*;

class Solution {
    public static int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeCnt = new HashMap<>();
        // 각 노드의 '들어오는', '나가는' 연결 수를 저장할 해시맵
        int[] answer = {0, 0, 0, 0};
        // 결과값을 저장할 배열

        // 각 엣지를 순회하면서 들어오는, 나가는 연결 수를 계산
        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0]; // 시작 노드
            int b = edge[1]; // 끝 노드
            if (!nodeCnt.containsKey(a)) {
                nodeCnt.put(a, new int[]{0, 0}); // 시작 노드 초기화
            }
            if (!nodeCnt.containsKey(b)) {
                nodeCnt.put(b, new int[]{0, 0}); // 끝 노드 초기화
            }
            nodeCnt.get(a)[0] += 1; // 시작 노드의 '나가는' 연결 증가
            nodeCnt.get(b)[1] += 1; // 끝 노드의 '들어오는' 연결 증가
        });

        int[] cnts;
        for (int key : nodeCnt.keySet()) {
            cnts = nodeCnt.get(key);

            // '들어오는' 연결이 없고 '나가는' 연결이 2개 이상인 경우, 정점이 됨
            if (cnts[0] >= 2 && cnts[1] == 0) {
                answer[0] = key; // 정점으로 설정
            }
            // '나가는' 연결이 없고 '들어오는' 연결이 있는 경우, 막대 그래프 개수 증가
            else if (cnts[0] == 0 && cnts[1] > 0) {
                answer[2]++;
            }
            // '들어오는'과 '나가는' 연결이 각각 2개 이상인 경우, 8자 그래프 개수 증가
            else if (cnts[0] >= 2 && cnts[1] >= 2) {
                answer[3]++;
            }
        }

        // 도넛 그래프의 개수 계산: 정점에서 나가는 노드 수에서 막대와 8자 그래프의 개수를 빼줌
        answer[1] = nodeCnt.get(answer[0])[0] - answer[2] - answer[3];

        return answer; // 계산된 결과 반환
    }
}