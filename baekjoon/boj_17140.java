package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17140 {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[101][101];

        for (int i = 1; i < 4; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int t = 0;
        int rowCount = 3;
        int colCount = 3;

        if(map[r][c] == k){
            System.out.println(0);
            return;
        }

        while (t++ < 100) {
            int maxRow= 0;
            int maxCol= 0;
            if(rowCount >= colCount){ //r연산
                for (int i = 1; i < rowCount+1; i++) {
                    HashMap<Integer, Integer> countMap  = new HashMap<>();
                    for (int j = 1; j < colCount+1; j++) {
                        int m = map[i][j];
                        if(m==0)continue;
                        countMap.put(m, countMap.getOrDefault(m,0) + 1);
                    }
                    maxCol = Math.max(pushR(i, countMap), maxCol);
                }
            }else{ //c연산
                for (int i = 1; i < colCount+1; i++) {
                    HashMap<Integer, Integer> countMap  = new HashMap<>();
                    for (int j = 1; j < rowCount+1; j++) {
                        int m = map[j][i];
                        if(m==0)continue;
                        countMap.put(m, countMap.getOrDefault(m,0) + 1);
                    }
                    maxRow = Math.max(pushC(i, countMap), maxRow);
                }
            }
            if(maxRow != 0){
                rowCount = maxRow;
            }
            if(maxCol != 0){
                colCount = maxCol;
            }
            if(map[r][c] == k){
                break;
            }
        }
        if(t== 101){
            System.out.println(-1);
        }else{
            System.out.println(t);

        }
    }

    private static void show(int rowCount, int colCount) {

        for (int i = 1; i < rowCount+1; i++) {
            for (int j = 1; j <colCount+1 ; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    private static int pushR(int i, HashMap<Integer, Integer> countMap) {

        List<Integer> keySet = new ArrayList<>(countMap.keySet());

        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(countMap.get(o1) == countMap.get(o2)){
                    return o1-o2;
                }
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        int j = 1;
        for(Integer key : keySet){
            map[i][j] = key;
            j++;
            map[i][j] = countMap.get(key);
            j++;
        }
        int max = j-1;
        while(j < 101){
            map[i][j] =0;
            j++;
        }
        return max;
    }

    private static int pushC(int i, HashMap<Integer, Integer> countMap) {

        List<Integer> keySet = new ArrayList<>(countMap.keySet());

        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(countMap.get(o1) == countMap.get(o2)){
                    return o1-o2;
                }
                return countMap.get(o1) - countMap.get(o2);
            }
        });
        int j = 1;
        for(Integer key : keySet){
            map[j][i] = key;
            j++;
            map[j][i] = countMap.get(key);
            j++;
        }
        int max = j-1;
        while(j < 101){
            map[j][i] =0;
            j++;
        }
        return max;
    }
}
