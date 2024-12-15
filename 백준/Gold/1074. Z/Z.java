
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0,0,0,1};
    static int[] dc = {0,1,1,1};
    static int r = 0;
    static int c = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);

        // 어느 사분면에 있는지 찾기
        search(size, r, c);
        System.out.println(count);
    }
    static void search(int size, int r, int c){

        if(size == 1){
            return;
        }

        // 1사분면
        if( r < size/2 && c < size/2 ){
            search(size/2, r,c);
        }else if( r < size/2 && c >= size/2 ){ // 2사분면
            count += (size/2) * (size/2);
            search(size/2, r,c-size/2);
        }else if( r >= size/2 && c < size/2){ //3사분면
            count +=  ( (size/2) * (size/2) )*2;
            search(size/2, r-size/2,c);
        }else{
            count +=  ( (size/2) * (size/2) )*3;
            search(size/2, r-size/2,c-size/2);
        }

    }
}
