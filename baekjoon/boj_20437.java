package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20437 {

    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {

            String str = br.readLine();
            k = Integer.parseInt(br.readLine());

            if(k==1){
                System.out.println("1 1");
                continue;
            }
            int[] alpha = new int[26];

            for (int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < str.length(); j++) {

                if(alpha[str.charAt(j) - 'a'] < k)continue;

                int count = 1;
                for (int l = j+1; l < str.length(); l++) {
                    if(str.charAt(l) == str.charAt(j))count++;
                    if(count == k){
                        //
                        min = Math.min(min, l-j +1);
                        max = Math.max(max, l-j +1);
                        break;
                    }
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
                System.out.println("-1");
            }else {
                System.out.println(min + " " + max);
            }
        }
    }
}
