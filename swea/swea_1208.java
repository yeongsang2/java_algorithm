package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208 {
    static int[] table;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i < 11; i++) {
            StringTokenizer st;
            table = new int[100];

            int dump = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                table[j] = Integer.parseInt(st.nextToken());
            }

            while(dump-- > 0){
                Arrays.sort(table);
                table[0]++;
                table[99]--;
            }
            Arrays.sort(table);
            System.out.println("#"+Integer.toString(i) + " " + Integer.toString(table[99] - table[0]));
        }
    }
}
