import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k  = Integer.parseInt(st.nextToken());
        int n  = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long left =  1;
        long right = arr[k-1];
        long mid = (left + right) / 2;

        while(left <= right){
            long count = 0;
            for(int num : arr){
                long temp = num / mid;
                count+= temp;
            }

            if(count < n){
                right = mid -1;
            }else{
                left = mid + 1;
            }
            mid = (right + left) /2;
        }

        System.out.println(mid);

    }
}
