package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_21912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int answer = 0;
        List<Integer> list = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = 0;
        int second = x - 1;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        answer = sum;
        list = new LinkedList<>();
        list.add(1);
        while(second < n-1){

            sum -= arr[first];
            first++;
            second++;
            sum += arr[second];
            if( sum > answer ){
                list = new LinkedList<>();
                list.add(1);
                answer = sum;
            }else if(sum == answer){
                list.add(1);
            }

        }

//        for (int i = 0; i < n -x +1 ; i++) {
//
//            int cnt = 0;
//            for (int j = i; j < i + x ; j++) {
//                cnt += arr[j];
//            }
//
//            if(answer < cnt){
//                list = new LinkedList<>();
//                list.add(1);
//                answer = cnt;
//            }else if(answer == cnt){
//                list.add(1);
//            }
//        }

        if(answer == 0){
            System.out.println("SAD");
        }else{
            System.out.println(answer);
            System.out.println(list.size());
        }

    }
}
