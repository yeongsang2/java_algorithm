
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static class Node implements Comparable<Node> {
        String value;
        TreeMap<String, Node> childList;
        public Node(String value){
            this.value = value;
            this.childList = new TreeMap<>();
        }

        @Override
        public int compareTo(Node o) {
            return this.value.compareTo(o.value);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Map<String, Node> map = new HashMap<>();
        Node root = new Node("ROOT");
        while (n-- > 0){

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            Node parent = root;
            while (k-- > 0){
                String nowNode = st.nextToken();

                parent.childList.putIfAbsent(nowNode, new Node(nowNode));

                parent = parent.childList.get(nowNode);
            }
        }
        for(Node node : root.childList.values()){
            search(node, "");
        }

    }
    static void search(Node node, String path){

        System.out.println(path + node.value);

        for(Node next : node.childList.values()){
            search(next, path + "--");
        }
    }
}
