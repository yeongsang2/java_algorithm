package baekjoon;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 멀티탭스케줄링_1700 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String b = br.readLine();
        st = new StringTokenizer(b);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int result = 0;

        Map<Integer, Integer> map = new HashMap();

        List<Integer> list = new ArrayList<>();
        String s = br.readLine();
        st = new StringTokenizer(s);
        for(int i =0; i<k;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

//        for (Integer i : map.keySet()) {
//            System.out.println( i +  " : " + map.get(i));
//
//        }

        Set<Integer> set= new HashSet<>();
        List<Integer> checkList = new ArrayList();
        for(int i= 0; i<list.size(); i++){

            if(checkList.contains(list.get(i))){ //멀티탭에 이미 꽂혀있음
                continue;
            }else if(checkList.size() == n){ //머리탭 구멍 꽉참 가장 늦게 나오는 멀티탭 뺌

                int temp = -1; // 뺴야할 값
                int idx = -1;
                result +=1;
                List<Integer> subList = list.subList(i+1, list.size());
                for(int j=0;j<checkList.size();j++){
                    if(!subList.contains(j)){
                        temp = subList.get(j);
                    }else{ // 존재한다면 가장 늦게 나오는 멀티탭
                         for(int m=0;m<subList.size();m++){
                             if(subList.get(m) == checkList.get(j)){
                                 if(temp < m){
                                     temp = m;
                                 }
                             }
                         }
                    }
                }
                for(int j=0;j<checkList.size();j++){
                    if(checkList.get(j) == temp){
                        checkList.remove(j);
                    }
                }
                checkList.add(list.get(i));
            }else{
                checkList.add(list.get(i));
            }
//            System.out.println(checkList);
        }

        System.out.println(result);


    }


}
