package baekjoon;

import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1068 {

    static List<Integer>[] tree;
    static int rootNode;
    static int cut;
    static int count = 0;
    static List<Integer> removeNode = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        rootNode = -1;
        int n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a == -1){
                rootNode = i;
                continue;
            }
            tree[a].add(i);
        }

        cut = Integer.parseInt(br.readLine());
        countNode(rootNode, -1);
        System.out.println(count);
    }

    static void countNode(int now, int prev){

        if(now == cut){
            if (prev != -1 && tree[prev].size() == 1){
                count++;
            }
            return;
        }

        List<Integer> list = tree[now];
        if(list.isEmpty()){
            count++;
            return;
        }
        for(Integer l : list){
            countNode(l,now);
        }
    }
}
