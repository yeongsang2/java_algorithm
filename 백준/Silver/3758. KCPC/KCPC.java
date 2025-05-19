
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Team implements Comparable<Team>{

        int teamId;
        int[] score;
        int submitCnt;
        int lastTime;

        public Team(int teamId, int[] score, int submitCnt, int lastTime){
            this.teamId = teamId;
            this.score = score;
            this.submitCnt = submitCnt;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(Team o) {

            int thisTotalScore = Arrays.stream(this.score).sum();
            int oTotalScore = Arrays.stream(o.score).sum();
            if(thisTotalScore == oTotalScore){
                if(this.submitCnt == o.submitCnt){
                    return this.lastTime - o.lastTime;
                }
                return this.submitCnt - o.submitCnt;
            }

            return oTotalScore - thisTotalScore;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int teamId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map<Integer, Team> map = new HashMap();
            for (int i = 1; i < n + 1; i++) {
                map.put(i, new Team(i, new int[k + 1], 0,0));
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int tId = Integer.parseInt(st.nextToken());
                int pNumber = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                Team team = map.get(tId);
                team.score[pNumber] = Math.max(team.score[pNumber], score);
                team.submitCnt++;
                team.lastTime = i;
            }

            List<Team> list = new ArrayList<>();


            for(Integer i : map.keySet()){
                list.add(map.get(i));
            }
            Collections.sort(list);

            for (int i = 1; i < list.size() + 1; i++) {
                Team team = list.get(i-1);
                if(team.teamId == teamId){
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
