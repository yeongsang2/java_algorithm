
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Team implements Comparable<Team> {

        int teamNumber;
        int gold;
        int silver;
        int brown;
        public Team(int teamNumber, int gold, int silver, int brown){
            this.teamNumber = teamNumber;
            this.gold = gold;
            this.silver = silver;
            this.brown = brown;
        }

        @Override
        public int compareTo(Team o){
            if(this.gold == o.gold){
                if(this.silver == o.silver){
                    return o.brown - this.brown;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int teamCnt = Integer.parseInt(st.nextToken());
        int targetTeam = Integer.parseInt(st.nextToken());

        List<Team> list = new ArrayList<>();

        for (int i = 0; i < teamCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int teamN = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Team(teamN, g, s, b));
        }

        Collections.sort(list);

        int order = 0;
        Team prevTeam = null;
        int commonTemp = 1;
        for (int i = 0; i < teamCnt; i++) {
            Team team = list.get(i);
            if(prevTeam != null){
                if(prevTeam.gold == team.gold
                        && prevTeam.silver == team.silver
                        && prevTeam.brown == team.brown){
                    commonTemp++;
                    ;
                }else{
                    order+= commonTemp;
                    commonTemp = 1;
//                    order++;
                }
            }else{
                order++;
            }
            prevTeam = team;
            if(team.teamNumber == targetTeam){
                System.out.println(order);
            }
        }
    }
}
