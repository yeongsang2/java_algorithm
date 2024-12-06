
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sortArr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = sortArr[i] = a;
        }
        Arrays.sort(sortArr);

        int cnt=0;
        for (int i = 0; i < sortArr.length; i++) {
            int i1 = sortArr[i];
            if(map.containsKey(i1)){ // 이미 가지고 있음
                ;
            }else{
                map.put(i1, cnt);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
        // 2 4 -10 4 -9
        // -10 -9 2 4 4
        // 중복 제거 어떻게함? 카운트?

        // 999 1000
        //1000 999 1000 999 1000 999
        //  999 999 999 1000 1000 1000
        //  1   0   1    0    1   0


    }
}
