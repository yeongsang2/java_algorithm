package programmers;

public class KeyPad {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // row column
        int[][] map = {
                {3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}
        };
        int[] locL = {3,0};
        int[] locR = {3,2};
        for(int n : numbers){
            if( n == 1 || n==4 || n ==7){
                locL[0] = map[n][0];
                locL[1] = map[n][1];
                sb.append("L");
            }else if( n==3 || n ==6 || n== 9){
                locR[0] = map[n][0];
                locR[1] = map[n][1];
                sb.append("R");
            }else{
                //거리
                int distanceL = getDistance(locL[0], locL[1], map[n][0], map[n][1]);
                int distanceR = getDistance(locR[0], locR[1], map[n][0], map[n][1]);

                //왼손이 더 가까울떄
                if(distanceL < distanceR){
                    locL[0] = map[n][0];
                    locL[1] = map[n][1];
                    sb.append("L");
                    continue;
                }
                if(distanceL > distanceR){
                    locR[0] = map[n][0];
                    locR[1] = map[n][1];
                    sb.append("R");
                    continue;
                }
                if(distanceL == distanceR){
                    if(hand.equals("left")){
                        locL[0] = map[n][0];
                        locL[1] = map[n][1];
                        sb.append("L");
                        continue;
                    }
                    if(hand.equals("right")){
                        locR[0] = map[n][0];
                        locR[1] = map[n][1];
                        sb.append("R");
                    }
                }
            }
        }
        return sb.toString();
    }
    public static int getDistance(int x, int y, int x1, int y1) {
        int d;
        d = Math.abs(x -x1) + Math.abs(y - y1);
        return d;
    }
}
