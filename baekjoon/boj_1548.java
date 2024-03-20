package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1548 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = 1;
        boolean flag = false;
        for (int i=0 ; i < n-1 ;i++){
            for(int j = n-1 ; j>i ; j--){
                int next = i+1;
                if(arr[i] + arr[next] > arr[j]){
                    answer = Math.max(answer, j- i+1);
                    break;
                }
            }
        }
        if(answer == 1 && n>= 2){
            System.out.println(2);
        }else{
            System.out.println(answer);
        }
        // 1 2 3 3 4 4 5
        // 모든 경우에 조건만족
        //작은 수 + 그 다음작은수  > 가장 큰수
    }
}
