
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n + 1][n + 1];
        boolean flag = false;

        int heartR = 0;
        int heartC = 0;

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            for (int j = 1; j < n + 1; j++) {
                char c = str.charAt(j - 1);
                arr[i][j] = c;
                if(!flag && c == '*'){
                    heartR = i + 1;
                    heartC = j;
                    flag = true;
                }
            }
        }

        // 왼쪽팔길이
        int leftArmLength = 0;
        int tempJ = heartC - 1;
        while(tempJ >= 0 && arr[heartR][tempJ] == '*'){
            leftArmLength++;
            tempJ--;
        }

        int rightArmLength = 0;
        tempJ = heartC + 1;
        while(tempJ < n + 1 && arr[heartR][tempJ] == '*'){
            rightArmLength++;
            tempJ++;
        }

        // 몸통위치
        int bodyR = heartR;
        int bodyC = heartC;
        while(arr[bodyR + 1][bodyC] == '*'){
            bodyR++;
        }

        int bodyLength = bodyR - heartR;


        // 왼쪽다리
        int leftLeglength = 0;
        int tempR = bodyR + 1;
        int tempC = bodyC - 1;
        while(tempR < n + 1 && arr[tempR][tempC] == '*'){
            tempR++;
            leftLeglength++;
        }

        int rightLeglength = 0;
        tempR = bodyR + 1;
        tempC = bodyC + 1;
        while(tempR < n + 1 && arr[tempR][tempC] == '*'){
            tempR++;
            rightLeglength++;
        }

        System.out.println(heartR + " " + heartC);
        System.out.println(leftArmLength + " " + rightArmLength + " " + bodyLength + " " +  leftLeglength + " " + rightLeglength);

    }
}
