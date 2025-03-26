
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Loc implements Comparable<Loc>  {
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Loc o){
            return this.r - o.r;
        }
    }
    static Loc[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new Loc[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Loc(r, c);
        }

        int maxSize = 0;
        for(Loc loc1 : arr){
            for(Loc loc2 : arr){
                maxSize = Math.max(maxSize, search(loc1.r, loc2.c, l));
            }
        }
        System.out.println(k - maxSize);
    }

    static int search(int r, int c, int l){

        int cnt = 0;
        for(Loc loc : arr){
            if(loc.r >= r && loc.r <= r + l && loc.c >= c && loc.c <=  c + l){
                cnt++;
            }
        }
        return cnt;
    }
}
