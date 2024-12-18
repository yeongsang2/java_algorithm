
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<String> list = new LinkedList<>();
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            search(Integer.toString(arr[i]), i, 1);
            visited[i] = false;
        }


        for(String s : list){
            System.out.println(s);
        }
    }
    static void search(String s, int now, int depth){
        if(depth == m){
            list.add(s);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                search(s + " " + Integer.toString(arr[i]), i, depth+1);
                visited[i] = false;
            }

        }


    }
}
