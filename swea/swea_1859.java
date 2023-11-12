package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1859 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack;

        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k < t+1; k++) {

            int n = Integer.parseInt(br.readLine());
            int[] table = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                table[i] = Integer.parseInt(st.nextToken());
            }

            stack = new Stack<>();
            int max = table[n-1];
            long answer =0;
            for (int i = n-2; i >= 0; i--) {
                int now = table[i];
                if( now < max){
                    answer  = answer + (max - now);
                }else if ( now > max ){
                    max = now;
                }
            }

            System.out.println("#" + Integer.toString(k) + " " + answer);
        }
    }
}
