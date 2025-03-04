
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            int now = arr[i];

        }
        int point = 0;
        while(point < n){

            int tempMax = arr[point];
            int nextPoint = 0;
            for (int i = point + 1; i < n; i++) {
                if(tempMax < arr[i]){
                    nextPoint = i;
                    tempMax = arr[i];
                }
            }


            if(nextPoint != 0){
                for (int i = point; i < nextPoint; i++) {
                    answer += arr[nextPoint] - arr[i];
                }
                point = nextPoint;
            }else{
                point++;
            }
        }
        System.out.println(answer);
    }
}
