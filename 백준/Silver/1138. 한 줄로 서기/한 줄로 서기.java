
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n + 1];
        Arrays.fill(answer, -1);

        for (int i = 1; i < n + 1; i++) {
            int num = arr[i];
            int temp = 0;
            for (int j = 1; j < n + 1; j++) {
                if(answer[j] == - 1){
                    temp++;
                }
                if(temp > num && answer[j] == -1){
                    answer[j] = i;
                    break;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.print(answer[i] +  " ");
        }

    }
}
