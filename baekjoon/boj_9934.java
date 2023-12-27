package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9934 {
    static int k;

    static Map<Integer, List> map = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int arr[];

        k = Integer.parseInt(br.readLine());
        int totalNodeCnt = (int) (Math.pow(2,k) - 1);

        arr = new int[totalNodeCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalNodeCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < k+1; i++) {
            map.put(i, new LinkedList());
        }

        recur(arr, 0 ,totalNodeCnt - 1 ,1);

        Set<Integer> keys = map.keySet();
        for(Integer i : keys){
            List<Integer> list = map.get(i);
            for(Integer l : list){
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }
    static void recur(int[] arr,int start, int end, int h){

        if( (end - start) <= 0 ){
            map.get(h).add(arr[end]);
            return;
        }
        int mid =  ( start + end ) / 2;
        map.get(h).add(arr[mid]);
        recur(arr, start, mid -1, h+1);
        recur(arr ,mid+1, end, h+1);
    }
}
