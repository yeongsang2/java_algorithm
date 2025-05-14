import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] count = new int[n+1];
            int[] score = new int[n+1];
            int[] order = new int[n+1];

            Map<Integer, Integer> fiveCheckMap = new HashMap<>(); // 팀, 등수

            for (int i = 1; i < n + 1 ; i++) {

                int team = Integer.parseInt(st.nextToken());
                order[i] = team;
                count[team]++;
                if(count[team] == 5) {
                    fiveCheckMap.put(team, i);
                }
            }

            int temp = 1;
            int[] teamScoreCount = new int[n+1];

            for (int i = 1; i < n + 1 ; i++) {

                int team = order[i];
                if(count[team] >= 6){
                    if(teamScoreCount[team] < 4){
                        teamScoreCount[team]++;
                        score[team] += temp;
                    }
                    temp++;
                }
            }

            int answer = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if(count[i] >= 6 && score[i] != 0){
                    if (score[i] == min){
                        int prev = fiveCheckMap.get(answer);
                        int now = fiveCheckMap.get(i);
                        if(prev > now){
                            answer = i;
                            min = score[i];
                        }
                    }
                    if(score[i] < min){
                        answer = i;
                        min = score[i];
                    }

                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}

