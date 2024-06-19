import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String people = br.readLine();
        String[] peoplePtsStr = br.readLine().split(" ");

        int answer = 0;

        for (int i = 0; i < peoplePtsStr.length; i++) {
            answer += Integer.parseInt(peoplePtsStr[i]);
        }

        System.out.println(answer);
    }
}