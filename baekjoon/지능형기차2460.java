package baekjoon;

import java.util.*;

public class 지능형기차2460 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int maxPeople =-9999;
        int nowPeople =0;
        int outPeople; //내리는사람
        int inPeople;  //타는사람
        for(int i=0; i<10; i++){
            outPeople = sc.nextInt();
            inPeople = sc.nextInt();
            nowPeople = nowPeople - outPeople + inPeople;
            if(nowPeople >= maxPeople){
                maxPeople = nowPeople;
            }
        }
        System.out.println(maxPeople);
    }
}
