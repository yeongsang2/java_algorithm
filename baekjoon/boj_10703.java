package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10703 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] maxIdxArr = new int[s];
        char[][] map = new char[r][s];

        for (int i = 0; i < maxIdxArr.length; i++) {
            maxIdxArr[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < s; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '#'){
                    maxIdxArr[j] = Math.min(maxIdxArr[j], i);
                }
            }
        }

        int minValue = 9999;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                if(map[i][j]=='X'){
                    minValue = Math.min(minValue, maxIdxArr[j] - i);
                }
            }
        }

        minValue--;
        for (int i = r-1; i >= 0; i--) {
            for (int j = 0; j < s; j++) {
                if(map[i][j]=='X'){
//                    String temp = map[i+minValue][j];
                    map[i+minValue][j] = 'X';
                    map[i][j] = '.';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
