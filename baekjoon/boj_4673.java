package baekjoon;

public class boj_4673 {

    public static void main(String[] args) {

        boolean[] checkSelfNum= new boolean[10001];

        for(int i = 1 ; i < 10001 ; i++){
            int n = getNotSelfNumber(i);
            if( n <= 10000) checkSelfNum[n] = true;
        }

        for(int i = 1 ; i < 10001 ; i++){
            if(!checkSelfNum[i]) System.out.println(i);
        }
    }

    public static int getNotSelfNumber(int i){
        int sum = i;
        while(i != 0){
            sum = sum + (i % 10);
            i = i / 10;
        }
        return sum;
    }
}
