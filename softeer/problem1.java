package softeer;

import java.util.LinkedList;
import java.util.List;

public class problem1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{11,2,2,2,3,3}));
    }
    public static int solution(int[] param) {

        int answer =40;
        int[][] map =   {
                {0,0,0,0,0,0,17,17,17,0,0,0,0,0,0},
                {0,0,0,0,0,4,17,17,17,1,0,0,0,0,0},
                {0,0,0,7,7,4,4,12,12,1,1,5,5,0,0,0},
                {0,0,7,7,7,4,4,12,12,1,1,5,5,5,0,0},
                {0,0,7,7,7,4,4,12,12,1,1,5,5,5,0,0},
                {0,16,16,16,16,4,4,12,12,1,1,13,13,13,13,0},
                {19,19,16,16,16,16,4,12,12,1,13,13,13,13,20,20},
                {19,19,10,10,10,10,10,25,25,9,9,9,9,9,20,20},
                {19,19,10,10,10,10,10,25,25,9,9,9,9,9,20,20},
                {19,19,15,15,15,15,3,11,11,2,14,14,14,14,20,20},
                {0,15,15,15,15,3,3,11,11,2,14,14,14,14,20,20},
                {0,0,6,6,6,3,3,11,11,2,2,8,8,8,0,0},
                {0,0,6,6,6,3,3,11,11,2,2,8,8,8,0,0},
                {0,0,0,6,6,3,3,11,11,2,2,8,8,0,0,0},
                {0,0,0,0,0,3,18,18,18,2,0,0,0,0,0},
                {0,0,0,0,0,0,18,18,18,0,0,0,0,0,0}

                };
        List<LinkedList<Integer>> list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
        list.get(1).add(5);
        list.get(2).add(6);
        list.get(3).add(7);
        list.get(4).add(8);
        list.get(5).add(17);
        list.get(5).add(18);
        list.get(6).add(9);
        list.get(6).add(10);
        list.get(7).add(11);
        list.get(7).add(12);
        list.get(8).add(19);
        list.get(8).add(20);
        list.get(9).add(25);
        int round = param.length / 6;
        int start =0;
        for(int i =1 ; i < round +1 ; i++){
            int temp= 0;
            for(int j = start; j < i*6 -1;  j+=2){
                int x = param[j];
                int y = param[j+1] ;
                int i1 = map[x][y] ;
                System.out.println(i1);
                for(Integer sb : list.get(i)){
                }
                if(list.get(i).contains(i1)){
                    answer += i1;
                    temp =1;
                }
            }

            if(temp == 0){
                answer = (int) Math.ceil(answer / 2);
            }
            start = start + 6;
        }
        return answer;
    }
}


