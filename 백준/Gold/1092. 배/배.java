
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Integer> crainList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crainList.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
//        Integer[] boxArr = new Integer[m];
        List<Integer> boxList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crainList, Collections.reverseOrder());
        Collections.sort(boxList, Collections.reverseOrder());

        if(crainList.get(0) < boxList.get(0)) {
            System.out.println(-1);
            return;
        }

        int answer= 0;
        while (!boxList.isEmpty()){
            int idx = 0;
            for (int i = 0; i < n;) {
                if(boxList.size() == idx) break;
                else if(crainList.get(i) >= boxList.get(idx) ){
                   boxList.remove(idx);
                   i++;
               }else{
                   idx++;
               }
            }
            answer++;
        }

        System.out.println(answer);

    }
}

//10
//19 2 10 3 5 27 30 27 27 4
//20
//2 5 19 4 8 23 30 26 11 11 23 27 17 22 22 22 8 22 9 18
