
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String pn = "IOI";
        for (int i = 1; i < n; i++) {
            pn += "OI";
        }

        int left = 0;
        int right = 3 + 2*(n-1);
        int answer =0;
        while(right < m+1){
            String temp = s.substring(left, right);
            if(!temp.equals(pn)){
                ;
            }else{
                answer++;
            }
            left++;
            right++;
        }
        System.out.println(answer);

    }
}
