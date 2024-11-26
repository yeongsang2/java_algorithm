package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_4153 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }

            if(list.get(0) == 0 && list.get(1) == 0 && list.get(2) == 0){
                return;
            }

            Collections.sort(list);
            if( (list.get(0)*list.get(0) + list.get(1)*list.get(1)) == list.get(2)*list.get(2) ){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}
