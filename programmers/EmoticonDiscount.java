package programmers;
import java.util.*;

public class EmoticonDiscount {

    static class Solution {
        static int[][] users;
        static int[] emoticons;
        static int[] answer = {0,0};
        static int[] discountType = {10,20,30,40};

        public int[] solution(int[][] users, int[] emoticons) {

            Solution.users = users;
            Solution.emoticons = emoticons;
            int[] discount = new int[emoticons.length];


            dfs(discount,0);
            return answer;
        }
        static void dfs(int[] discount, int cur){

            if(cur == Solution.emoticons.length){
                calculate(discount);
                return;
            }

            for(int r : discountType){
                discount[cur] = r;
                dfs(discount, cur+1);
            }


        }
        static void calculate(int[] discount){
            int subNumber = 0;
            int sellMoney = 0;
            for(int i =0; i< Solution.users.length; i++){
                int rate = Solution.users[i][0];
                int money = Solution.users[i][1];
                double total =0;

                for(int j =0 ; j < discount.length; j++){
                    if(rate <= discount[j]){
                        total = total + Solution.emoticons[j]*( 1- (double)(discount[j] / 100.0) ) ;
                    }
                }

                if(total >= money){
                    subNumber += 1;
                }else{
                    sellMoney += total;
                }

            }
            if(subNumber > answer[0]){
                Solution.answer[0] = subNumber;
                answer[1] = sellMoney;
            }
            if(subNumber == answer[0]){
                answer[1] = Math.max(answer[1], sellMoney);
            }
        }
    }
}
