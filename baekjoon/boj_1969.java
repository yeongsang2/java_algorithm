package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1969 {

    static String[] dnaList;
    static int n;
    static int m;
    static int result = 0;
    static String answer ="";
    public static void main(String[] args) throws IOException {
        // A T G C

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Character, Integer> map;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dnaList = new String[n+1];

        for (int i = 0; i < n ; i++) {
            dnaList[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                Character c = dnaList[j].charAt(i);
                map.put(c, map.getOrDefault(c, 0)+1);
            }

            List<Character> keySet = new ArrayList<>(map.keySet());
            Collections.sort(keySet);

            Character nowC = 'A';
            int max = -1;
            for(Character c : keySet){
                int now = map.get(c);
                if( max < now){
                    max = now;
                    nowC = c;
                }
            }
            answer += Character.toString(nowC);
        }

        for (int i = 0; i < n; i++) {
            String str = dnaList[i];
            for (int j = 0; j < m; j++) {
                if( str.charAt(j) != answer.charAt(j) ){
                    result +=1;
                }
            }
        }

        System.out.println(answer);
        System.out.println(result);

    }

}
