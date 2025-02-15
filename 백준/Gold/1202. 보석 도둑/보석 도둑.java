
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Stuff implements Comparable<Stuff> {
        int weight;
        int price;
        public Stuff(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Stuff o){
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Stuff[] stuffArr = new Stuff[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            stuffArr[i] = new Stuff(weight,price);
        }
        Arrays.sort(stuffArr);

        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        long answer = 0;
        int point = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            int nowBagSize = bag[i];

            while( point < n && stuffArr[point].weight <= nowBagSize){
                pq.add(stuffArr[point].price);
                point++;
            }

            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);


    }
}
