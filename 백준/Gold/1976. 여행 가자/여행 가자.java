
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        int[][] answer = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                answer[i][j] = num;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i != j && answer[i][j] == 0){
                    answer[i][j] = 100001;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) { // 경유지
            for (int j = 1; j < n + 1; j++) { // 시작
                for (int k = 1; k < n + 1; k++) { // 도착
                    answer[j][k] = Math.min(answer[j][k], answer[j][i] + answer[i][k]);
                }
            }
        }

//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                System.out.print(answer[i][j] + " ");
//            }
//            System.out.println();
//        }

        st = new StringTokenizer(br.readLine());
        int[] trip = new int[m];
        for (int i = 0; i < m; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 0; i < m - 1; i++) {
            int now = trip[i];
            int next = trip[i+1];
            if(answer[now][next] >= 100001){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
