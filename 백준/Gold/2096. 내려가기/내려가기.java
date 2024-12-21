
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        int[][] arr = new int[n][3];
        for (int i = 0; i < n ; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        max[0][0] = arr[0][0];
        max[0][1] = arr[0][1];
        max[0][2] = arr[0][2];

        min[0][0] = arr[0][0];
        min[0][1] = arr[0][1];
        min[0][2] = arr[0][2];

        for (int i = 0; i < n-1; i++) {
            max[i+1][0] = Math.max(max[i][0] + arr[i+1][0], max[i][1] + arr[i+1][0]);

            max[i+1][1] = Math.max(max[i][0] + arr[i+1][1], max[i][1] + arr[i+1][1]);
            max[i+1][1] = Math.max(max[i+1][1], max[i][2] + arr[i+1][1]);

            max[i+1][2] = Math.max(max[i][1] + arr[i+1][2], max[i][2] + arr[i+1][2]);

            min[i+1][0] = Math.min(min[i][0] + arr[i+1][0], min[i][1] + arr[i+1][0]);

            min[i+1][1] = Math.min(min[i][0] + arr[i+1][1], min[i][1] + arr[i+1][1]);
            min[i+1][1] = Math.min(min[i+1][1], min[i][2] + arr[i+1][1]);

            min[i+1][2] = Math.min(min[i][1] + arr[i+1][2], min[i][2] + arr[i+1][2]);

        }

        int maxAnswer = 0;
        int minAnswer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            maxAnswer = Math.max(maxAnswer, max[n-1][i]);
            minAnswer = Math.min(minAnswer, min[n-1][i]);
        }
        System.out.print(maxAnswer + " ");
        if(minAnswer == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(minAnswer);
        }

    }
}
