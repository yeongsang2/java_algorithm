
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 남 1, 여 2

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            if(sex == 1){ // 남학생
                int temp = 2;
                int start = switchNum;
                while (start <= n){
                    arr[start] = (arr[start] + 1) % 2;
                    start = switchNum * temp;
                    temp++;
                }
            }

            if(sex == 2){ //여학생
                arr[switchNum] = (arr[switchNum] + 1) % 2;
                int left = switchNum - 1;
                int right = switchNum + 1;
                while(left > 0 && right < n +1 && arr[left] == arr[right]){
                    arr[left] = (arr[left] + 1) % 2;
                    arr[right] = (arr[right] + 1) % 2;
                    left--;
                    right++;
                }
            }
        }

        int count = 1;
        for (int i = 1; i < n + 1; i++) {
            System.out.print(arr[i] + " ");
            count++;
            if(count == 21){
                System.out.println();
                count = 1;
            }
        }

    }
}
