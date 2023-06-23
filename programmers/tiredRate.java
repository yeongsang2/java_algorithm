package programmers;

public class tiredRate {
    public static void main(String[] args) {
//        solution();
    }
    public static int answer = -1;
    public static boolean[] check;
    public static int solution(int k, int[][] dungeons) {

        check = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;

    }
    public static void dfs(int[][] dungeons, int nowTired, int depth){

        answer = Math.max(answer, depth);
        for(int i = 0; i< dungeons.length; i++){
            int minTired = dungeons[i][0];
            int useTired = dungeons[i][1];

            if( minTired > nowTired) continue;
            if(!check[i]){
                check[i] = true;
                dfs(dungeons, nowTired - useTired,depth+1);
                check[i] = false;
            }
        }

    }
}
