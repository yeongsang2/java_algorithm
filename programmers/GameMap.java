package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GameMap {
    public static void main(String[] args) {

    }
    public static int[][]visited;
    public static class Loc {
        public Loc(int w,  int h){
            this.w=w;
            this.h=h;
        }
        int w; // 행
        int h; // 열
    }

    public int solution(int[][] maps) {

        int answer = 0;
        // 상 하 좌 우
        // 하 우 좌 상
        int[] mw = {1,0,0,-1};
        int[] mh = {0,1,-1,0};
        int nw;
        int nh;
        Queue<Loc> queue  = new LinkedList();
        visited = new int[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                visited[i][j] = 0;
            }
        }
        queue.add(new Loc(0,0));
        while(!queue.isEmpty()){
            Loc poll = queue.poll();
//            visited[poll.w][poll.h] =1;
            for (int i = 0; i < 4; i++) {
                nw = poll.w + mw[i];
                nh = poll.h + mh[i];
                if( nw >= 0 && nw < maps.length && nh >= 0 && nh < maps[0].length && maps[nw][nh] == 1){
                    if(maps[nw][nh] == 1){
                        maps[nw][nh] = maps[poll.w][poll.h] +1;
                    }else {
                        maps[nw][nh] = Integer.min(maps[nw][nh], maps[poll.w][poll.h] +1);
                    }
                    queue.add(new Loc(nw, nh));
                }
            }
        }
        if(maps[maps.length -1 ][maps[0].length -1] == 1){
            answer = -1;
        }else {
            answer = maps[maps.length- 1][maps[0].length-1];
        }
        return answer;
    }
}
