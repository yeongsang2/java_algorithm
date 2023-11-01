package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20436 {

    static String[][] keyboard = {
            {"q","w","e","r","t","y","u","i","o","p"},
            {"a","s","d","f","g","h","j","k","l","."},
            {"z","x","c","v","b","n","m",".",".","."}
    };
    static int leftR, leftC, rightR, rightC, nowR, nowC =0;

    public static void main(String[] args) throws IOException {

//        int leftR, leftC, rightR, rightC;
        int total = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String left= st.nextToken();
        String right= st.nextToken();
        String target = br.readLine();

        checkLocation(left,right);

        for (int i = 0; i < target.length(); i++) {
            String now = Character.toString(target.charAt(i));
            checkLocationNow(now);

            int diffL = Math.abs(leftR - nowR) + Math.abs(leftC - nowC);
            int diffR = Math.abs(rightR - nowR) + Math.abs(rightC - nowC);
//            if(diffL <= diffR ){
//                total += diffL;
//                leftR = nowR;
//                leftC = nowC;
//            }else {
//                total += diffR;
//                rightR = nowR;
//                rightC = nowC;
//            }

            if(nowR == 0){
                if(nowC <= 4){
                    total += diffL;
                    leftR = nowR;
                    leftC = nowC;
                }else {
                    total += diffR;
                    rightR = nowR;
                    rightC = nowC;
                }
            } else if (nowR ==1) {
                if(nowC <= 4){
                    total += diffL;
                    leftR = nowR;
                    leftC = nowC;
                }else {
                    total += diffR;
                    rightR = nowR;
                    rightC = nowC;
                }
            }else {
                if(nowC <=3){
                    total += diffL;
                    leftR = nowR;
                    leftC = nowC;
                }else{
                    total += diffR;
                    rightR = nowR;
                    rightC = nowC;
                }
            }
            total +=1;
        }
        System.out.println(total);
    }
    private static void checkLocation(String left, String right){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(keyboard[i][j].equals(left)){
                    leftR = i;
                    leftC = j;
                }
                if(keyboard[i][j].equals(right)){
                    rightR = i;
                    rightC = j;
                }
            }
        }
    }

    private static void checkLocationNow(String now){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if(keyboard[i][j].equals(now)){
                    nowR = i;
                    nowC = j;
                }
            }
        }
    }
}
