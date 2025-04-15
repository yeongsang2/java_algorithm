
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, energy;
    static int[][] map;
    static int wall = Integer.MAX_VALUE;

    // 상 좌 우 하
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};

    static class Loc implements Comparable<Loc> {
        int r;
        int c;
        int cost;

        public Loc(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Loc o) {

            if(this.cost == o.cost){
                if(this.r == o.r) return this.c - o.c;
                return this.r - o.r;
            }
            return this.cost - o.cost;
        }
    }
    static class Person implements Comparable<Person> {
        int r;
        int c;
        boolean isFinished;
        public Person(int r, int c, boolean isFinished){
            this.r = r;
            this.c = c;
            this.isFinished = isFinished;
        }

        @Override
        public int compareTo(Person o) {

            if(this.r == o.r){
                return this.c - o.c;
            }
            return this.r - o.r;
        }

        boolean[][] startPoint;
    }
    static Map<Person, Person> pair = new TreeMap<>();
    static Person targetP;
    static boolean[][] startPoint;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        energy = Integer.parseInt(st.nextToken());
        startPoint = new boolean[n + 1][n + 1];

        map = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < n + 1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) map[i][j] = wall;
                else map[i][j] = temp;
            }
        }

        st = new StringTokenizer(br.readLine());
        int taxiR = Integer.parseInt(st.nextToken());
        int taxiC = Integer.parseInt(st.nextToken());

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Person start = new Person(a, b, false);
            Person end = new Person(c, d, false);
            pair.put(start, end);
            startPoint[a][b] = true;
        }

        for (int i = 0; i < m; i++) { // 총 m번?

            // 가장 가까운 승객 정하기
            Person person = findPerson(taxiR, taxiC);

            if(person == null || energy < 0){
                System.out.println(-1);
                return;
            }

            // 목적지 가져다 놓기
            targetP = pair.get(person);
            Queue<Loc> queue = new LinkedList<>();
            queue.add(new Loc(person.r, person.c, 0));
            boolean[][] visited = new boolean[n + 1][n + 1];
            int temp = -1;
            boolean flag = false;
            while (!queue.isEmpty()){
                Loc poll = queue.poll();
                if(poll.r == targetP.r && poll.c == targetP.c){
                    temp = poll.cost;
                    energy -= temp;
                    flag = true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nextR = poll.r + dr[j];
                    int nextC = poll.c + dc[j];
                    if(nextR > 0 && nextR < n + 1 && nextC > 0 && nextC < n + 1
                            && !visited[nextR][nextC] && map[nextR][nextC] != wall){
                        visited[nextR][nextC] = true;
                        queue.add(new Loc(nextR, nextC, poll.cost + 1));
                    }
                }
            }
            if(energy < 0 || !flag){
                System.out.println(-1);
                return;
            }

            energy += temp * 2;
            taxiR = targetP.r;
            taxiC = targetP.c;
        }

        System.out.println(energy);
    }

    private static Person findPerson (int taxiR, int taxiC){

        Person findP = null;

        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(taxiR, taxiC, 0));
        boolean[][] visited = new boolean[n + 1][n + 1];
        int temp = -1;
        int startR = -1;
        int startC = -1;
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        while (!queue.isEmpty()){
            Loc poll = queue.poll();
            if(startPoint[poll.r][poll.c]){
                pq.add(poll);
            }
            for (int i = 0; i < 4; i++) {
                int nextR = poll.r + dr[i];
                int nextC = poll.c + dc[i];
                if(nextR > 0 && nextR < n + 1 && nextC > 0 && nextC < n + 1
                        && !visited[nextR][nextC] && map[nextR][nextC] != wall){
                    visited[nextR][nextC] = true;
                    queue.add(new Loc(nextR, nextC, poll.cost + 1));
                }
            }
        }

        if(pq.isEmpty()){
            return findP;
        }
        Loc poll = pq.poll();

        startPoint[poll.r][poll.c] = false;
        for(Person p : pair.keySet()){
            if(p.r ==  poll.r && p.c == poll.c){
                findP = p;
                break;
            }
        }

        findP.isFinished = true;
        energy -= poll.cost;
        return findP;
    }
}
