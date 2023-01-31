package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        Integer[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for(int i=1 ;i < x ; i++){
            total += month[i];
        }
        System.out.println(day[(total + y -1 )%7]);
    }
}
