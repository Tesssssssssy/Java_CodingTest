class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(int i = 0; i < babbling.length; i++) {
            // replaceFirst는 자신이 바꾸고 싶은 문자열이 처음이라면 그 문자만 치환하고 끝난다.
            babbling[i] = babbling[i].replaceFirst("aya", "0");
            babbling[i] = babbling[i].replaceFirst("woo", "0");
            babbling[i] = babbling[i].replaceFirst("ye", "0");
            babbling[i] = babbling[i].replaceFirst("ma", "0");
            babbling[i] = babbling[i].replace("0", "");
            
            if(babbling[i].equals("")) answer++;
        }
        
        return answer;
    }
}