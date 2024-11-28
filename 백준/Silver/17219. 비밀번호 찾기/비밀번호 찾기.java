
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> map = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pass = st.nextToken();
            map.put(site,pass);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            sb.append(map.get(s) + '\n');
        }
        System.out.println(sb);

    }
}
