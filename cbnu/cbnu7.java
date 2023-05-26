package cbnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cbnu7 {
    public static int r;
    public static int c;
    public static int w;
    public static int h;
    public static int fw;
    public static int fh;



    public static String [][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                String str = st.nextToken();
                if(str == "S"){
                    w=i;
                    h=j;
                }
                if(str == "*"){
                    fw = i;
                    fh = j;
                }
                map[r][c] = st.nextToken();
            }
        }
        //요새 D
        // 불 *
        // 바위 X

    }
}
