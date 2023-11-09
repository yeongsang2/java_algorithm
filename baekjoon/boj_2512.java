package baekjoon;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2512 {

    static int[] provinces;
    static int limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        provinces = new int[n];
        int sum =0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            provinces[i] = now;
            sum += now;
        }
        limit = Integer.parseInt(br.readLine());

        Arrays.sort(provinces);
        if(limit >= sum){
            System.out.println(provinces[n-1]);
            return;
        }

        int low = 1;
        int high = provinces[n-1];
        Long max = -1L;

        while(low <= high){
            int mid = (low + high) /2;
            if(isPossible(mid)){
                max = Math.max(max, mid);
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        System.out.println(max);
    }
    static boolean isPossible(int value){
        int sum = 0;
        for (int i = 0; i < provinces.length; i++) {
            if(provinces[i] >= value){
                sum += value;
            }else {
                sum += provinces[i];
            }
            if(sum > limit)return false;
        }
        return true;
    }
}
