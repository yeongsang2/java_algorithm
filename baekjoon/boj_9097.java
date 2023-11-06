    package baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class boj_9097 {

        static int board[][] = new int[3][3];
        public static void main(String[] args) throws IOException {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int t = Integer.parseInt(br.readLine());

            while(t-- > 0){

                for (int i = 0; i < 3; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < 3; j++) {
                        String s = st.nextToken();
                        if(s.equals("H")){ //앞면
                            board[i][j] = 0;
                        }else {
                            board[i][j]= 1;
                        }
                    }
                }
                System.out.println(bfs());
            }
        }
        static int bfs(){
            boolean[] checkNumber = new boolean[512];
            Queue<int[][]> queue = new LinkedList<>();

            int number = arrayToInteger(board);
            checkNumber[number] = true;
            queue.add(board);

            int cnt = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- > 0){
                    int[][] nowBoard = queue.poll();
                    if(validateBoard(nowBoard)){
                        return cnt;
                    }
                    List<int[][]> nextBoardList;
                    nextBoardList = getNextBoardList(nowBoard);
                    if(nextBoardList != null) {
                        for (int[][] nb : nextBoardList) {
                            int nbNumber = arrayToInteger(nb);
                            if (!checkNumber[nbNumber]) {
                                queue.add(nb);
                                checkNumber[nbNumber] = true;
                            }
                        }
                    }
                }
                cnt++;
            }
            return -1;
        }

        private static List<int[][]> getNextBoardList(int[][] nowBoard) {
            List<int[][]> list = new LinkedList<>();

            for (int i  = 0; i < 3; i++) {
                int[][] nextBoard = new int[3][3];
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        nextBoard[j][k] = nowBoard[j][k];
                    }
                }
                nextBoard[i][0] = ( nextBoard[i][0] + 1 ) % 2;
                nextBoard[i][1] = ( nextBoard[i][1] + 1 ) % 2;
                nextBoard[i][2] = ( nextBoard[i][2] + 1 ) % 2;
                list.add(nextBoard);
            }

            //  열 뒤집기
            for (int i = 0; i < 3; i++) {
                int[][] nextBoard = new int[3][3];
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        nextBoard[j][k] = nowBoard[j][k];
                    }
                }
                nextBoard[0][i] = ( nextBoard[0][i] + 1 ) % 2;
                nextBoard[1][i] = ( nextBoard[1][i] + 1 ) % 2;
                nextBoard[2][i] = ( nextBoard[2][i] + 1 ) % 2;
                list.add(nextBoard);
            }
            // 대각선
            int[][] tempBoard = new int[3][3];
            int[][] tempBoard2 = new int[3][3];

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    tempBoard[j][k] = nowBoard[j][k];
                    tempBoard2[j][k] = nowBoard[j][k];
                }
            }
            tempBoard[0][0] = (tempBoard[0][0] + 1) % 2;
            tempBoard[1][1] = (tempBoard[1][1] + 1) % 2;
            tempBoard[2][2] = (tempBoard[2][2] + 1) % 2;

            tempBoard2[0][2] = (tempBoard2[0][2] + 1) % 2;
            tempBoard2[1][1] = (tempBoard2[1][1] + 1) % 2;
            tempBoard2[2][0] = (tempBoard2[2][0] + 1) % 2;

            list.add(tempBoard);
            list.add(tempBoard2);
            return list;
        }

        static int arrayToInteger(int[][] board){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(Integer.toString(board[i][j]));
                }
            }
            return Integer.valueOf(sb.toString(), 2);
        }

        static boolean validateBoard(int[][] board){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j] != board[0][0]){
                        return false;
                    }
                }
            }
            return true;
        }
    }
