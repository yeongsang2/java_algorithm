package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_17144 {

    static int[][] board;
    static int[][] newBoard;
    static int row;
    static int column;
    static int t;
    static int machineR1;
    static int machineR2;

    //상 하 좌 우
    static int[] dr= {-1,1,0,0};
    static int[] dc= {0,0, -1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        board =  new int[row+1][column+1];
        newBoard = new int[row+1][column+1];

        boolean flag = false;
        for (int i = 1; i < row +1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < column +1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == -1 && !flag){
                    machineR1 =  i;
                    machineR2 =  i+1;
                    flag= true;
                }
            }
        }

        while(t-- >0) {
            initNewBoard();
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < column + 1; j++) {
                    if(board[i][j] != 0 && board[i][j] != -1){
                        bfs(newBoard, i, j);
                    }
                }
            }
            copyBoard();
            circulate();

        }
        int answer =0 ;
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                answer += board[i][j];
            }
        }
        answer +=2;
        System.out.println(answer);

    }
    static void bfs(int[][] newBoard, int i, int j){

        List<int[]> list = new LinkedList<>();
        // 상 하 좌 우?
        for (int k = 0; k < 4; k++) {
            int nextR = i + dr[k];
            int nextC = j + dc[k];
            if(checkPossible(nextR, nextC)){ //확산 가능
                int[] loc = {nextR, nextC};
                list.add(loc);
            }
        }
        int spreadMount = board[i][j] / 5;
        int spreadCnt = list.size();
        for(int[] loc: list){
            newBoard[loc[0]][loc[1]] = newBoard[loc[0]][loc[1]] +spreadMount;
        }
        newBoard[i][j] = newBoard[i][j] + (board[i][j] - spreadMount*spreadCnt);
    }
    static boolean checkPossible(int r, int c){
        if( r>=1 && r<= row && c>=1 && c<= column && board[r][c] != -1){
             return true;
        }
        return false;
    }

    static void initNewBoard(){

        for (int i = 1; i < row +1; i++) {
            for (int j = 1; j < column +1; j++) {
                if( (i == machineR1 || i == machineR2) && j==1 ){
                    newBoard[i][j] = -1;
                }else {
                    newBoard[i][j] = 0;
                }
            }
        }
    }
    static void copyBoard(){
        for (int i = 1; i < row +1; i++) {
            for (int j = 1; j < column +1; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
    static void circulate(){

        //좌측
        for (int i= machineR1 -1 ; i > 1 ;i--){
            board[i][1] = board[i-1][1];
        }
        //맨위
        for(int i =1 ; i < column ; i++){
            board[1][i] = board[1][i+1];
        }
        //우측
        for(int i=1 ; i< machineR1 ; i++){
            board[i][column] = board[i+1][column];
        }
        //아래
        for(int i= column ; i > 2 ;i--){
            board[machineR1][i] = board[machineR1][i-1];
        }
        board[machineR1][2] = 0;

        //좌
        for(int i = machineR2+1; i < row ;i ++){
            board[i][1] = board[i+1][1];
        }
        //아래
        for(int i=1 ; i< column ;i++){
            board[row][i] = board[row][i+1];
        }
        //우
        for(int i= row ; i > machineR2 ;i--){
            board[i][column] = board[i-1][column];
        }
        //위
        for(int i=column; i > 2; i--){
            board[machineR2][i] = board[machineR2][i-1];
        }
        board[machineR2][2] = 0;
    }
}
