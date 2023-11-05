package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class boj_15721 {
    static int t;
    static int flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        flag = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();

        int cnt = 1;
        // 무조건 뻔이랑 데기는 한번씩이네
        // 뻔 == 0 데기 == 1

        while(true){
            addInit(list);
            for (int i = 0; i <cnt + 1; i++) {
                list.add(0);
            }
            for (int i = 0; i <cnt + 1; i++) {
                list.add(1);
            }
            if (t <= list.size()){
                int where =checkLocation(list) - 1;
                int answer = where % a;
                System.out.println(answer);
                break;
            }
            cnt ++;
        }
    }
    static void addInit(List list){

        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        return;
    }
    static int checkLocation(List<Integer> list){
        int answerCount = 0;
        int count = 0;

        for(int s : list){
            count++;
            if(s == flag){
                answerCount++;
            }
            if(answerCount == t){
                return count;
            }
        }
        return count;
    }
}
