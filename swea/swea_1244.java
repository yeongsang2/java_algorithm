package swea;

import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1244 {

    static int exchangeNumber;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < t + 1; i++) {

            answer = -1;

            st = new StringTokenizer(br.readLine());
            String numberStr = st.nextToken();

            exchangeNumber = Integer.parseInt(st.nextToken());
            String[] numberArr = new String[numberStr.length()];

            if(exchangeNumber > numberArr.length){
                exchangeNumber = numberArr.length;
            }

            for (int j = 0; j < numberStr.length(); j++) {
                numberArr[j] = Character.toString(numberStr.charAt(j));
            }

            for (int j = 0; j < numberStr.length() - 1; j++) {
                for (int k = j + 1; k < numberStr.length(); k++) {
                    String[] newArr = new String[numberArr.length];
                    for (int l = 0; l < numberArr.length; l++) {
                        newArr[l] = numberArr[l];
                    }
                    String temp  = newArr[j];
                    newArr[j] = newArr[k];
                    newArr[k] = temp;
                    comb(newArr, 1);
                }
            }
            // 조합?
            sb.append("#").append(Integer.toString(i)).append(" ").append(Integer.toString(answer));
            sb.append("\n");
            //            System.out.println("#"+ Integer.toString(i) + " " + Integer.toString(answer));
        }
        System.out.println(sb.toString());
    }
    static void comb(String[] newArr, int cnt){



        if(cnt == exchangeNumber){
            String temp = "";
            for(String s: newArr){
                temp = temp + s;
            }
            answer = Math.max(Integer.parseInt(temp), answer);
            return;
        }

        for (int j = 0; j < newArr.length - 1; j++) {
            for (int k = j + 1; k < newArr.length; k++) {
                String[] arr = new String[newArr.length];
                for (int l = 0; l < newArr.length; l++) {
                    arr[l] = newArr[l];
                }
                String temp  = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                comb(arr, cnt+1);
            }
        }
    }
    static boolean checkReverse(String[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(Integer.parseInt(arr[i]) < Integer.parseInt(arr[i+1])){
                return false;
            }
        }
        return true;
    }
}
