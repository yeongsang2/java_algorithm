import java.util.*;

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class cbnu5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] board = new int[N + 1][M + 1];

        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

        int horseRow = scanner.nextInt();
        int horseCol = scanner.nextInt();
        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(horseRow, horseCol));
        board[horseRow][horseCol] = 1;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int currentRow = current.row;
            int currentCol = current.col;

            if (currentRow == targetRow && currentCol == targetCol) {
                System.out.println(board[currentRow][currentCol] - 1);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nextRow = currentRow + dr[i];
                int nextCol = currentCol + dc[i];
                if (nextRow >= 1 && nextRow <= N && nextCol >= 1 && nextCol <= M && board[nextRow][nextCol] == 0) {
                    board[nextRow][nextCol] = board[currentRow][currentCol] + 1;
                    queue.offer(new Position(nextRow, nextCol));
                }
            }
        }
    }
}

