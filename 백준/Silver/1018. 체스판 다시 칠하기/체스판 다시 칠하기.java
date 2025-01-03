import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; n - i > 7; i++) {
            for (int j = 0; m - j > 7; j++) {
                int temp = 0;
                char color = arr[i][j];
//                System.out.println(color);
//                System.out.println("i: " + i + " , j:" +  j);
                int maxI = i + 8;
                int maxJ = j + 8;
                for (int k = i; k < maxI ; k++) {
                    for (int l = j; l < maxJ; l++) {
                        if(arr[k][l] != color){
                            temp++;
                        }
                        if(color == 'B'){
                            color = 'W';
                        }else if(color == 'W'){
                            color = 'B';
                        }
                    }
                    if(color == 'B'){
                        color = 'W';
                    }else if(color == 'W'){
                        color = 'B';
                    }
                }
                temp = Math.min(temp, 64 - temp);
                answer = Math.min(answer, temp);
            }
        }
        System.out.println(answer);


    }
}
