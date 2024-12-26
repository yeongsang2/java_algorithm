
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] col;  // col[i]: i번째 행에서 퀸이 놓인 열 위치
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];

        backtrack(0);
        System.out.println(answer);
    }

    // row번째 행에 퀸을 놓는 시도
    static void backtrack(int row) {
        if (row == N) {  // 모든 행에 퀸을 놓았다면
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {  // 현재 행의 각 열에 퀸을 놓아봄
            col[row] = i;
            if (isPossible(row)) {  // 해당 위치가 가능하다면
                backtrack(row + 1);  // 다음 행으로 진행
            }
        }
    }

    // 현재 위치가 가능한지 체크
    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있거나
            if (col[i] == col[row]) {
                return false;
            }
            // 대각선에 있는 경우
            if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
