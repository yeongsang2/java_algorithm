
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

        long velocity = arr[n-1];
        for (int i = n - 2; i >= 0 ; i--) {
            int now = arr[i];
            if(now > velocity){ // velocity가 지금 행송의 속도보다 작으면
                velocity = now;
            }else if ( now < velocity && velocity % now != 0){  // velocity 지금 행성의 속도보다 크면
                velocity = ( velocity / now + 1) * now;
            }
        }
        System.out.println(velocity);

    }
}
