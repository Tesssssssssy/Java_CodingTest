class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replaceFirst("aya", "2");
            babbling[i] = babbling[i].replaceFirst("ye", "2");
            babbling[i] = babbling[i].replaceFirst("woo", "2");
            babbling[i] = babbling[i].replaceFirst("ma", "2");
            babbling[i] = babbling[i].replace("2", "");
            
            if (babbling[i].equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}