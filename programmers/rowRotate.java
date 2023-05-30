package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class rowRotate {

    public static void main(String[] args) {
        solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;
        List<Integer> answerList = new LinkedList<>();
        int[][] map = new int[rows+1][columns+1];
        int[][] copyMap = new int[rows+1][columns+1];

        int cnt = 1;
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < columns+1; j++) {
                map[i][j] = cnt;
                cnt++;
            }
        }
        for (int i = 1; i < rows+1; i++) {
            for (int j = 1; j < columns+1; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < queries.length; i++) {

            List<Integer> list = new LinkedList<>();
            int x1= queries[i][0];
            int y1= queries[i][1];
            int x2= queries[i][2];
            int y2= queries[i][3];

            for (int j = 1; j < rows+1; j++) {
                for (int k = 1; k < columns+1; k++) {
                    if( ( j == x1 )  && (  y1 <= k ) && ( k < y2 ) ) {
                        map[j][k+1] = copyMap[j][k];
                        list.add(copyMap[j][k]);
//                        System.out.println(copyMap[j][k]);
                    }
                    if( (j > x1) && ( k == y1 ) && ( j <= x2) ){
                        map[j-1][k] = copyMap[j][k];
                        list.add(copyMap[j][k]);
//                        System.out.println(copyMap[j][k]);
                    }
                    if( ( j == x2 ) && ( k > y1) && ( k <= y2) ){
                        map[j][k-1] = copyMap[j][k];
                        list.add(copyMap[j][k]);
//                        System.out.println(copyMap[j][k]);
                    }
                    if( ( j >= x1) && (j < x2) && (k == y2) ){
                        map[j+1][k] = copyMap[j][k];
                        list.add(copyMap[j][k]);
//                        System.out.println(copyMap[j][k]);

                    }
                }
            }
            for (int p = 1; p < rows+1; p++) {
                for (int l = 1; l < columns+1; l++) {
                    int temp = map[p][l];
                    copyMap[p][l] = temp;
                }
            }

            answerList.add(Collections.min(list));
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
//            System.out.println(answer[i]);
        }
        return answer;
    }
}
