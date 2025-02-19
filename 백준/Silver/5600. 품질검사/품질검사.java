
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] checked = new int[a + b + c + 1];
        Arrays.fill(checked, 2);
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        while (n-- > 0){

            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(r == 1){
                checked[i] = 1;
                checked[j] = 1;
                checked[k] = 1;
            }else{
                list.add(new int[]{i,j,k});
            }
        }

        for(int[] stuff: list){
            int temp = 0;
            for(int test : stuff){
                if(checked[test] == 1){
                    temp++;
                }
            }
            if(temp == 2){
                for(int test : stuff){
                    if(checked[test] == 2){
                        checked[test] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < checked.length; i++) {
            System.out.println(checked[i]);
        }


    }
}
