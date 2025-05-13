
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;

            // 왼쪽
            double minSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = calSlope(i, j, arr[i], arr[j]);
                if (slope < minSlope) {
                    minSlope = slope;
                    temp++;
                }
            }

            // 오른쪽
            double maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < n; j++) {
                double slope = calSlope(i, j, arr[i], arr[j]);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    temp++;
                }
            }

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);

    }

    static double calSlope(int x1, int x2, int y1, int y2){
        return ((double)y2 - (double)y1) / ((double)x2 - (double)x1);
    }
}
