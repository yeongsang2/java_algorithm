package programmers;

import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5}));
    }
    public static String solution(String[] survey, int[] choices) {
        HashMap<String,Integer> hashMap = new HashMap<> ();

        hashMap.put("R", 0);
        hashMap.put("T", 0);
        hashMap.put("C", 0);
        hashMap.put("F", 0);
        hashMap.put("J", 0);
        hashMap.put("M", 0);
        hashMap.put("A", 0);
        hashMap.put("N", 0);
        StringTokenizer st;
        for(int i =0; i<survey.length; i++){
            String first = survey[i].substring(0,1);
            String end = survey[i].substring(1,2);
            if(choices[i] == 4){
                continue;
            }
            if(choices[i] < 4){
                hashMap.put(first, hashMap.get(first) + Math.abs(4 - choices[i]));
            }else if(choices[i] > 4){
                hashMap.put(end, hashMap.get(end) + Math.abs(4 - choices[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        if( hashMap.get("R")  >= hashMap.get("T") ){
            sb.append("R");
        }else if ( hashMap.get("R")  < hashMap.get("T") ){
            sb.append("T");
        }

        if( hashMap.get("C")  >= hashMap.get("F") ){
            sb.append("C");
        }else if ( hashMap.get("C")  < hashMap.get("F") ){
            sb.append("F");
        }

        if( hashMap.get("J")  >= hashMap.get("M") ){
            sb.append("J");
        }else if ( hashMap.get("J")  < hashMap.get("M") ){
            sb.append("M");
        }

        if( hashMap.get("A")  >= hashMap.get("N") ){
            sb.append("A");
        }else if ( hashMap.get("A")  < hashMap.get("N") ){
            sb.append("N");
        }

        String answer = sb.toString();
        return answer;
    }
}