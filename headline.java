import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class headline {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String str = br.readLine();
        String result = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '-'){
                result += Character.toUpperCase(str.charAt(i));
            }else {
                result += str.charAt(i);
            }
        }

        System.out.println(result);
    }
}
