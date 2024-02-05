package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1106 {

//    static class Hotel{
//        int cost;
//        int expectedCustomer;
//
//        public Hotel(int cost, int expectedCustomer){
//            this.cost = cost;
//        }

//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken()); //  최소 고객 수
        int n = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp =new int[1001];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 비용
            int b = Integer.parseInt(st.nextToken()); // 고객의수
            if(map.containsKey(b)){
                map.put(b, Math.min(map.get(b), a));
            }else{
                map.put(b,a);

            }
        }

        for (int i = 1; i < 1001; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < 1001; i++) {
            for(Integer customer : map.keySet()){
                if( (i - customer) < 0)continue;
                int cost = map.get(customer);
                dp[i] = Math.min( (dp[i-customer] + cost), dp[i]);
            }
            if(dp[i] < dp[i-1]){
                for (int j = i; j > 0; j--) {
                    if(dp[j] > dp[j-1])continue;
                    dp[j-1] = dp[j];
                }
            }
        }
        System.out.println(dp[c]);
    }
}
