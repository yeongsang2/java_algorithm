package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set set = new HashSet();
        int n,m;
        int answer = 0;

        st =  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n ; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            if(set.contains(br.readLine())){
                answer++;
            }
        }
        System.out.println(answer);

    }
}
