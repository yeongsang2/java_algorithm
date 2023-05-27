package programmers;

import java.util.*;
import java.util.function.IntConsumer;

public class mostLongNode {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] { {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2},{2, 4}, {5, 2}  } ));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, LinkedList<Integer>> map = new HashMap();
        Queue<Integer> queue = new LinkedList();
        int[] checked = new int[n+1];
        for(int i=1; i < n + 1 ;i ++){
            checked[i] = 0;
        }

        for(int i = 1 ; i< n+1 ; i++){
            map.put(i, new LinkedList<Integer>());
        }

        for(int i=0; i < edge.length; i++){
                map.get(edge[i][0]).add(edge[i][1]);
                map.get(edge[i][1]).add(edge[i][0]);
        }
        queue.add(1);
        checked[1] = 1;
        while(!queue.isEmpty()){
            int q = queue.poll();
            if (map.containsKey(q)) {
                for (int i : map.get(q)) {
                    if (checked[i] == 0 && !queue.contains(i)) {
                        queue.add(i);
                        checked[i] = checked[q] + 1;
                    }
                }
            }
        }
        int max=0;

        max = Arrays.stream(checked).max().getAsInt();
        for (int i = 1; i <n+1; i++) {
            if( checked[i] == max){
                answer++;
            }
        }
        return answer;
    }
}
