
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] leftDp = new int[n + 1];
        int[] rightDp = new int[n + 1];
        int[] nearIdx = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            int now = arr[i];
            for (int j = i - 1; j >= 1 ; j--) {
                if(arr[j] > now){
                    nearIdx[i] = j;
                    leftDp[i] = leftDp[j] + 1;
                    break;
                }
            }
        }
//
//        for (int i = 1; i < n + 1; i++) {
//            System.out.print(leftDp[i] +  " ");
//        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n + 1 ; j++) {
                if(arr[j] > arr[i]){
                    if( nearIdx[i] == 0 || Math.abs(nearIdx[i] - i) > Math.abs(j - i) ) nearIdx[i] = j;
                    rightDp[i] = rightDp[j] + 1;
                    break;
                }
            }
        }
//
//        System.out.println();
//        for (int i = 1; i < n + 1; i++) {
//            System.out.print(rightDp[i] +  " ");
//        }

        int[] sum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = leftDp[i] + rightDp[i];
        }
        for (int i = 1; i < n + 1; i++) {
            if(sum[i] > 0) System.out.println(sum[i] + " " + nearIdx[i]);
            else System.out.println(sum[i]);
        }

    }
}
