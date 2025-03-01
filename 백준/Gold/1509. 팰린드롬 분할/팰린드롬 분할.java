
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        boolean[][] isPalindrome = new boolean[str.length() + 1][str.length() + 1];

        for (int i = 1; i < chars.length + 1; i++) {
            for (int j = i; j < chars.length + 1; j++) {
                boolean flag = true;
                int start = i -1 ;
                int end = j - 1 ;
                while (start <= end){
                    if(chars[start++] != chars[end--]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    isPalindrome[i][j] = true;
                }
            }
        }

        int[] dp = new int[chars.length + 1];
        Arrays.fill(dp, 25001);
        dp[0] = 0;
        for (int i = 1; i < chars.length + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if(isPalindrome[j][i]){
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        System.out.println(dp[chars.length]);

    }
}
