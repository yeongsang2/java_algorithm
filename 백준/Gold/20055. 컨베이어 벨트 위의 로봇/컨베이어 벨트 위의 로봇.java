
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Belt {
        int idx;
        boolean isRobot;
        public Belt(int idx) {
            this.idx = idx;
            this.isRobot = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[2 * n];
        int size = 2 * n;
        st = new StringTokenizer(br.readLine());
        Belt[] beltArr = new Belt[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            beltArr[i] = new Belt(i);
        }

        int step = 0;

        while (true) {
            step++;

            // 1. 벨트 회전
            Belt lastBelt = beltArr[size - 1];
            for (int i = size - 1; i > 0; i--) {
                beltArr[i] = beltArr[i - 1];
            }
            beltArr[0] = lastBelt;

            // 내리는 위치(n-1)에 도착한 로봇은 제거
            if (beltArr[n - 1].isRobot) {
                beltArr[n - 1].isRobot = false;
            }

            // 2. 로봇 이동
            for (int i = n - 2; i >= 0; i--) {  // 먼저 올라간 로봇부터 이동
                if (beltArr[i].isRobot && !beltArr[i + 1].isRobot && arr[beltArr[i + 1].idx] > 0) {
                    beltArr[i].isRobot = false;
                    beltArr[i + 1].isRobot = true;
                    arr[beltArr[i + 1].idx]--;
                }
            }

            // 내리는 위치(n-1)에 도착한 로봇은 제거
            if (beltArr[n - 1].isRobot) {
                beltArr[n - 1].isRobot = false;
            }

            // 3. 로봇 올리기
            if (arr[beltArr[0].idx] > 0) {
                beltArr[0].isRobot = true;
                arr[beltArr[0].idx]--;
            }

            // 4. 내구도 0 개수 카운팅
            int cnt = 0;
            for (int durability : arr) {
                if (durability == 0) cnt++;
            }

            if (cnt >= k) break;
        }

        System.out.println(step);
    }
}
