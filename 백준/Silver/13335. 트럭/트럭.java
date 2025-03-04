
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중

        int[] truckArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckArr[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        int nowSum = 0;
        int pointer = 0;
        int[] bridge = new int[w];  // 다리 위 상태를 배열로 관리
        int bridgeIndex = 0;

        while (pointer < n || nowSum > 0) {
            time++;

            // 다리에서 트럭이 나감
            nowSum -= bridge[bridgeIndex];
            bridge[bridgeIndex] = 0;  // 나간 자리 초기화

            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (pointer < n && nowSum + truckArr[pointer] <= l) {
                bridge[bridgeIndex] = truckArr[pointer];
                nowSum += truckArr[pointer];
                pointer++;
            }

            // 다음 위치로 이동 (원형 큐처럼 동작)
            bridgeIndex = (bridgeIndex + 1) % w;
        }

        System.out.println(time);
    }
}
