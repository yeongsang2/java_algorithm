package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20444 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0;
        long right = n / 2;

        // 기준값을 가로로 자른 횟수
        // 세로로 자른 횟수 = n - 기준값
        while(left <= right){

            long row = (left + right) / 2; //가로로 자른횟수를 기준값
            long col = n - row;
            long cnt = calculate(row,col);
            if (cnt == k) {
                System.out.println("YES");
                return;
            }else if(cnt > k){ //조각의 갯수가 k 보다 많음
                right = row-1;
            }else{ // 적음
                left =  row+1;
            }
        }
        System.out.println("NO");


    }

    private static long calculate(long row, long col) {
        return (row +1) * (col +1);
    }

}
