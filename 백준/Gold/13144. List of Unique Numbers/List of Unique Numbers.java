
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] checked = new boolean[100001];

        long answer = 0;
        for(int left = 0, right = -1 ; left < n; left++){
            while(right + 1 < n && !checked[arr[right + 1]]){
                right++;
                checked[arr[right]] = true;
            }
            answer += (right - left) +  1;
            checked[arr[left]] = false;
        }
        System.out.println(answer);
    }
}
