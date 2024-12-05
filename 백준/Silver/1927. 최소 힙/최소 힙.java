
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {

            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(priorityQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(priorityQueue.poll());
                }
            }else{
                priorityQueue.add(num);
            }
        }

    }
}
