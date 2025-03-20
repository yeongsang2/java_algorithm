
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
        int min = 0;

        for (int i = 0; i < m - 1; i++) {
            int now = loc[i];
            int next = loc[i + 1];
            int diff = 0;
            if( (next - now) % 2 == 0 ){
                diff = (next - now) / 2;
            }else{
                diff = (next - now) / 2  + 1;
            }
            min = Math.max(min, diff);
        }

        min = Math.max(min, (loc[0] - 0));
        min = Math.max(min, (n - loc[m - 1]));
        System.out.println(min);
    }
    static boolean isPossible(int[] loc, int n , int range){

        boolean[] checked = new boolean[n + 1];

        for(int i : loc) {

            for (int j = i - range; j < i + range + 1; j++) {
                if (j >= 0 && j < n + 1 && !checked[j])
                    checked[j] = true;
            }
        }

        boolean flag = true;
        for (int i = 0; i < n + 1; i++) {
            if(!checked[i]){
                flag = false;
                break;
            }
        }
        if(!flag) return false;
        return true;
    }
}
