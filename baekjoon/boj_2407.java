package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger top = BigInteger.ONE;
        BigInteger down = BigInteger.ONE;
        Integer test = 0;

        for (int i = 0; i < m; i++) {
            top = top.multiply(new BigInteger(String.valueOf(n-i)));
        }
        for (int i = 0; i < m ; i++){
            down = down.multiply(new BigInteger(String.valueOf(m-i)));
        }
        BigInteger ans = top.divide(down);
        System.out.println(ans);
    }
}
