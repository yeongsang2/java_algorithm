package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1991 {

    static int n;
    static Map<String, String[]> treeMap = new HashMap<>();
    static List<String> answerPre= new LinkedList<>();
    static List<String> answerIn = new LinkedList<>();
    static List<String> answerPost = new LinkedList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n =  Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s[] = br.readLine().split(" ");
            String[] value = { s[1], s[2] };
            treeMap.put(s[0], value );
        }
        inOrder("A");
        preOrder("A");
        postOrder("A");

        for(String s : answerPre){
            System.out.print(s);
        }
        System.out.println();
        for(String s : answerIn){
            System.out.print(s);
        }
        System.out.println();
        for(String s : answerPost){
            System.out.print(s);
        }
    }

    private static void postOrder(String now) {

        if(now.equals(".")){
            return;
        }
        postOrder(treeMap.get(now)[0]);
        postOrder(treeMap.get(now)[1]);
        answerPost.add(now);
    }

    private static void preOrder(String now) {

        if(now.equals(".")){
            return;
        }

        answerPre.add(now);
        preOrder(treeMap.get(now)[0]);
        preOrder(treeMap.get(now)[1]);

    }

    private static void inOrder(String now) {
        if(now.equals(".")){
            return;
        }
        inOrder(treeMap.get(now)[0]);
        answerIn.add(now);
        inOrder(treeMap.get(now)[1]);
    }
}
