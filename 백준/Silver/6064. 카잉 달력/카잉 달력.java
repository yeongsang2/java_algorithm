import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int cnt = 1;
            boolean checked = false;
            for (int j = x; j < (n*m); j+=m) {
                if(j % n == y){
                    System.out.println(j+1);
                    checked = true;
                    break;
                }
            }
            if(!checked){
                System.out.println(-1);
            }
        }
        // 10 12  k
        // 3 9  / 33
        // 1 1  /  1
        // 2 2  /  2
        // 3 3  /  3  k를 m n 으로 나눈값이 x y
        // 3 1  / 13
    }
}
