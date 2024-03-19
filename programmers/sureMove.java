package programmers;

public class sureMove {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}}));
    }
    static class Position{
        int r;
        int c;
        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    //동 서 남 북
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static Position pStartRed;
    static Position pStartBlue;
    static Position pEndRed;
    static Position pEndBlue;


    static boolean[][] visitedRed;
    static boolean[][] visitedBlue;

    static int sizeR;
    static int sizeC;

    static int answer = 0;

    static boolean flagRed;
    static boolean flagBlue;
    static int tempCnt;
    static int tempAnswer = Integer.MAX_VALUE;

    static public int solution(int[][] maze) {
        visitedRed = new boolean[maze.length][maze[0].length];
        visitedBlue = new boolean[maze.length][maze[0].length];

        sizeR = maze.length;
        sizeC = maze[0].length;

        for(int i =0; i < maze.length; i++){
            for(int j =0; j< maze[0].length; j++){
                if(maze[i][j] == 1){
                    pStartRed = new Position(i,j);
                }else if(maze[i][j] == 2){
                    pStartBlue = new Position(i,j);
                }else if(maze[i][j] == 3){
                    pEndRed = new Position(i,j);
                }else if(maze[i][j] == 4){
                    pEndBlue = new Position(i,j);
                }
            }
        }

        visitedRed[pStartRed.r][pStartRed.c] = true;
        visitedBlue[pStartBlue.r][pStartBlue.c] = true;
        for(int i =0; i<4 ;i++){
            int nextRedR = pStartRed.r + dr[i];
            int nextRedC = pStartRed.c + dc[i];
            for(int j = 0; j< 4; j++){
                int nextBlueR = pStartBlue.r + dr[j];
                int nextBlueC = pStartBlue.c + dc[j];
                tempCnt = Integer.MAX_VALUE;
                if( isRanged(nextRedR, nextRedC)
                        && isRanged(nextBlueR, nextBlueC)
                        && !visitedRed[nextRedR][nextRedC]
                        && !visitedBlue[nextBlueR][nextBlueC]
                        && !( (nextRedR == nextBlueR) && (nextRedC == nextBlueC) )
                        && !(  (nextRedR == pStartBlue.r) && (nextRedC == pStartBlue.c) && (nextBlueR == pStartRed.r) && (nextBlueC == pStartRed.c) )
                        && (maze[nextRedR][nextRedC] !=5)
                        && (maze[nextBlueR][nextBlueC] !=5)
                ){
                    visitedRed[nextRedR][nextRedC] = true;
                    visitedBlue[nextBlueR][nextBlueC] = true;
                    search(maze, nextRedR, nextRedC, nextBlueR, nextBlueC,1);
                    visitedRed[nextRedR][nextRedC] = false;
                    visitedBlue[nextBlueR][nextBlueC] = false;
                }
                tempAnswer = Math.min(tempCnt, tempAnswer);
            }
        }


        return tempAnswer == Integer.MAX_VALUE ? 0 : tempAnswer;
    }

    static public void search(int[][] maze, int redR, int redC, int blueR, int blueC, int count){

        if( count > tempCnt){
            return;
        }

        if( (redR == pEndRed.r && redC == pEndRed.c) && (blueR == pEndBlue.r && blueC == pEndBlue.c ) ) { //finish
            tempCnt = count;
            return;
        }

        for(int i = 0; i<4 ;i++){
            int nextRedR = -1;
            int nextRedC = -1;
            int nextBlueR = -1;
            int nextBlueC = -1;
            for(int j = 0; j < 4; j++){
                nextRedR = redR + dr[i];
                nextRedC = redC + dc[i];
                nextBlueR = blueR + dr[j];
                nextBlueC = blueC + dc[j];
                if( (redR == pEndRed.r) && (redC == pEndRed.c) ){
                    nextRedR = redR;
                    nextRedC = redC;
                    if( isRanged(nextRedR, nextRedC) && isRanged(nextBlueR, nextBlueC)
                            && !visitedBlue[nextBlueR][nextBlueC]
                            && !( ( (nextRedR == nextBlueR) && (nextRedC == nextBlueC) ) )
                            && !(  (nextRedR == blueR) && (nextRedC == blueC) && (nextBlueR == redR) && (nextBlueC == redC) )
                            && (maze[nextRedR][nextRedC] !=5)
                            && (maze[nextBlueR][nextBlueC] !=5)
                    ){
                        visitedRed[nextRedR][nextRedC] = true;
                        visitedBlue[nextBlueR][nextBlueC] = true;
                        search(maze, nextRedR, nextRedC, nextBlueR, nextBlueC, count+1);
                        visitedRed[nextRedR][nextRedC] = false;
                        visitedBlue[nextBlueR][nextBlueC] = false;
                        // flagRed = false;
                        // flagBlue = false;
                    }
                }else if ( (blueR == pEndBlue.r) && (blueC == pEndBlue.c) ) {
                    nextBlueR = blueR;
                    nextBlueC = blueC;
                    if( isRanged(nextRedR, nextRedC) && isRanged(nextBlueR, nextBlueC)
                            && !visitedRed[nextRedR][nextRedC]
                            && !( ( (nextRedR == nextBlueR) && (nextRedC == nextBlueC) ) )
                            && !(  (nextRedR == blueR) && (nextRedC == blueC) && (nextBlueR == redR) && (nextBlueC == redC) )
                            && (maze[nextRedR][nextRedC] !=5)
                            && (maze[nextBlueR][nextBlueC] !=5)
                    ){
                        visitedRed[nextRedR][nextRedC] = true;
                        visitedBlue[nextBlueR][nextBlueC] = true;
                        search(maze, nextRedR, nextRedC, nextBlueR, nextBlueC, count+1);
                        visitedRed[nextRedR][nextRedC] = false;
                        visitedBlue[nextBlueR][nextBlueC] = false;
                    }
                }else{
                    if( isRanged(nextRedR, nextRedC) && isRanged(nextBlueR, nextBlueC)
                            && !visitedRed[nextRedR][nextRedC]
                            && !visitedBlue[nextBlueR][nextBlueC]
                            && !( ( (nextRedR == nextBlueR) && (nextRedC == nextBlueC) ) )
                            && !(  (nextRedR == blueR) && (nextRedC == blueC) && (nextBlueR == redR) && (nextBlueC == redC) )
                            && (maze[nextRedR][nextRedC] !=5)
                            && (maze[nextBlueR][nextBlueC] !=5)
                    ){
                        visitedRed[nextRedR][nextRedC] = true;
                        visitedBlue[nextBlueR][nextBlueC] = true;
                        search(maze, nextRedR, nextRedC, nextBlueR, nextBlueC, count+1);
                        visitedRed[nextRedR][nextRedC] = false;
                        visitedBlue[nextBlueR][nextBlueC] = false;
                    }
                }
            }
        }
    }

    static public boolean isRanged(int r, int c){
        if(r >= 0 && r < sizeR &&  c >=0 && c < sizeC ){
            return true;
        }
        return false;
    }
}
