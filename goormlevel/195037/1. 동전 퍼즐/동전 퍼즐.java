import java.io.*;
import java.util.*;

class Main {
	/**
     * 이 문제에서 주어진 조건은 "동전을 최소한으로 이동하여 두 번째 배치와 동일하게 만드는 것".
     * 각 동전의 위치를 각각 리스트로 추출하고, 목표 위치로의 이동 중 겹치는 위치를 찾아내는 것이 중요.
     * 
     * 두 격자에서 동전의 위치를 추출하여 각각의 리스트에 저장.
     * 격자의 모든 동전 위치를 기준으로 상대적 위치를 계산하여, 두 격자의 동전이 서로 일치하는 최대 수를 구함.
     * 이동해야 하는 최소 동전 수는 전체 동전 수에서 일치하는 최대 동전 수를 뺀 값.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 격자의 크기 및 구조 입력 받기
        String[] firstLine = br.readLine().split(" ");
        int H1 = Integer.parseInt(firstLine[0]); 
        // 첫 번째 격자의 행 수
        int W1 = Integer.parseInt(firstLine[1]); 
        // 첫 번째 격자의 열 수

        List<Pair> firstCoins = new ArrayList<>(); 
        // 첫 번째 격자의 동전 위치 저장 리스트

        for (int i = 0; i < H1; i++) {
            String line = br.readLine();
            for (int j = 0; j < W1; j++) {
                if (line.charAt(j) == 'O') { // 동전이 있는 경우
                    firstCoins.add(new Pair(i, j)); 
                    // 해당 위치를 리스트에 추가
                }
            }
        }

        // 두 번째 격자의 크기 및 구조 입력 받기
        String[] secondLine = br.readLine().split(" ");
        int H2 = Integer.parseInt(secondLine[0]); 
        // 두 번째 격자의 행 수
        int W2 = Integer.parseInt(secondLine[1]); 
        // 두 번째 격자의 열 수

        List<Pair> secondCoins = new ArrayList<>(); 
        // 두 번째 격자의 동전 위치 저장 리스트

        for (int i = 0; i < H2; i++) {
            String line = br.readLine();
            for (int j = 0; j < W2; j++) {
                if (line.charAt(j) == 'O') { // 동전이 있는 경우
                    secondCoins.add(new Pair(i, j)); 
                    // 해당 위치를 리스트에 추가
                }
            }
        }

        // 겹치는 동전의 최대 수를 찾는 함수 호출
        int maxOverlap = findMaxOverlap(firstCoins, secondCoins);

        // 총 동전 수에서 최대 겹침 수를 뺀 값이 최소 이동해야 할 동전 수
        System.out.println(firstCoins.size() - maxOverlap);
    }

    // 두 리스트의 동전 위치를 비교하여 최대 겹침 수를 찾는 함수
    private static int findMaxOverlap(List<Pair> firstCoins, List<Pair> secondCoins) {
        Map<Pair, Integer> displacementCounts = new HashMap<>(); 
        // 격자 이동에 따른 동전 수 카운트
        int maxCount = 0; 
        // 최대 겹침 수

        // 모든 첫 번째 격자 동전 위치에 대해
        for (Pair p1 : firstCoins) {
            // 모든 두 번째 격자 동전 위치에 대해
            for (Pair p2 : secondCoins) {
                Pair delta = new Pair(p1.x - p2.x, p1.y - p2.y); 
                // 두 동전 위치의 상대적 차이
                displacementCounts.put(delta, displacementCounts.getOrDefault(delta, 0) + 1); 
                // 차이에 따른 카운트 증가
                maxCount = Math.max(maxCount, displacementCounts.get(delta)); 
                // 최대 겹침 수 갱신
            }
        }

        return maxCount; // 최대 겹침 수 반환
    }

    // 위치를 저장하는 간단한 클래스
    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}