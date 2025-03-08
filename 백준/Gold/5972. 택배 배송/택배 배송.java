
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Path{
        int end;
        int cnt;
        public Path(int end, int cnt){
            this.end = end;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Path>> list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Path(b, c));
            list.get(b).add(new Path(a, c));
        }

        int[] distance = new int[N + 1];
        Arrays.fill(distance, 100000000);
        distance[1] = 0;
        PriorityQueue<Path> pq = new PriorityQueue<>(new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.cnt - o2.cnt;
            }
        });

        boolean[] visited = new boolean[N + 1];
        pq.add(new Path(1, 0));

        while (!pq.isEmpty()){
            Path now = pq.poll();
            visited[now.end] = true;
            for(Path path : list.get(now.end)){
                if(!visited[path.end] && distance[path.end] > distance[now.end] + path.cnt){
                    distance[path.end] = distance[now.end] + path.cnt;
                    pq.add(new Path(path.end, distance[path.end]));
                }
            }
        }

//        for (int i = 1; i < N + 1; i++) {
//            System.out.print(distance[i] + " ");
//        }

        System.out.println(distance[N]);

    }
}
