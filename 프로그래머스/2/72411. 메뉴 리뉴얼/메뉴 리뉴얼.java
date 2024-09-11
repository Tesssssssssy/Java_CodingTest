import java.util.*;

public class Solution {
    /**
     *  레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있다.
     *  기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했다.
     *  어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는
     *  이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했다.
     *  단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 한다.
     *  또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했다.
     *
     *  예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
     *  (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기한다.)
     *
     *  손님 번호	 주문한 단품메뉴 조합
     *  1번 손님	 A, B, C, F, G
     *  2번 손님	 A, C
     *  3번 손님	 C, D, E
     *  4번 손님	 A, C, D, E
     *  5번 손님	 B, C, F, G
     *  6번 손님	 A, C, D, E, H
     *
     *  가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같다.
     *
     *  코스 종류	메뉴 구성	설명
     *  요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐다.
     *  요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐다.
     *  요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐다.
     *  요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐다.
     *
     *  [문제]
     *  각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders,
     *  "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
     *  "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해라.
     */
    public static String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int courseSize : course) {
            Map<String, Integer> combinationCount = new HashMap<>();

            for (String order : orders) {
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                combinationHelper(orderArr, new boolean[orderArr.length], 0, courseSize, combinationCount);
            }

            int maxCount = 2;
            for (int count : combinationCount.values()) {
                maxCount = Math.max(maxCount, count);
            }

            for (Map.Entry<String, Integer> entry : combinationCount.entrySet()) {
                if (entry.getValue() == maxCount) {
                    answerList.add(entry.getKey());
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private static void combinationHelper(char[] orderArr, boolean[] visited, int start, int r, 
                                          Map<String, Integer> combinationCount) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(orderArr[i]);
                }
            }
            String combination = sb.toString();
            combinationCount.put(combination, combinationCount.getOrDefault(combination, 0) + 1);
            return;
        }

        for (int i = start; i < orderArr.length; i++) {
            visited[i] = true;
            combinationHelper(orderArr, visited, i + 1, r - 1, combinationCount);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders1, course1)));
        // ["AC", "ACDE", "BCFG", "CDE"]

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};
        System.out.println(Arrays.toString(solution(orders2, course2)));
        // ["ACD", "AD", "ADE", "CD", "XYZ"]

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders3, course3)));
        // ["WX", "XY"]
    }
}