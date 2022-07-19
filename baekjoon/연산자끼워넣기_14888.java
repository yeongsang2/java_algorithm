package baekjoon;
import java.util.*;

public class 연산자끼워넣기_14888 {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    private static int[] op = new int[4]; // 연산자 개수
    private static int[] number ; // 숫자
    private static int n;

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        number = new int[n];
        for(int i =0;i < n ; i++){
            number[i] = sc.nextInt();
        }

        for(int i =0 ;i <4 ;i++) {
            op[i] = sc.nextInt();
        }

        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs(int num, int idx){

        if(idx == n){ //호출끝
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for(int i = 0; i< 4 ; i++){
            if(op[i] > 0) {
                op[i] --;
                if (i == 0) {
                    dfs(num + number[idx], idx+1);
                } else if (i == 1) {
                    dfs(num - number[idx], idx+1);
                } else if (i == 2) {
                    dfs(num * number[idx], idx+1);
                } else if (i == 3) {
                    dfs(num / number[idx], idx+1);
                }
                op[i] ++;
            }

        }
    }
}
