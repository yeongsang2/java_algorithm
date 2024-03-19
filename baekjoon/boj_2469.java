package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class boj_2469 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int lineIdx  = 0;

        char[] startStr = new char[k];
        for (int i = 0; i < k; i++) {
            startStr[i] = (char)('A' + i);
        }
        char[] destination = br.readLine().toCharArray();

        char[][] map = new char[n][k];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
            if(map[i][0] == '?'){
                lineIdx = i;
            }
        }

        for (int i = 0; i < lineIdx; i++) {
            for (int j = 0; j < k-1; j++) {
                if(map[i][j] == '-'){
                    char tempChar = startStr[j];
                    startStr[j] = startStr[j+1];
                    startStr[j+1] = tempChar;
                }
            }
        }

        for (int i = n-1; i > lineIdx ; i--) {
            for (int j = 0; j < k-1; j++) {
                if(map[i][j] == '-'){
                    char tempChar = destination[j];
                    destination[j] = destination[j+1];
                    destination[j+1] = tempChar;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k - 1; i++) {

            if(startStr[i] == destination[i]){
                sb.append('*');
            }

            if(startStr[i] == destination[i+1] || startStr[i+1] == destination[i] ){
                sb.append('-');
                char tmp = startStr[i];
                startStr[i] = startStr[i+1];
                startStr[i+1] = tmp;
            }else{
                sb = new StringBuilder();
                for (int j = 0; j < k - 1; j++) {
                    sb.append('x');
                }
                sb.append("");
                break;
            }
        }
        System.out.println(sb.toString());
    }

}
