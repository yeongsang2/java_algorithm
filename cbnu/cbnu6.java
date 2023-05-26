
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class cbnu6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long sum;
        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        sum =x;
        long y= Integer.parseInt(st.nextToken());
        if(x == 0){
            System.out.println(1);
            exit(1);
        }
        if(y==0){
            System.out.println(1);
            exit(1);
        }
        for (int i = 0; i < y-1; i++) {
            x = (sum * x ) % 20091024;
        }

        System.out.println(x % 20091024);

    }
}
