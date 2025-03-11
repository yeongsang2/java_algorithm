
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] segments = {
                0b1110111, // 0
                0b0010010, // 1
                0b1011101, // 2
                0b1011011, // 3
                0b0111010, // 4
                0b1101011, // 5
                0b1101111, // 6
                0b1010010, // 7
                0b1111111, // 8
                0b1111011  // 9
        };

        int[][] changeBits = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                changeBits[i][j] = Integer.bitCount(segments[i] ^ segments[j]);
            }
        }

        // x -> 현재층
        int[] now  = new int[k];
        int targetX = x;
        for (int i = k - 1 ; i >= 0; i--) {
            now[i] = targetX % 10 ;
            targetX = targetX / 10;
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {

            int targetNum = i;
            if(targetNum == x) continue;
            int[] target = new int[k];
            for (int j = k - 1 ; j >= 0; j--) {
                target[j] = targetNum % 10 ;
                targetNum = targetNum / 10;
            }

            int temp = 0;
            for (int j = 0; j < k; j++) {
                temp += changeBits[now[j]][target[j]];
            }
//            System.out.println(i + ", temp: " + temp);

            if(temp <= p) {
                answer++;
            }

        }

        System.out.println(answer);
    }
}
