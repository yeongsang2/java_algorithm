
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(!list.contains(s)){
                list.add(s);
            }
        }

        int maxCount = 0;
        String s = "";
        String t = "";
        for (int i = 0; i < n - 1; i++) {
            String now = list.get(i);
            for (int j = i + 1; j < n; j++) {
                String next = list.get(j);

                int cnt = 0;
                int length = Math.min(now.length(), next.length());
                for (int k = 0; k < length; k++) {
                    if(now.charAt(k) == next.charAt(k)) cnt++;
                    else break;
                }
                if(maxCount < cnt){
                    maxCount = cnt;
                    s = now;
                    t = next;
                }
            }
        }

        System.out.println(s);
        System.out.println(t);


    }
}
