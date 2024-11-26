package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18258 {

    static class MyQueue{
        Deque<Integer> list;
        
        public MyQueue(){
            list = new LinkedList<>();
        }

        public void push(int num){
            this.list.addLast(num);
        }

        public void pop() {
            if(this.list.isEmpty()){
                System.out.println("-1");
                return;
            }
            System.out.println(this.list.pop());
        }

        public void size(){
            System.out.println(this.list.size());
        }

        public void empty(){
            if(this.list.isEmpty()){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

        public void front(){
            if(this.list.isEmpty()){
                System.out.println("-1");
                return;
            }
            System.out.println(this.list.getFirst());
        }

        public void back(){
            if(this.list.isEmpty()){
                System.out.println("-1");
                return;
            }
            System.out.println(this.list.getLast());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        MyQueue myQueue = new MyQueue();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push") ){
                myQueue.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                myQueue.pop();
            } else if (command.equals("size")){
                myQueue.size();
            } else if (command.equals("empty")) {
                myQueue.empty();
            } else if (command.equals("front")){
                myQueue.front();
            } else if (command.equals("back")){
                myQueue.back();
            }

        }


    }
}
