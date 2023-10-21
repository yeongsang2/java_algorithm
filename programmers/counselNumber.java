package programmers;
import java.util.*;

import static java.lang.Math.max;

public class counselNumber {

    static class Solution {
        static int k;
        static int n;
        static int[] mentor;
        static int answer;
        static int[][] reqs;

        public int solution(int k, int n, int[][] reqs) {
            Solution.answer = 99999999;
            Solution.k = k;
            Solution.n = n-k;
            Solution.reqs = reqs;
            mentor = new int[n+1];

            for(int i =1; i < k+1; i++){
                mentor[i] = 1;
            }

            recur(0,0);

            return Solution.answer;
        }

        static void recur(int cnt, int last){
            if(cnt == Solution.n){ //다 채워짐
                Solution.calculate();
                return;
            }

            for(int i =1; i < Solution.n+1; i++){
                for(int j=last+1; j < Solution.k +1 ;j++){
                    mentor[j] += i;
                    recur(cnt+i, j);
                    mentor[j] -= i;
                }
            }
        }
        static void calculate(){
            PriorityQueue<Integer>[] pq = new PriorityQueue[k+1]; //우선순위 큐당 있는 배열
            int time=0;
            for(int i=0; i < Solution.k +1; i++){
                pq[i] = new PriorityQueue<Integer>();
                for(int j = 0 ; j < mentor[i] ; j++){
                    pq[i].add(0);
                }
            }

            for(int i =0 ; i < Solution.reqs.length ; i++){

                int start = Solution.reqs[i][0];
                int during = Solution.reqs[i][1];
                int type = Solution.reqs[i][2];
                int poll = pq[type].poll();

                if(poll <= start){ //바로 시작 가능
                    pq[type].add(start+during); // 끝나는 시간 추가
                }else{ //바로 시작 안됨
                    time = time + (poll - start);
                    pq[type].add(poll+during);
                    if(time >= Solution.answer) return;
                }
            }
            Solution.answer = time;
        }
    }
}
