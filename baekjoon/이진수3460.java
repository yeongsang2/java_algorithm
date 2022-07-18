package baekjoon;

import java.util.*;

public class 이진수3460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i< t; i++){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            String binaryString = Integer.toBinaryString(n);
            for(int j =0 ; j < binaryString.length(); j ++){
                int numericValue = Character.getNumericValue(binaryString.charAt(j));
                list.add(numericValue);
            }
            Collections.reverse(list);
            for(int k = 0 ; k < list.size(); k++){
                if(list.get(k) == 1){
                    System.out.print(k + " ");
                }
            }
        }
    }
}
