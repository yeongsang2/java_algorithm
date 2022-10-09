package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class guitarlist_1495 {
    public static void main(String[] args) throws IOException {

        int n,s,m;
        int[] v;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()); //시작볼륨
        m = Integer.parseInt(st.nextToken()); //m보다 큰 값으로 볼륨 바꿀 수 없음
        v = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n;i++){
            v[i] = Integer.parseInt(st.nextToken());
        }


    }
}
