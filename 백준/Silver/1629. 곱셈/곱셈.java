
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //
        long answer = 1;
        answer = search(a, b, c);
        System.out.println(answer);
    }
    static long search(int a, int b, int c){
        if(b == 1){
            return (a % c) ;
        }
        long temp = search(a, b/2, c);

        if(b % 2 == 1){
            return (temp * temp % c) * a % c;
        }
        return (temp * temp % c);

    }
}
