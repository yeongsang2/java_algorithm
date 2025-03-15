
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int point = 0;

        int answer = 0;
        for (int i = 1; i < 30001; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == s.charAt(point)){
                    point++;
                    if(point == s.length()){
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
    }
}
