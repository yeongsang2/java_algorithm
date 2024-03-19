package programmers;
import java.util.*;

public class LongestNode {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    static public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> map = new HashMap();
        int answer = 0;
        int[] visited = new int[n+1];
        for(int i =1 ; i< n+1; i++){
            map.put(i, new ArrayList());
        }
        for(int i=0 ;i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        for(int i =1 ; i < n+1; i++){
            visited[i] = 0;
        }
        // visited[0] = -1;
        visited[1] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();
            List<Integer> list = map.get(now);
            System.out.println(now);

            if(list.size() > 0){
                for(int i : list){
                    if(i !=  0 && visited[i] == 0)
                        visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }

        int max = -1;
        int cnt = 0;
        for(int i = 1 ;i < n+1; i++){
            if(visited[i] > max){
                max = visited[i];
                cnt =0;
            }else if(visited[i] == max){
                cnt++;
            }
        }
        return cnt;
    }
}
