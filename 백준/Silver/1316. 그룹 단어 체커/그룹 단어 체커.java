import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int answer = 0; // 그룹 단어의 개수를 세는 변수

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            if (isGroupWord(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 그룹 단어인지 판별하는 메소드
    private static boolean isGroupWord(String word) {
        Set<Character> seen = new HashSet<>(); // 이미 나온 문자를 저장하는 Set
        char lastChar = '\0'; // 직전에 확인한 문자를 저장하는 변수

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentChar != lastChar) { // 새로운 문자가 나타나면
                if (seen.contains(currentChar)) { // 이미 나타난 문자라면 그룹 단어가 아님
                    return false;
                }
                seen.add(currentChar); // 문자를 Set에 추가
                lastChar = currentChar; // 마지막 문자 업데이트
            }
        }
        return true; // 모든 문자가 조건을 만족하면 그룹 단어임
    }
}

/*
    직전에 확인한 문자를 저장하는 변수는 코드에서 lastChar라는 이름으로 사용.
    이 변수의 역할은 현재 검사 중인 문자가 이전 문자와 동일한지를 판별하는 데 중요.
    이는 그룹 단어를 확인할 때 연속성을 검증하는 데 필요한 중요한 요소.

    문자열을 순회하면서 각 문자가 이전 문자와 같은지,
    아니면 새로운 문자인지를 판별하는 데 사용됨.
    만약 새로운 문자라면, 이 문자가 이전에 이미 나타났는지 확인하기 위해 사용됨.

    lastChar는 초기에 '\0' (null 문자)로 설정됨.
    이는 문자열의 시작에서 첫 번째 문자가 처리될 때 아직 어떤 문자도 처리되지 않았음을 나타냄.

    문자열을 순회할 때마다 현재 문자(currentChar)를 확인하고, 이전에 검사한 문자(lastChar)와 비교.
    만약 이들이 다르면, 즉 새로운 문자가 시작되었다면,
    lastChar를 현재 문자로 업데이트하여 계속해서 다음 문자와의 비교를 수행할 수 있도록 함.

    lastChar 변수는 그룹 단어를 검사하는 과정에서 문자의 연속성을 확인하는 데 중심적인 역할을 함.
    예를 들어, 단어 "hello"에서 'l' 다음에 또 다른 'l'이 오는 것은 괜찮지만,
    'e' 후에 'l'이 오고 다시 'e'가 오면 그룹 단어가 아님.
    이 경우, 'e'가 이미 나타났으며 연속적이지 않게 다시 나타났기 때문에, 이를 검출하는 데 lastChar가 필요.
*/