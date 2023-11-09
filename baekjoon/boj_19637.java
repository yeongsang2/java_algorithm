package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] name = new String[n];
        int[] power = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb= new StringBuilder();
        while (m-- > 0){
            int target= Integer.parseInt(br.readLine());
            int left = 0;
            int right = n-1;
            if( target <= power[left]){
                sb.append(name[left]);
            }else if (target > power[right]){
                sb.append(name[right]);
            }else {
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (power[mid] < target){
                        left = mid +1;
                    }else {
                        right = mid -1;
                    }
                }
                sb.append(name[left]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
