
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushiArr = new int[n];
        for (int i = 0; i < n; i++) {
            sushiArr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        boolean flag = false;
        for (int i = 0; i < n + k - 1; i++) {
            int num = sushiArr[i % n];
            if(count < k){
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
                if(count == k){
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }else{
                int temp = sushiArr[i - k];
                map.put(temp, map.get(temp) - 1);
                if(map.get(temp) == 0) map.remove(temp);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int temp = map.size();
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}
