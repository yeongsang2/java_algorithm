import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double sum = 0 ;
        int[] arr = new int[n];
        int[] cnt = new int[4001];

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            sum += temp;
            map.put(temp, map.getOrDefault(temp, 0) +1 );
        }

        List<Integer> list = new LinkedList<>();
//        for (int i = 1; i < 4001; i++) {
//            if( maxCnt < cnt[i] ){
//                list = new LinkedList<>();
//                list.add(i);
//            }else if (maxCnt == cnt[i]){
//                list.add(i);
//            }
//        }
        int maxCnt = 0;

        for(Integer key : map.keySet()){
            Integer value = map.get(key);
            if( maxCnt < value ){
                list = new LinkedList<>();
                maxCnt = value;
                list.add(key);
            }else if (maxCnt == value){
                list.add(key);
            }
        }

        Arrays.sort(arr);
        double average = Math.round(sum / n);
        int mid = arr[n/2];

        System.out.println((int)average);
        System.out.println(mid);
        if(list.size() > 1 ){
            System.out.println(list.get(1));
        }else{
            System.out.println(list.get(0));
        }
        System.out.println(arr[n-1] - arr[0]);
    }
}
