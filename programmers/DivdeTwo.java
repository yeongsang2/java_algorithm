package programmers;
import java.util.*;

public class DivdeTwo {
    public static void main(String[] args) {
        System.out.println(solution(9 , new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }

    static Map<Integer, List<Node>> map = new HashMap();
    static boolean[] visited;
    static int min = 0;
    static int max = 1000;
    static int tempA;
    static int tempB;

    static class Node{
        int value;
        boolean status;
        public Node(int value){
            this.value = value;
            this.status = true;
        }
    }
    static public int solution(int n, int[][] wires) {

        visited = new boolean[n+1];

        for(int i =1 ; i< n+1; i++){
            map.put(i, new ArrayList());
        }

        for(int i =0 ; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map.get(a).add(new Node(b));
            map.get(b).add(new Node(a));
        }

        for(int i =0 ; i< wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            remove(a,b);
            tempA = 0;
            tempB = 0;
            visited[a] = true;
            visited[b] = true;
            searchA(a);
            searchB(b);
            if( (max-min) > Math.abs(tempA - tempB) ){
                max = Math.max(tempA, tempB);
                min = Math.min(tempA, tempB);
            }
            visited[a] = false;
            visited[b] = false;
            recovery(a,b);
        }
        return max-min;
    }
    static public void searchA(int node){
        tempA++;
        if(map.containsKey(node)){
            List<Node> list = map.get(node);
            if(list.size() > 0){
                for(Node l : list){
                    if(!visited[l.value] && l.status == true){
                        visited[l.value] = true;
                        searchA(l.value);
                        visited[l.value] = false;
                    }
                }
            }
        }
    }
    static public void searchB(int node){
        tempB++;
        if(map.containsKey(node)){
            List<Node> list = map.get(node);
            if(list.size() > 0){
                for(Node l : list){
                    if(!visited[l.value] && l.status == true){
                        visited[l.value] = true;
                        searchB(l.value);
                        visited[l.value] = false;
                    }
                }
            }
        }
    }
    static public void remove(int a, int b){
        List<Node> aList = map.get(a);
        List<Node> bList = map.get(b);

        for(int i=0; i< aList.size(); i++){
            if(aList.get(i).value == b){
                aList.get(i).status = false;
            }
        }
        for(int i=0; i< bList.size(); i++){
            if(bList.get(i).value == a){
                bList.get(i).status = false;
            }
        }
    }

    static public void recovery(int a, int b){
        List<Node> aList = map.get(a);
        List<Node> bList = map.get(b);

        for(int i=0; i< aList.size(); i++){
            if(aList.get(i).value == b){
                aList.get(i).status = true;
            }
        }
        for(int i=0; i< bList.size(); i++){
            if(bList.get(i).value == a){
                bList.get(i).status = true;
            }
        }
    }
}
