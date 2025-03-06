
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {

            int[] firstArr = new int[26];
            for (int j = 0; j < first.length(); j++) {
                char c = first.charAt(j);
                firstArr[c - 'A']++;
            }

            String str = br.readLine();
            int cnt = 0; // 기존 문자와 현재 문자가 같은 갯수를 나타냄
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(firstArr[c - 'A'] > 0 ){
                    cnt++;
                    firstArr[c - 'A']--;
                }
            }
            // 길이가 같은 경우
            if(first.length() == str.length() && ( str.length() == cnt || str.length() -1 == cnt ) ){
                answer++;
            } else if(first.length() == str.length() - 1 && str.length() -1  == cnt) {   // 현재 문자보다 길이가 -1 짧은경우
                answer++;
            } else if (first.length() == str.length() + 1 && str.length() == cnt){
                answer++;
            }
        }
        System.out.println(answer);

    }
}
