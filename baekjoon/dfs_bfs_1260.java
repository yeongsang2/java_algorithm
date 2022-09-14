package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dfs_bfs_1260 {

    public static List<ArrayList<Integer>> list = new ArrayList<>();
    public static int[] visited;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        //양방향
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList();

        visited = new int[N+1];

        init();

        for(int i= 0; i<= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0 ; i<M ; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i =1 ; i< N+1 ;i++){ // 정렬
            Collections.sort(list.get(i));
        }

        dfs(V);
        System.out.println();
        init();
        queue.add(V);
        while(!queue.isEmpty()){

            Integer peek = queue.poll();
            visited[peek] =1;
            System.out.print(peek+ " ");
            for (Integer integer : list.get(peek)) {
                if( !queue.contains(integer) && visited[integer] == 0) {
                    queue.add(integer);
                }
            }
        }

    }
    public static void dfs(int start){

        visited[start] = 1; //방문처리
        System.out.print(start + " ");

        for (Integer integer : list.get(start)) {
            if(visited[integer] == 0){
                dfs(integer);
            }
        }
    }
    public static void init(){

        for(int i = 0; i< N+1; i++){
            visited[i] = 0;
        }
    }
}
