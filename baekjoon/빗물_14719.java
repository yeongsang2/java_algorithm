package baekjoon;

import java.io.*;
import java.util.*;


public class 빗물_14719 {

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < w; i++) {
            int N = Integer.parseInt(st.nextToken());
            arr[i] = N;
        }

        int sum = 0;
        for(int i =1; i < w-1; i++){ //첫번째 벽은 물을 채울 수 없음 마지막 한칸 전까지 탐색

            int now = arr[i];
            int left = now;
            int right = now;
            // 왼쪽 최대벽 탐색
            for(int j=0; j < i; j++) {
                if(arr[j]> now) {
                    left = Math.max(arr[j], left);
                }
            }

            // 오른쪽 최대벽 탐색
            for(int j= i +1; j < w; j++){
                if(arr[j]> now) {
                    right = Math.max(arr[j], right);
                }
            }

            // now가 둘보다 작으면
            if(now < Math.min(right, left)){
                sum += (Math.min(right, left) - now);
            }

        }
        System.out.println(sum);

    }
}
