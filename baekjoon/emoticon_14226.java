package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class emoticon_14226 {


    public static int s;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int[] display = new int[1001];
        int[] clipboard = new int[1001];
        //최솟값?
        int[] visited = new int[1001];
        int time = 1;

        display[1] = 1;

        //큐 화면의 이모티콘 갯수??,,,,
        Queue<Integer> queue = new LinkedList();
        queue.add(1); //초기에 1개
        while(!queue.isEmpty()) {
            for (int i = 0; i < 3; i++) {

                //복사하여 클립보드에 저장
                if(i == 0){
                    time++;
                    display[time] =

                }else if(i == 1){ //클립보드에 있는 이모티콘 화면에 붙여넣기

                }else {//삭제

                }
            }
        }

    }
}
