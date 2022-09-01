import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s;
        int n = 1; //1부터시작
        int sum=0;
        s = Integer.parseInt(br.readLine());

        while(true){
            sum += n;
            if(sum >s){
                n--;
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}
