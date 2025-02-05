import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        // 웅덩이 표시
        for(int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        
        // 시작점 설정
        map[0][0] = 1;
        
        // 첫 행 초기화
        for(int j = 1; j < m; j++) {
            if(map[0][j] == -1) {
                map[0][j] = 0;
                // 이후의 모든 칸도 도달 불가능
                for(int k = j+1; k < m; k++) {
                    map[0][k] = 0;
                }
                break;
            }
            map[0][j] = map[0][j-1];
        }
        
        // 첫 열 초기화
        for(int i = 1; i < n; i++) {
            if(map[i][0] == -1) {
                map[i][0] = 0;
                // 이후의 모든 칸도 도달 불가능
                for(int k = i+1; k < n; k++) {
                    map[k][0] = 0;
                }
                break;
            }
            map[i][0] = map[i-1][0];
        }
        
        // 나머지 칸들 처리
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                int up = map[i-1][j];
                int left = map[i][j-1];
                map[i][j] = ((up < 0 ? 0 : up) + (left < 0 ? 0 : left)) % 1000000007;
            }
        }
        
        return map[n-1][m-1];
    }
}