package programmers;

import java.util.*;

public class tripPath {

    public static void main(String[] args) {
        String[] answer = solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
    }
    static List<String> list = new ArrayList<>();
    static String[][] ticketList;
    static boolean useTicket[];
    public static String[] solution(String[][] tickets) {
        String[] answer;
        ticketList = tickets;
        useTicket = new boolean[tickets.length]; // 현재 이 ticket을 썼나 안 썻나
        dfs(0,"ICN","ICN");
        for(String s : list){
            System.out.println(s);
        }
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    public static void dfs(int depth, String start, String path){
        if(depth == ticketList.length){
            list.add(path);
            return;
        }
        for(int i=0; i< ticketList.length; i++){
            if(ticketList[i][0].equals(start) && !useTicket[i]){
                   useTicket[i] = true;
                   dfs(depth +1, ticketList[i][1], path + " " + ticketList[i][1]);
                   useTicket[i] = false;
            }
        }
    }
}
