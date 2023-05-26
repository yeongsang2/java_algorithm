package cbnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cbnu1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n +1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 1){ //가위
                if (b == 2){
                    System.out.println("#" + i +  " B");
                }else{
                    System.out.println("#" + i +  " A");
                }
            }else if(a==2){ //바위
                if (b == 1){
                    System.out.println("#" + i +  " A");
                }else{
                    System.out.println("#" + i +  " B");
                }
            }else{ //보
                if (b == 2){
                    System.out.println("#" + i +  " A");
                }else{
                    System.out.println("#" + i +  " B");
                }
            }
        }
    }
}
