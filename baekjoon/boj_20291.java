package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_20291 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i< n ; i++){
            String str = br.readLine();
            for(int j=0; j <str.length(); j++){
                if( str.charAt(j) == '.'){
                    map.put(str.substring(j + 1), map.getOrDefault(str.substring(j+1), 0) + 1);
                    break;
                }
            }
        }
        List<String> list= new LinkedList();
        for(String key : map.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        for(String key : list){
            System.out.println(key + " " + map.get(key));
        }

    }
}
