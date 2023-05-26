import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cbnu3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] students = new int[n];
        int prof;
        int jo;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        prof = Integer.parseInt(st.nextToken());
        jo = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            if (students[i] <= n){
                answer += 1;
                continue;
            }
            int rest = students[i] - prof;
            int joNumber = rest / jo +1 ;
            answer += 1 + joNumber;
        }

        System.out.println(answer);
    }
}
