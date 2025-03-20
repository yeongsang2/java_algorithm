
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] loc = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n;

        while (left < right){
            int mid = (left + right) / 2;
            if(isPossible(loc, n, mid)){
                right = mid;
            }else{ // 높이 높이기
                left = mid + 1;
            }
        }
        System.out.println(left);

    }
    static boolean isPossible(int[] loc, int n , int range){

        int prev = 0;

        for (int i = 0; i < loc.length; i++) {
            if(loc[i] - range <= prev){
                prev = loc[i] + range;
            }else return false;
        }

        return n - prev <= 0 ;
    }
}
