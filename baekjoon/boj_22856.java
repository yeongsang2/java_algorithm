package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_22856 {
    static class Node{
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    static int n;
    static Node[] tree;
    static int lastNode;
    static List<Integer> inOrderList = new LinkedList<>();
    static List<Integer> similarInOrderList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tree = new Node[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[d] = new Node(l,r);
        }
        //중위순회해서 마지막 노드 찾기
        inOrder(1);
        lastNode = inOrderList.get(n-1);
        similarInOrder(1);
    }
    static void inOrder(int cur){


        int leftNode = tree[cur].left;
        int rightNode = tree[cur].right;

        if(leftNode != -1){
            inOrder(leftNode);
        }
        inOrderList.add(cur);
        if(rightNode !=-1){
            inOrder(rightNode);
        }
    }
    static void similarInOrder(int cur){

        similarInOrderList.add(cur);


        int leftNode = tree[cur].left;
        int rightNode = tree[cur].right;

        if(leftNode != -1){
            similarInOrder(leftNode);
            similarInOrderList.add(cur);
        }
        if(rightNode !=-1){
            similarInOrder(rightNode);
            similarInOrderList.add(cur);
        }
        if(cur == lastNode){
            System.out.println(similarInOrderList.size() - 1);
            System.exit(0);
        }

    }

}
