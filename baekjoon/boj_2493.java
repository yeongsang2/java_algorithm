package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493 {

    static class Info {
        int height;
        int index;
        Info(int height, int index){
            this.height = height;
            this.index =index;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] height;
        int[] answer;
        Stack<Info> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // 1 <= N <= 500,000
        height = new int[n];
        answer = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i < n ; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height < height[i]) {//이전 높이가 현재 높이보다 작으면 pop
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = 0;
            }else{
                answer[i] = stack.peek().index + 1;
            }
            stack.push(new Info(height[i], i));
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i]+ " ");
        }
    }
}
