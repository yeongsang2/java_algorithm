package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SumOfNumber_1789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s;
        long n = 1; //1부터시작
        long sum=0;

        s = Long.parseLong(br.readLine());

        while(true){
            sum += n;
            if(sum >s){
                break;
            }
            n++;
        }
        System.out.println(n-1);
    }
}
