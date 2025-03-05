
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] sum = new long[n + 1];
        long[] arr = new long[n + 1];
        sum[1] = Long.parseLong(br.readLine());
        arr[1] = sum[1];
        for (int i = 2; i < n + 1; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
            sum[i] = sum[i-1] + num;
        }

        // 1 이면 수 변경
        // 2 이면 합
        StringBuilder sb = new StringBuilder();
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                map.put(b, c - arr[b]);
            }else{
                long temp = sum[(int) c] - sum[b - 1];
                for(Integer num : map.keySet()){
                    if(num >= b && num <= c){
                        temp += map.get(num);
                    }
                }
                sb.append(temp);
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
