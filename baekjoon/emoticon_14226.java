package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class emoticon_14226 {


    public static int s;
    public static int answer;
    public static class Emoticon { //queue 에 넣을 내용
        // 화면, 클립보드, 시간
        public int display;
        public int cliboard;
        public int time;

        public Emoticon(int display, int cliboard, int time) {
            this.display = display;
            this.cliboard = cliboard;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
                                                        // 열 = 화면에 있는 이모티콘수  ==> 중복 여부 체크하기 위해 어케 체크할건딩
        bfs();
    }
    public static void bfs() {
        boolean visited[][] = new boolean[2001][2001]; //행 = 클립보드에 있는 이모티콘수
        // 열 = 화면에 있는 이모티콘수  ==> 중복 여부 체크하기 위해 어케 체크할건딩
        Queue<Emoticon> queue = new LinkedList();

        Emoticon emoticon = new Emoticon(1, 0, 0);
        queue.add(emoticon);
        while (!queue.isEmpty()) {

            Emoticon nowEmo = queue.poll();
            int nowClib = nowEmo.cliboard;
            int nowDis = nowEmo.display;
            int nowTime = nowEmo.time;

            if (nowDis == s) {
                System.out.println(nowTime);
                return;
            }


            for (int i = 0; i < 3; i++) {

                // 중복조건 체크 해주어야함
                // 화면에있는 이모티콘 복사해서 클립보드에 저장 복사
                if (i == 0) {
                    int newClib = nowDis;
                    if (newClib < 2000 && !visited[newClib][nowDis]) {
                        queue.add(new Emoticon(nowDis, newClib, nowTime + 1));
                        visited[newClib][nowDis]= true;
                    }

                }
                // 클립보드에 있는 모든 이모티콘 화면에 복붙
                else if (i == 1) {

                    int newDis = nowDis + nowClib;
                    if (newDis < 2001 && !visited[nowClib][newDis]) {
                        queue.add(new Emoticon(newDis, nowClib, nowTime + 1));
                        visited[nowClib][newDis] = true;

                    }

                } else {                // 화면에 있는 이모티콘 중 하나 삭제

                    int newDis = nowDis - 1;
                    if (newDis > 0 && !visited[nowClib][newDis]) {
                        queue.add(new Emoticon(newDis, nowClib, nowTime + 1));
                        visited[nowClib][newDis] = true;
                    }
                }

            }

        }
    }
}
