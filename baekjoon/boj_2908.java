package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String newA = "";
        String newB = "";
        String tmp;

        for(int i=2; i >=0;i--){
            newA += a.charAt(i);
            newB += b.charAt(i);
        }
        System.out.println(Math.max(Integer.parseInt(newA), Integer.parseInt(newB)));

    }
}
