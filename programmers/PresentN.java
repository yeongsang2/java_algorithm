package programmers;
import java.util.*;

public class PresentN {

    class Solution {
        public int solution(int N, int number) {

            int answer = 0;
            List<HashSet<Integer>> list = new ArrayList();
            for(int i=0 ;i< 9; i++){
                list.add(new HashSet());
            }

            if(number == N){
                return 1;
            }
            list.get(1).add(N);
            for(int i=2; i<9; i++){
                for(int j=1; j<= i/2; j++){
                    unionSet(list.get(i), list.get(j), list.get(i-j));
                    unionSet(list.get(i), list.get(i-j), list.get(j));
                }

                String n = Integer.toString(N);
                list.get(i).add(Integer.parseInt(n.repeat(i)));

                for(int num : list.get(i)){
                    if( num == number){
                        return i;
                    }
                }
            }

            return -1;
        }

        public void unionSet(HashSet<Integer> union, HashSet<Integer> setA, HashSet<Integer> setB){

            for(int a : setA){
                for(int b: setB){
                    union.add(a+b);
                    union.add(a*b);
                    union.add(a-b);
                    if(b != 0){
                        union.add(a/b);
                    }
                }
            }
        }
    }

}
