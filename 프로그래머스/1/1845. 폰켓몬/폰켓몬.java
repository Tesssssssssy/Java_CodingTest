import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> pokemonTypes = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            pokemonTypes.put(num, pokemonTypes.getOrDefault(num, 0) + 1);
        }

        int numTypes = pokemonTypes.size();

        return Math.min(numTypes, n / 2);
    }
}