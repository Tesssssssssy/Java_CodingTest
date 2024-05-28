import java.util.*;

class Solution {
        public int solution(String begin, String target, String[] words) {
        // target이 words 배열에 없으면 변환 불가능
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new Node(begin, 0)); // 시작 단어와 단계 수(0)를 큐에 추가

        // words 배열을 방문 여부 체크를 위해 리스트로 변환
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // 큐에서 노드(단어와 단계 수)를 꺼냄

            // 모든 단어를 순회하며 가능한 변환 탐색
            Iterator<String> it = wordList.iterator();
            while (it.hasNext()) {
                String nextWord = it.next();
                // 현재 단어에서 한 글자만 변경하여 nextWord가 될 수 있는지 확인
                if (canConvert(current.word, nextWord)) {
                    if (nextWord.equals(target)) { // 변환된 단어가 target과 같다면
                        return current.level + 1; // 현재 단계에서 한 단계 더 진행한 값을 반환
                    }
                    queue.add(new Node(nextWord, current.level + 1)); // 큐에 추가
                    it.remove(); // 방문한 단어는 리스트에서 제거
                }
            }
        }
        return 0; // 변환할 수 없는 경우
    }

    // 두 단어 간에 변환이 가능한지 (한 글자만 다른지) 검사하는 메서드
    private boolean canConvert(String current, String next) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                count++;
            }
            if (count > 1) return false;
        }
        return count == 1;
    }

    // BFS 탐색을 위해 사용할 노드 클래스
    static class Node {
        String word;
        int level;

        Node(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}