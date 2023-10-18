package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] commandList = new int[m][3];
        int[] map = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int commandNum = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            if((commandNum == 1) || (commandNum == 2)){
                int seatNum = Integer.parseInt(st.nextToken());
                commandList[i] = new int[]{commandNum,trainNum, seatNum};
            }else {
                commandList[i]  = new int[]{commandNum, trainNum,0};
            }
        }

        for (int i = 0; i <m; i++) {
            int commandNum = commandList[i][0];
            //1
            if(commandNum == 1){
                int trainNum = commandList[i][1];
                int seatNUm = commandList[i][2];
                map[trainNum] = map[trainNum] | (1<<seatNUm);
            }

            //2
            if(commandNum == 2){
                int trainNum = commandList[i][1];
                int seatNUm = commandList[i][2];
                map[trainNum] = map[trainNum] & ~(1<<seatNUm);
            }

            //3
            if(commandNum == 3){
                int trainNum = commandList[i][1];
                map[trainNum] = map[trainNum] << 1;
                map[trainNum] = map[trainNum] & ((1<<21) -1);
            }

            //4
            if(commandNum == 4){
                int trainNum = commandList[i][1];
                map[trainNum] = map[trainNum] >> 1;
                map[trainNum] = map[trainNum] & ~1;
            }
        }

        int answer =0;
        boolean visited[] = new boolean[1<<21];
        for (int i = 1; i < n+1; i++) {
            if(visited[map[i]]) continue;
            else {
                visited[map[i]] = true;
                answer++;
            }
        }
        System.out.println(answer);

    }
}
