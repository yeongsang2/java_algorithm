package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //전체 용액의 수
        long[] arr = new long[n];
        long min = Integer.MAX_VALUE;

        StringTokenizer st= new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = n-1;

        long leftAnswer = arr[left];
        long rightAnswer = arr[right];

        // x값의 절대값이 제일 작은거

        while(left < right){

            long a = arr[left];
            long b = arr[right];

            long plus = Math.abs(a+b);
            if( min > plus){
                min = plus;
                leftAnswer = a;
                rightAnswer = b;

            }
            min = Math.min(min, Math.abs(a+b));

            //-99 (-98) -2 -1 4  98 100 0 보다 작으면
            if ((a+b) < 0){
                left +=1;
            }else if ( (a+b) > 0){
                right -=1;
            }else if ( ( a+b ) == 0 ){
                leftAnswer = a;
                rightAnswer = b;
                break;
            }
        }
        System.out.println(Long.toString(leftAnswer) + " " + Long.toString(rightAnswer));
    }
}
