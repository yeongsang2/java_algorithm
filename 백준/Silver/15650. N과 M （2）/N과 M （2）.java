
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<String> list = new LinkedList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n+1; i++) {
            search(Integer.toString(i), i, 1);
        }
        for(String s : list){
            System.out.println(s);
        }

    }
    static void search(String ans, int now, int depth){
        if(depth == m){
            list.add(ans);
            return;
        }
        for (int i = now+1; i < n+1; i++) {
            search(ans + " " + Integer.toString(i), i, depth+1);
        }
    }
}
