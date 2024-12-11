
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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        if(n <=2){
            System.out.println(n);
        }else {
            int left = 0;
            int right = 0;
            int answer = -1;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(arr[left], 1);
            while(right < n){

                right++;
                if(right ==n){
                    answer = Math.max(answer, right - left);
                    break;
                }
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                if(map.size() > 2){ //꽉참
                    answer = Math.max(answer, right - left);
                    map.put(arr[left], map.get(arr[left]) -1);
                    if(map.get(arr[left]) == 0){
                        map.remove(arr[left]);
                    }
                    left++;
                }
            }
            System.out.println(answer);
        }

    }
}
