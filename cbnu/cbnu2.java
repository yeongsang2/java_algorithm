import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cbnu2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String answer = str.toUpperCase();
        System.out.println(answer);

    }
}
