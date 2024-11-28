
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        // 전체갯수 + 조합개
        for (int i = 0; i < t; i++) {
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            cnt += n;
            Map<String, Integer> map = new HashMap<>();

            for (int j = 0; j <n; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                map.put(b, map.getOrDefault(b,0) +1);
            }

            int result =1;
            for(Integer m : map.values()){
                result *= (m+1);
            }
            result -=1;

            System.out.println(result);

        }
    }
}
