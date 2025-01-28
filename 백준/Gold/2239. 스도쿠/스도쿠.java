
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];
    static List<int[]> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = Character.getNumericValue(str.charAt(j));
                if(num == 0){
                    list.add(new int[]{i,j});
                }
                board[i][j] = num;
            }
        }

        search(0);
    }

    static void search(int point){
        if(point == list.size()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        int r = list.get(point)[0];
        int c = list.get(point)[1];
        for (int i = 1; i < 10; i++) {
            if(checkRow(point, i) && checkCol(point, i) && checkBox(point, i)){
                board[r][c] = i;
                search(point+1);
                board[r][c] = 0;
            }
        }

    }
    static boolean checkRow(int point, int num){

        int r = list.get(point)[0];
        for (int i = 0; i < 9; i++) {
            if(board[r][i] == num){
                return false;
            }
        }
        return true;
    }
    static boolean checkCol(int point, int num){
        int c = list.get(point)[1];
        for (int i = 0; i < 9; i++) {
            if(board[i][c] == num){
                return false;
            }
        }
        return true;
    }
    static boolean checkBox(int point, int num){
        int r = list.get(point)[0];
        int c = list.get(point)[1];

        // 위치 체크

        int staticR = r / 3;
        int staticC = c / 3;

        for (int i = staticR*3; i <  staticR*3 + 3; i++) {
            for (int j = staticC*3; j < staticC*3 + 3; j++) {
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
