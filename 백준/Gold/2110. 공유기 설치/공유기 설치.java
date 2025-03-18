
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 최대 거리에 대해서 이분 탐색 진행
        int left = 1;
        int right = arr[N - 1] - arr[0] + 1;
//        System.out.println(left + ", " + right);
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            // 놓을 수 있는지 여부
            if(C <= isPossible(arr, mid)){ // 삽가능, 거리를 늘려라
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left - 1);
    }
    static int isPossible(int[] arr, int distance){

        int last = 0;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            if(now - arr[last] >= distance){
                cnt++;
                last = i;
            }
        }
        return cnt;
    }
}
