
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Player implements Comparable<Player> {

        int level;
        String name;
        public Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        public int compareTo(Player o){
            return this.name.compareTo(o.name);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> roomList = new ArrayList<>();
        roomList.add(new ArrayList<>());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            boolean flag = false;
            for (int j = 0; j < roomList.size(); j++) {
                List<Player> playerList = roomList.get(j);
                if(playerList.isEmpty()){
                    playerList.add(new Player(level, name));
                    flag = true;
                    break;
                }else{
                    int firstLevel = playerList.get(0).level;
                    if(level >= (firstLevel - 10) && level <= (firstLevel + 10) && playerList.size() < m){
                        playerList.add(new Player(level, name));
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                roomList.add(new ArrayList<>());
                roomList.get(roomList.size() - 1).add(new Player(level, name));
            }
        }

        for(List<Player> rooms : roomList){
            if(rooms.size() == m){
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }
            Collections.sort(rooms);
            for (Player player : rooms){
                System.out.println(player.level + " " + player.name);
            }
        }

    }
}
