package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 1; i < 11; i++) {

            int n = Integer.parseInt(br.readLine());
            int[] table=  new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[j] = Integer.parseInt(st.nextToken());
            }

            int answer =0;
            for (int j = 2; j < n-2; j++) {
                if( table[j-2] < table[j] && table[j-1] < table[j] && table[j+1] < table[j] && table[j+2] < table[j]){
                    int max = -1;
                    for (int k = j-2; k < j+3; k++) {
                        if(j == k )continue;
                        max = Math.max( max, table[k]);
                    }
                    answer = answer + (table[j] -max);
                }
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}
