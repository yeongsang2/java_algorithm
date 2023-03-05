package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5585 {

    public static void main(String[] args) throws IOException {

        int change;
        int price;
        int cnt = 0;
        int[] coins = {500, 100, 50, 10 ,5, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        price = Integer.parseInt(br.readLine());
        change = 1000 - price;

        for (int coin : coins) {
            int m = change / coin;
            cnt = cnt + m;
            change = change - coin * m;
        }

        System.out.println(cnt);


    }
}
