
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            int num =  Integer.parseInt(st.nextToken());

            // 현재 값이 lastIndex의 값보다 크면
            if(num > list.get(lastIndex) ){
                list.add(num);
                lastIndex++;
            }else{
                // 대치할 값 찾기
                int left = 0;
                int right = list.size() - 1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) < num){ // 현재값보다 작음
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }

                list.set(left, num);
            }
        }
        System.out.println(list.size());
    }
}
