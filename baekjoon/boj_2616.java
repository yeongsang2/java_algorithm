package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2616 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n; //객차수
        int[] array;
        int maxTrain; //최대로 끌고 갈 수 있는 객차의 수
        n = Integer.parseInt(br.readLine()); // 객차의수
        array = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1 ; i <n+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        maxTrain= Integer.parseInt(br.readLine());
    }
}
