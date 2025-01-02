import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n =  Integer.parseInt(br.readLine());
        int[] arrA = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }


        int pointA = 0;
        int pointB = 0;
        int maxNum = 0;
        List<Integer> list = new LinkedList<>();
        while (pointA < n && pointB < m){
            maxNum = 0;
            for (int i = pointA; i < n; i++) {
                for (int j = pointB; j < m; j++) {
                    if(arrA[i] == arrB[j] && maxNum < arrA[i]){
                        maxNum = arrA[i];
                    }
                }
            }
            if(maxNum != 0){
                list.add(maxNum);
                while (arrA[pointA] != maxNum) pointA++;
                while (arrB[pointB] != maxNum) pointB++;
                pointA++;
                pointB++;
            }else{
                break;
            }
        }

        System.out.println(list.size());
        for(Integer i : list){
            System.out.print(i + " ");
        }


    }
}
