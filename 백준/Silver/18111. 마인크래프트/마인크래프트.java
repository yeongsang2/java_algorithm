
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                min = Math.min(min, h);
                max = Math.max(max, h);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = min; i < max+1; i++) {

            int time = 0;
            int nowB = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int h = map[j][k];
                    if( h < i ){ // 현재높이가 맞추려는 높이보다 작음
                        int dif = i - h;
                        time = time + dif;
                        nowB -= dif;
                    }else if ( h > i){ // 현재높이가 맞추려는 높이보다 높음
                        int dif = h - i;
                        time = time + 2*dif;
                        nowB += dif;
                    }
                }
            }
            if(nowB >= 0){
                if(time <= resultTime){
                    resultTime = time;
                    answer = Math.max(answer, i);
                }
            }
        }

        System.out.println(resultTime + " " + answer);


    }
}
