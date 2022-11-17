package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int array[];
        int dp[];
        int a = Integer.parseInt(br.readLine());
        array = new int[a+1];
        dp = new int[a+1];
        st= new StringTokenizer(br.readLine());
        for(int i =1 ; i< a+1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i< a+1 ; i++){
            dp[i] = array[i];
            for(int j =1 ; j< i ; j++){
                if( array[i] > array[j]){ // 기준값 i 보다 작다
                    dp[i] = Math.max(dp[i], dp[j] + array[i]); // 현재 값와 이전값의최대값비교,,,!
//                    dp[i] +=array[j];
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
