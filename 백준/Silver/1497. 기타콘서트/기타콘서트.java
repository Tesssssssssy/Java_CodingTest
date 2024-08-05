import java.io.*;
import java.util.*;

public class Main {
    /**
     *  - 최대한 많은 곡을 제대로 연주하려고 할 때, 필요한 기타의 최소 개수를 구하는 프로그램
     *  - ex.)
     *        GIBSON 으로 1, 2, 3번 곡을 제대로 연주할 수 있고,
     *        FENDER 로 1, 2, 5번 곡을 제대로 연주할 수 있고,
     *        EPIPHONE 으로 4, 5번 곡을 제대로 연주할 수 있고,
     *        ESP 로 1번곡을 제대로 연주할 수 있다면,
     *        -> 세준이는 EPIPHONE 과 GIBSON 을 사면 최소의 개수로 모든 곡을 연주할 수 있다.
     *
     *  [입력]
     *  기타의 개수 N (<= 10), 곡의 개수 M (<= 50)
     *  N개의 줄에 기타의 이름과 연주할 수 있는 곡의 정보 (1번 곡부터)
     *
     *  [출력]
     *  필요한 기타의 개수
     *  (연주할 수 있는 곡이 없으면 -1 출력)
     */

    // 기타 정보
    static class guitar{
        String name;
        boolean[] song;
        int canPlay;

        public guitar(String name, boolean[] song, int canPlay) {
            this.name = name;
            this.song = song;
            this.canPlay = canPlay;
        }
    }

    static guitar[] guitars;  // 입력받은 기타들
    static int[] index;  // 선택된 기타들
    static int N, M, maxCanPlay, guitarNum; // 입력 기타 개수, 입력 곡 개수, 최대로 연주할 수 있는 곡의 개수, 기타 개수 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;

        index = new int[N];
        guitars = new guitar[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean[] song = new boolean[M];
            int can = 0;

            String canPlay = st.nextToken();
            for(int j = 0; j<M; j++){
                song[j] = (canPlay.charAt(j) == 'Y') ? true : false;
                if(song[j]) {
                    can++;
                    result++;
                }
            }
            // 기타 정보 입력받기
            guitars[i] = new guitar(name, song, can);
        }

        // 기타 조합으로 선택
        for (int i = 1; i<=N; i++) {
            com(0, 0, i);
        }

        // 한곡도 연주 못하면 -1 출력
        if (result==0) 
            System.out.println(-1);
            // 필요한 기타 수 출력
        else 
            System.out.println(guitarNum);
    }

    // 기타 선택(조합)
    public static void com(int cnt, int start, int max) {
        if (cnt == max) {
            if (check(guitars, index, max)) {
                return;
            }
            return;
        }

        for (int i = start; i<N; i++) {
            index[cnt] = i;
            com(cnt+1, i+1, max);
        }
    }

    // 연주 가능한지 확인
    public static boolean check(guitar[] guitars, int[] index, int max) {
        boolean result = true;
        int can = 0;
        
        for (int i = 0; i<M; i++) {
            boolean guitarCheck = guitars[index[0]].song[i];
            // 첫번째 기타로 연주할 수 없는 곡이라면 다른 기타로 연주할 수 있는지 확인
            if (!guitarCheck) {
                for(int j = 1; j<max; j++) {
                    guitarCheck = guitars[index[j]].song[i] || guitarCheck;
                }
            }
            // 기타 연주가 가능한지 여부 기록
            if (!guitarCheck) 
                result = false;
            if (guitarCheck) 
                can++;
        }

        // 연주 가능한 곡이 최대라면 연주 가능한 곡 수와 기타 수 갱신
        if (maxCanPlay < can) {
            maxCanPlay = can;
            guitarNum = max;
        }
        return result;
    }
}