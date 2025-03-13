
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        boolean[] checked = new boolean[n + 1];

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'P'){
                for (int j = i - k; j < i + k + 1 ; j++) {
                    if(j >= 0 && j < str.length() && str.charAt(j) == 'H' && !checked[j]){
                        checked[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
