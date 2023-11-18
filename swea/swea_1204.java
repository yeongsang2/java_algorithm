package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] table;

        for (int i = 1; i < t + 1; i++) {
            int number = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            table = new int[101];

            for (int j = 0; j < 1000; j++) {
                int idx = Integer.parseInt(st.nextToken());
                table[idx]++;
            }

            int score = getMax(table);
            sb.append("#").append(i).append(" ").append(score).append("\n");
        }
        System.out.println(sb.toString());

    }

    static int getMax(int[] table){

        int max = -1;
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if(max <= table[i]){
                max = table[i];
                ans = i;
            }
        }
        return ans;
    }
}
