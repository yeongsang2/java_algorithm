
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int s = 0;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){ //해당 집합의 원소를 up
                int val = Integer.parseInt(st.nextToken());
                s = s | ( 1 << val );
            }else if(command.equals("remove")){
                int val = Integer.parseInt(st.nextToken());
                s = s & ~(1 << val);
            }else if(command.equals("check")){
                int val = Integer.parseInt(st.nextToken());
                if( (s & ( 1 << val)) == 0){
                    sb.append("0" + "\n");
                }else{
                    sb.append("1" + "\n");
                }
            }else if(command.equals("toggle")){
                int val = Integer.parseInt(st.nextToken());
                s = s^(1 << val);
            }else if(command.equals("all")){
                s = ( 1 << 21 ) -1;
            }else{ // empty
                s = 0;
            }
        }
        System.out.println(sb.toString());

    }
}
