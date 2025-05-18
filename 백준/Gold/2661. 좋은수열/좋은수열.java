
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {

        // 212

        // 좋은 수열의 조건
        // 이전값이랑 다름
        // 곂치는 부분수열 없음 ->
        // 12
        // 121
        // 1212
        // 1, 2
        // 12 12
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backTracking("");

    }
    public static void backTracking(String str){

        if(str.length() == n){
            // 정답
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if(isGoodPerm(str  + i)) backTracking(str + i);
        }
    }

    public static boolean isGoodPerm(String str){
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i, str.length());
            if(front.equals(back)) return false;
        }
        return true;
    }
}
