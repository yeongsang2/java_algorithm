package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9081 {

    static String str;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < n; i++) {

            str = br.readLine();
            arr = new char[str.length()];

            for (int j = 0; j < str.length(); j++) {
                arr[j] = str.charAt(j);
            }
            if(tracking()){
                for (int t = 0; t < str.length(); t++) {
                    sb.append(arr[t]);
                }
                sb.append("\n");
            }else{
                sb.append(str);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }
    static boolean tracking(){
        // 교환할 위치 찾기
        int i = str.length()-1;
        while(i > 0 && arr[i] <= arr[i-1]){
            i--;
        }
        if(i == 0)return false;

        // 교환할 거 찾기
        int j = str.length()-1;
        while(j > 0 && arr[i-1] >= arr[j]){
            j--;
        }
        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        // 정렬
        int k = arr.length -1;
        Arrays.sort(arr, i, arr.length);
        return true;

    }

}

