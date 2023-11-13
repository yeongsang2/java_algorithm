package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] treeList = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeList[i] = Integer.parseInt(st.nextToken());
        }
        // 적어도 M 미터

        Arrays.sort(treeList);
        long left = 0;
        long right = treeList[n-1];
        long mid = 0;
        long answer=0;

        while(left < right){

            mid = (left + right ) / 2;

            long total =0;
            // 나무확인 적어도 m을가져가야함
            for (int i = 0; i < n; i++) {
                if(treeList[i] > mid){
                    total = total + (treeList[i] - mid);
                }
            }

            if( total >= m){ // total이 m보다 많음 -> 절단지를 높일 수 있음
                left = mid+1;
//                answer = mid;
            } else { // 절단기 낮춤
                right = mid;
            }
        }
        System.out.println(left-1);
    }
}
// 4 26 40 42 46
//         15