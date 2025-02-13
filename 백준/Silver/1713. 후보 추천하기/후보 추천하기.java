import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Info implements Comparable<Info> {
        int number;
        int time;
        int recommend;
        
        public Info(int number, int time) {
            this.number = number;
            this.time = time;
            this.recommend = 1;
        }

        @Override
        public int compareTo(Info o) {
            if(this.recommend != o.recommend) {
                return this.recommend - o.recommend;
            }
            return this.time - o.time;  // 시간이 작은(오래된) 것이 우선
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<Info> photos = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int time = 0; time < m; time++) {
            int num = Integer.parseInt(st.nextToken());
            boolean exist = false;
            
            // 이미 있는 학생인지 확인
            for (Info info : photos) {
                if (info.number == num) {
                    info.recommend++;
                    exist = true;
                    break;
                }
            }
            
            // 새로운 학생을 추가해야 하는 경우
            if (!exist) {
                if (photos.size() >= n) {
                    // 가장 적은 추천 수를 가진 학생 중 가장 오래된 학생 제거
                    Collections.sort(photos);
                    photos.remove(0);
                }
                photos.add(new Info(num, time));
            }
        }
        
        // 결과 출력
        List<Integer> result = new ArrayList<>();
        for (Info info : photos) {
            result.add(info.number);
        }
        Collections.sort(result);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}