package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18511 {

    static int[] set;
    static int k;
    static int n;
    static Long result = 0L;
    static int maxLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        set = new int[k];
        maxLength = Integer.toString(n).length();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < set.length; i++) {
            set[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < set.length; i++) {
            dfs(Integer.toString(set[i]));
        }
        // 완 전 탐 색 조 져

        System.out.println(result);
    }
    public static void dfs(String path){


        int now = Integer.valueOf(path);
        if(now > n){
            return;
        }

        for (int i = 0; i < set.length; i++) {
            dfs(path + Long.toString(set[i]));
            result = Math.max(result, Long.valueOf(path));
        }
    }
}
