
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Point{
        long x;
        long y;
        public Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x,y);
        }

        long sum1 = 0; // x_i * y_{i+1}
        long sum2 = 0; // y_i * x_{i+1}
        for (int i = 0; i < n; i++) {
            Point current = arr[i];
            Point next = arr[(i + 1) % n]; // 다음 점, 마지막 점은 첫 점으로 연결
            sum1 += current.x * next.y;
            sum2 += current.y * next.x;
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);

    }
}
