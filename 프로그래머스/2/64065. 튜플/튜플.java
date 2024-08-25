import java.util.*;

public class Solution {
    /**
     *  셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple).
     *  n개의 요소를 가진 튜플을 n-튜플(n-tuple) - (a1, a2, a3, ..., an)
     *
     *  튜플은 다음과 같은 성질을 가지고 있습니다.
     *  - 중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
     *  - 원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
     *  - 튜플의 원소 개수는 유한합니다.
     *
     *  원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수),
     *  이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.
     *  {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
     *
     *  예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는
     *  - {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
     *  와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로
     *  - {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
     *  - {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
     *  - {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
     *  는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.
     *
     */
    public static int[] solution(String s) {
        // 문자열에서 중괄호를 제거하고, 각 집합을 파싱하여 리스트에 담기
        String[] sets = s.replaceAll("[{}]", " ").trim().split(" , ");

        // 각 집합을 리스트에 담은 후, 원소 개수에 따라 정렬
        List<Set<Integer>> list = new ArrayList<>();
        for (String set : sets) {
            Set<Integer> setData = new HashSet<>();
            for (String num : set.split(",")) {
                setData.add(Integer.parseInt(num.trim()));
            }
            list.add(setData);
        }

        // 원소 개수에 따라 정렬
        list.sort(Comparator.comparingInt(Set::size));

        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        // 정렬된 리스트에서 새로운 원소를 추가
        for (Set<Integer> set : list) {
            for (Integer num : set) {
                if (!seen.contains(num)) {
                    seen.add(num);
                    result.add(num);
                    break;
                }
            }
        }

        // 결과 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        System.out.println(Arrays.toString(solution(s1))); // [2, 1, 3, 4]

        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(solution(s2))); // [2, 1, 3, 4]

        String s3 = "{{20,111},{111}}";
        System.out.println(Arrays.toString(solution(s3))); // [111, 20]

        String s4 = "{{123}}";
        System.out.println(Arrays.toString(solution(s4))); // [123]

        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(s5))); // [3, 2, 4, 1]
    }
}
