
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String player = br.readLine();
            set.add(player);
        }

        int answer = 0;
        if(game.equals("Y")){
            answer = set.size();
        }else if(game.equals("F")){
            answer = (set.size()) / 2;
        }else{
            answer = (set.size()) / 3;
        }

        System.out.println(answer);

    }
}
