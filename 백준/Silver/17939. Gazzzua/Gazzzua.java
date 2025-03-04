
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            int now = arr[i];

        }

        int maxPrice = 0;
        int answer = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            if(maxPrice < arr[i]){ // 최대값 갱신
                maxPrice = arr[i];
            }else{
                answer += (maxPrice - arr[i]);
            }
        }

        System.out.println(answer);
    }
}
