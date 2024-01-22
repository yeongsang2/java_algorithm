package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16508 {

    static String t;
    static int n;

    static class Book implements Comparable<Book> {
        int price;
        String name;
        public Book(int price, String name){
            this.price = price;
            this.name = name;
        }
        @Override
        public int compareTo(Book o) {
            return this.price - o.price;
        }
    }
    static List<Book> list= new ArrayList<>();
    static int[] bit;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = br.readLine().toLowerCase();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String name =  st.nextToken().toLowerCase();
            list.add(new Book(price, name));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            Book book = list.get(i);
            initBit();
            for (int r = 0; r < book.name.length(); r++) {
                char c = book.name.charAt(r);
                if(bit[c-'a'] > 0){
                    bit[c-'a']--;
                }
            }
            search(i+1,book.price);
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(answer);

        }
    }

    private static void initBit() {

        bit = new int[26];
        for (int i = 0; i < t.length() ;i++) {
            Character c = t.charAt(i);
            bit[c-'a']++;
        }
    }

    static void search(int idx, int nowPrice){

        if(isFinished()){ //끝
            answer = Math.min(answer, nowPrice);
            return;
        }

        for (int i = idx; i < n; i++) {
            Book book = list.get(i);
            List<Character> tempList = new ArrayList<>();
            for (int r = 0; r < book.name.length(); r++) {
                char c = book.name.charAt(r);
                if(bit[c-'a'] > 0){
                    tempList.add(c);
                    bit[c-'a']--;
                }
            }
            int np = nowPrice + book.price;
            search(i+1,np);
            for (Character c: tempList) {
                bit[c-'a']++;
            }

        }

    }

    private static boolean isFinished() {

        for (int i = 0; i < 26; i++) {
            if(bit[i] > 0){
                return false;
            }
        }
        return true;
    }
}
