package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumbersK {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{ {2, 5, 3}, {4, 4, 1}, {1, 7, 3}} ));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int length = end - start +1;
            int[] tempArray = new int[length];
            List<Integer> list = new LinkedList();
            for(int j = start ; j < end +1 ; j++) {
                list.add(array[j]);
            }
            for(int j = 0; j < length;j++){
                tempArray[j] = list.get(j);
            }
            Arrays.sort(tempArray);
            answer[i] = tempArray[commands[i][2] -1];
        }
        return answer;
    }
}
