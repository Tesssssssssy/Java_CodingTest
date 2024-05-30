import java.util.*;

class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        if (hashSet.size() > max)
            answer = max;
        else
            answer = hashSet.size();
        
        return answer;
    }
}