package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class boj_16719 {
    static int length;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        length = str.length();
        String best = "";
        Character min = 'Z';
        List<Integer> list = new LinkedList();
        int pos = 0;

        for(int i = 0; i < str.length(); ++i) {
            Character temp = str.charAt(i);
            if (temp < min) {
                min = temp;
                pos = i;
            }
        }

        best = Character.toString(min);
        list.add(pos);

        System.out.println(best);
        recur(best, 1, list);
    }

    static void recur(String nowStr, int cnt, List<Integer> list) {
        if (cnt == length) {
            return;
        }

        String best = "";
        int idx = 0;
        for(int i = 0; i < length; ++i) {
            if (!list.contains(i)) {
                String tempString = getString(list, i);

                if (best.length() == 0) {
                    best = tempString;
                    idx = i;
                } else {
                    if(best.compareTo(tempString) >= 1){
                        best = tempString;
                        idx = i;
                    }
                }
            }
        }

        list.add(idx);
        System.out.println(best);
        recur(best, cnt + 1, list);
    }

    static String getString(List<Integer> list, int pos) {

        LinkedList<Integer> tempList = new LinkedList<>(list);
        tempList.add(pos);
        Collections.sort(tempList);

        StringBuilder sb = new StringBuilder();

        for(int i : tempList) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}

