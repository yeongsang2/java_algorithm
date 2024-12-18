
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            search(Integer.toString(arr[i]), i, 1);
        }

        for(String s : set){
            System.out.println(s);
        }
    }
    static void search(String s, int now,  int depth){
        if(depth == m){
            set.add(s);
            return;
        }

        for (int i = now; i < n; i++) {
            search(s + " " + arr[i],i, depth+1);
        }
    }
}
