class Solution {
    public static int solution(String name) {
        int minMoves = name.length() - 1; // 오른쪽으로만 갔을 때의 기본 이동 횟수
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            // 알파벳을 변경하는 최소 횟수
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 다음 문자부터 연속된 'A'의 끝 인덱스를 찾음
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 현재 위치 i에서 다시 돌아가는 경우와 전체 길이에서 연속된 'A'를 제외한 나머지를 방문하는 경우 중 최소 비용을 찾는다.
            // i + i: 현재 위치에서 다시 시작점으로 돌아간 후, 연속된 A가 끝난 다음 위치로 이동
            // length - next: A가 끝난 지점에서 끝까지 남은 문자 수
            minMoves = Math.min(minMoves, i + name.length() - next + Math.min(i, name.length() - next));
        }

        answer += minMoves;
        return answer;

        // 이름의 길이가 최대 20이므로, O(n) 시간복잡도
    }
}