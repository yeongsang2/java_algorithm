import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] canMoveCount;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        canMoveCount = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = Character.getNumericValue(str.charAt(j));
                map[i][j] = num;
            }
        }

        boolean[][] checked = new boolean[n][m];

        int index = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(checked[i][j] || map[i][j] == 1) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                checked[i][j] = true;
                canMoveCount[i][j] = index;
                int count = 0;
                while (!queue.isEmpty()){
                    int[] poll = queue.poll();
                    count++;
                    for (int k = 0; k < 4; k++) {
                        int nextR = poll[0] + dr[k];
                        int nextC = poll[1] + dc[k];
                        if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && !checked[nextR][nextC] && map[nextR][nextC] == 0){
                            checked[nextR][nextC] = true;
                            canMoveCount[nextR][nextC] = index;
                            queue.add(new int[]{nextR,nextC});
                        }
                    }
                }

                hashMap.put(index, count);
                index++;
            }
        }

        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    int temp = 0;
                    boolean[] tempCheck = new boolean[hashMap.size() + 1];
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m){
                            int idx = canMoveCount[nextR][nextC];
                            if(idx !=0 && !tempCheck[idx]) {
                                tempCheck[idx] = true;
                                temp += hashMap.get(idx);
                            }
                        }
                    }

                    answer[i][j] = ( temp + 1 ) % 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
