
import java.io.*;
import java.util.*;

public class Main {

    static class Word{
        int cnt;
        String value;
    }
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            String value = br.readLine();
            if(value.length() < m) continue;
            map.put(value, map.getOrDefault(value, 0) + 1);
//            if(!list.contains(value)){
//                list.add(value);
//            }
        }
//        Set<String> set = new HashSet<>();

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String> () {
            @Override
            public int compare(String o1, String o2){

                int cnt1 = map.get(o1);
                int cnt2 = map.get(o2);

                if(cnt1 != cnt2){
                    return map.get(o2) - map.get(o1);
                }
                if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String s : list){
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();

    }
}
