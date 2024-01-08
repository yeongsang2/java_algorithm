package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.PriorityQueue;

public class boj_6443 {

    static int[] visited;
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            visited = new int[26];
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                visited[str.charAt(j) - 'a']++;
            }

            tracking("");

        }
        System.out.println(sb.toString());
    }

    public static void tracking(String path){

        if(path.length() == str.length() ){
            sb.append(path).append("\n");
        }

        for (int i = 0; i < 26; i++) {
            if(visited[i] > 0){
                visited[i]--;
                char c = (char) (i + 'a');
                tracking(path + c);
                visited[i]++;
            }
        }

    }
}
