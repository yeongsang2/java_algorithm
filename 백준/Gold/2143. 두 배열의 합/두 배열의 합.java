
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        long[] subA = new long[(n*(n+1)) / 2];
        long[] subB = new long[(m*(m+1)) / 2];

        int idx = 0;
        for(int i = 0 ; i < n ;i++){
            int temp = 0;
            for(int j = i ; j < n ; j++){
                temp += arrA[j];
                subA[idx++] = temp;
            }
        }

        idx = 0;
        for(int i = 0 ; i < m ;i++){
            int temp = 0;
            for(int j = i ; j < m ; j++){
                temp += arrB[j];
                subB[idx++] = temp;
            }
        }

        Arrays.sort(subA);
        Arrays.sort(subB);

        int left = 0;
        int right = subB.length -1;
        long answer = 0;

        while(left < subA.length && right >= 0){

            long sum = subA[left] + subB[right];

            if(sum ==T){ // 같음
                long a = subA[left];
                long b = subB[right];

                long tempA = 0;
                long tempB = 0;

                while(left < subA.length && subA[left] == a){
                    tempA++;
                    left++;
                }
                while(right >= 0 && subB[right] == b){
                    tempB++;
                    right--;
                }
                answer += tempA * tempB;
            }else if(sum < T) {
                left++;
            }else{
                right--;
            }
        }
        System.out.println(answer);


    }
}
