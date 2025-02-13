
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int number;
        int time;
        int recommend;
        public Info(int number, int time){
            this.number = number;
            this.time = time;
            this.recommend = 1;
        }

        @Override
        public int compareTo(Info o) {

            if(this.recommend != o.recommend){
                return this.recommend - o.recommend;
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean flag = false;
            for(Info info : list){
                if(info.number == num){
                    flag = true;
                    info.recommend++;
                }
            }
            Collections.sort(list);
            if(!flag && list.size() >= n){
                list.remove(0);
                list.add(new Info(num, i));
            }
            if(!flag && list.size() < n){
                list.add(new Info(num, i));
            }
        }
        List<Integer> answer = new ArrayList<>();
//        int[] answer = new int[n];

        for(Info info : list){
            answer.add(info.number);
        }
        Collections.sort(answer);
        for(Integer in : answer){
            System.out.println(in);
        }

    }
}
