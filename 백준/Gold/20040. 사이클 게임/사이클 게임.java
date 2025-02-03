
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        boolean flag = false;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = findRoot(a);
            int end = findRoot(b);

            if(start == end){ //사이클 형성
                flag = true;
                System.out.println(i+1);
                break;
            }
            union(start, end);
        }
        if(!flag){
            System.out.println(0);
        }

    }

    private static int findRoot(int n) {

        if(arr[n] != n){
            arr[n] = findRoot(arr[n]);
            return arr[n];
        }

        return n;
    }
    private static void union(int start, int end){

        if(start < end){
            arr[end] = start;
        }else{
            arr[start] = end;
        }
    }
}
