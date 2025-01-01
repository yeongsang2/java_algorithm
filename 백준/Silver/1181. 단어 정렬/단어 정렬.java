import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        };
        String[] strArr = new String[n];
//        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            strArr[i] = temp;
        }
        Arrays.sort(strArr, comparator);
        System.out.println(strArr[0]);
        for (int i = 1; i < strArr.length ; i++) {
            if(!strArr[i-1].equals(strArr[i])){
                System.out.println(strArr[i]);
            }
        }
    }
}
