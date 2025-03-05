
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] checked = new int[100001];

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = 1;
        checked[arr[left]]++;
        while (left < n && right < n){

            if(checked[arr[right]] < k){
                checked[arr[right]]++;
                right++;
            }else{
                checked[arr[left]]--;
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        System.out.println(answer);
    }
}

//11 2
//6 4 5 6 6 7 8 9 10 10 10
// 10 2
// 1 1 1 1 1 1 1 1 1 1
//16 3
//1 2 3 4 5 6 7 8 9 1 1 11 1 2 2 2