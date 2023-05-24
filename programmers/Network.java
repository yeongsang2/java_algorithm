package programmers;

public class Network {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1} }));
    }

    public static int[][] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[computers.length][computers.length];

        // 초기화
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                visited[i][j] =0;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if(visited[i][j] == 0 && i == j) { //방문 x
                    visited[i][j] = 1; // 방문처리
                    dfs(computers, i);
                    answer ++;
                }
            }
        }
        return answer;
    }
    public static void dfs(int[][] computers, int node){ // row 행

        for (int i = 0; i < computers.length; i++) {
            if(computers[node][i] != 0 && visited[node][i] == 0 ){
                visited[node][i] = 1; //방문처리
                dfs(computers, i);
            }
        }
    }

}
