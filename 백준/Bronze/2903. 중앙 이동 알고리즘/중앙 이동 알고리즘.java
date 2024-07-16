import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = (int) Math.pow((1 << N) + 1, 2);  // 점의 총 개수 계산
        System.out.println(result);  // 결과 출력
    }
}

/*
    이 문제는 각 단계마다 생성되는 정사각형의 각 변에 중간점을 추가하고,
    정사각형의 중앙에 하나의 점을 추가함으로써 점의 수가 어떻게 증가하는지를 계산하는 문제.
    각 단계를 거칠 때마다 정사각형의 수가 4배로 증가하며, 이로 인해 점의 수도 특정 패턴으로 증가.
    
    N단계 후의 점의 수는 다음 수식을 통해 계산:
        P(N) = (2^N + 1)^2
        이 수식은 각 단계에서 형성되는 격자의 크기를 나타냄.
        ex.)
           N=1, 2^1 + 1 = 3이므로 3^2 = 9점이 있다.
           N=2, 2^2 + 1 = 5이므로 5^2 = 25점이 있다.
           
    위 코드에서 1 << N 은 2^N을 계산하느 빠른 방법 (비트 시프트 연ㅌ산)
    이렇게 연산된 값에 1을 더하고, 그 결과를 제곱하여 점의 총 수를 얻는다. 
    이 방식은 N의 값이 15까지 허용되는 범위 내에서 빠르고 정확하게 계산됨.
*/