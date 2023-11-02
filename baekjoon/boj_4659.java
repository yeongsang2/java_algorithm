package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.exit;

public class boj_4659 {

    static List<String> mo = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mo.add("a");
        mo.add("e");
        mo.add("i");
        mo.add("o");
        mo.add("u");


        while(true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }

            if( checkOne(str) && checkTwo(str) && checkThree(str) ){
                System.out.println("<" + str + ">" + " is acceptable.");
            }else {
                System.out.println("<" + str + ">" + " is not acceptable.");
            }
        }

    }
    static boolean checkOne(String str){
        if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")){
            return true;
        }
        return false;
    }

    static boolean checkTwo(String str){

        int flag = 0; //0 모음, 1자음
        int count = 0;
        if(mo.contains(Character.toString(str.charAt(0)))){
            flag = 0;
        }else {
            flag = 1;
        }
        for (int i = 1; i < str.length(); i++) {

            if(flag == 0){ //모음일때
                if(mo.contains(Character.toString(str.charAt(i)))){
                    flag = 0;
                    count++;
                }else {
                    flag = 1;
                    count = 0;
                }
            }else {
                if(mo.contains(Character.toString(str.charAt(i)))){
                    flag = 0;
                    count =0;
                }else {
                    flag = 1;
                    count++;
                }
            }
            if(count == 2){
                return false;
            }
        }
        return true;
    }

    static boolean checkThree(String str){

        String prev = Character.toString(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            String now = Character.toString(str.charAt(i));
            if(prev.equals(now)){
                if(now.equals("e") || now.equals("o")){
                    continue;
                }else {
                    return false;
                }
            }
            prev = now;
        }
        return true;
    }
}
