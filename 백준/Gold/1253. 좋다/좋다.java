
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int targetNum = arr[i];
            int left = 0;
            int right = n - 1;
            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }
                if(arr[left] + arr[right] > targetNum){
                    right--;
                }else if(arr[left] + arr[right] < targetNum){
                    left++;
                }else if(arr[left] + arr[right] == targetNum){
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
