
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[] start, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        start = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        // 1. 첫 번째 스위치를 누르지 않는 경우
        int res1 = solve(false);

        // 2. 첫 번째 스위치를 누르는 경우
        int res2 = solve(true);

        // 최소 횟수 출력 (둘 다 -1이면 -1 출력)
        if (res1 == -1 && res2 == -1) {
            System.out.println(-1);
        } else if (res1 == -1) {
            System.out.println(res2);
        } else if (res2 == -1) {
            System.out.println(res1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    private static int solve(boolean pressFirst) {
        char[] temp = start.clone();
        int count = 0;

        // 첫 번째 스위치를 눌렀다면 상태 변경
        if (pressFirst) {
            flip(temp, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            // 이전 전구가 목표 상태와 다르면 현재 스위치를 눌러야 함
            if (temp[i - 1] != target[i - 1]) {
                flip(temp, i);
                count++;
            }
        }

        // 마지막 상태가 목표 상태와 같은지 확인
        if (new String(temp).equals(new String(target))) {
            return count;
        }
        return -1;
    }

    private static void flip(char[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }
}
