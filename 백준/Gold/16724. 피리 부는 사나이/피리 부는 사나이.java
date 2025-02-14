import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int answer = 0;
    static boolean[] visited;
    static boolean[] checked;
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int cnt = 1;
        arr = new int[ n * m + 1 ];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if(c == 'U'){
                    arr[cnt] = cnt - m;
                }else if(c == 'D'){
                    arr[cnt] = cnt + m;
                }else if(c == 'L'){
                    arr[cnt] = cnt - 1;
                }else{
                    arr[cnt] = cnt + 1;
                }
                cnt++;
            }
        }

//        System.out.println("------------");
//        for (int i = 1; i < n * m + 1; i++) {
//            System.out.print(arr[i] + " ");
//            if(i % m == 0) System.out.println();
//        }
//        System.out.println("------------");

        visited = new boolean[ n * m + 1 ];
        checked = new boolean[ n * m + 1 ];
        for (int i = 1; i < arr.length; i++) {
            search(i);
        }
        System.out.println(answer);
    }
    static void search(int node){

        visited[node] = true;
        int next = arr[node];
        if(!visited[next]){
            search(next);
        }else{
            if(!checked[next]){
                answer++;
            }

        }
        checked[node] = true;

    }
}
