
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'w');
        map.put(1, 'o');
        map.put(2, 'l');
        map.put(3, 'f');

        if(str.charAt(0) != map.get(0) || str.length() < 4){
            System.out.println(0);
            return;
        }

        int n = 0;
        int point = 0;
        int cnt = 0;
        for(int i = 0 ; i < str.length(); i++){
            char c = str.charAt(i);
           if( map.get(point) == c ){
               if( c == 'w' ) {
                   cnt++;
                   n++;
               }else{
                   cnt++;
               }

               if(cnt > n){
                   System.out.println(0);
                   return;
               }
           }else{
               if(map.get((point + 1) % 4) == c){
                   if( cnt < n ){
                       System.out.println(0);
                       return;
                   }
                   cnt = 1;
                   point = (point + 1) % 4;
                   if( point == 0 ){
                       n = 1;
                   }
               }else{
                   System.out.println(0);
                   return;
               }
           }
        }
        if(point != 3 || cnt < n) {
            System.out.println(0);
        }else{
            System.out.println(1);
        }


    }
}
   