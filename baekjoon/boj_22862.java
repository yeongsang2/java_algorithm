package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_22862 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[s];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp % 2 == 0;
        }

        int left =0;
        int right = 0;
        int maxlen = 0;
        int temp = 0;

        while(right < s){
            if(temp < k){ // 제거가능
                if(!arr[right]){
                    temp++;
                }
                right++;
                maxlen = Math.max(right - left -temp ,maxlen);
            }else if (arr[right]) {
                right++;
                maxlen = Math.max(right - left -temp, maxlen);
            }else{
                if(!arr[left]){
                    temp--;
                }
                left++;
            }
        }
        System.out.println(maxlen);
    }
}
