
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] array = br.readLine().toCharArray();

        int answer =0;
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            if(array[i-1] == 'I' && array[i] == 'O' && array[i+1] == 'I'){
                //일치
                count++;
                if(count == n){
                    answer++;
                    count--;
                }
                i++;
            }else{
                count=0;
            }
        }
        System.out.println(answer);

    }
}
