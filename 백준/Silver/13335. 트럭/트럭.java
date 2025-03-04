
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Truck{
        int weight;
        int time;
        public Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭수
        int w = Integer.parseInt(st.nextToken()); // 길이
        int l = Integer.parseInt(st.nextToken()); // 최대하중

        int[] truckArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckArr[i] = Integer.parseInt(st.nextToken());
        }

        int pointer = 0;
        int time = 0;
        int nowSum = 0;
        Queue<Truck> queue = new LinkedList<>();
        while(true){
            if(pointer == n && queue.isEmpty())break;
            time++;
            if(queue.isEmpty() && pointer < n){
                queue.add(new Truck(truckArr[pointer], w));
                nowSum += truckArr[pointer];
                pointer++;
            }else{
                if(pointer < n && nowSum + truckArr[pointer] <= l){
                    queue.add(new Truck(truckArr[pointer], w));
                    nowSum += truckArr[pointer];
                    pointer++;
                }
            }

            for(Truck truck : queue){
                truck.time--;
            }
            if(queue.peek().time == 0){
                Truck poll = queue.poll();
                nowSum -= poll.weight;
            }
        }
        System.out.println(time + 1);
    }
}
