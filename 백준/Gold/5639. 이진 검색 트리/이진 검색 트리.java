import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }

        public void insert(Node node){
            if(node.value > this.value){ //right
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.insert(node);
                }
            }else{
                if(this.left == null){
                    this.left = node;
                }else {
                    this.left.insert(node);
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> treeSet = new TreeSet<>();

        String str;
        Integer root = Integer.parseInt(br.readLine());
        Node node = new Node(root);
        while(true){
            str = br.readLine();
            if(str == null || str.equals("")) break;
            int value = Integer.parseInt(str);
            node.insert(new Node(value));
        }

        postOrder(node);
    }
    static void postOrder(Node node) {
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
