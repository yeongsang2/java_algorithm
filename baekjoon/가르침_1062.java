package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 가르침_1062 {

    private static int n;
    private static int k;
     static boolean visited[] = new boolean[26];
     static String[] list;
     private static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();

        list = new String[n];
        for(int i =0 ; i<n; i++) {
            String t = br.readLine();
            t = t.substring(4, t.length() - 4);
            list[i] = t;
        }
        if(k < 5){
            System.out.println(0);
        }else if(k ==26){
            System.out.println(n);
        }else{
            visited['a' - 97] = true;
            visited['n' - 97] = true;
            visited['t' - 97] = true;
            visited['i' - 97] = true;
            visited['c' - 97] = true;
            comb(0,0);
            System.out.println(max);

        }

    }
    private static void comb(int idx, int start){

        if(idx == k-5){
            int count = 0;
            for(int i=0; i< n;i++){
                boolean isValid = true;
                for(int j=0; j < list[i].length();j++){
                    if(!visited[list[i].charAt(j) - 97]){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }


        for(int i= start; i< 26; i++){
            if(!visited[i]){
                visited[i] = true;
                comb(idx+1,i+1);
                visited[i] = false;

            }
        }

    }


}
