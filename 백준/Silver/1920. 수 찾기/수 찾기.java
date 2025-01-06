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

        int m = Integer.parseInt(br.readLine());
        int[] num = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int find = num[i];
            int left = 0;
            int right = n-1;
            int mid = (left + right) / 2;
            boolean isFound = false;
            // 1 2 3 4 5
            // 1 3 -> find
            while(left <= right){
//                System.out.print( mid  + " ");
                if(arr[mid]  == find){
                    isFound = true;
                    break;
                }
                if(arr[mid] > find){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }

                mid = (left+ right) /2;
            }

//            System.out.println();
            if(isFound){
                sb.append(1);
            }else{
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);



    }
}
