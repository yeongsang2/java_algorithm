import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String command = br.readLine();
            int length = Integer.parseInt(br.readLine());
            String s = br.readLine();
//            if (s.equals("[]")){
//                System.out.println("error");
//            }else {
//                String str = s.substring(1, s.length() - 1)
                String[] arr = s.substring(1, s.length() - 1).split(",");
//                System.out.println("length:" + arr.length);

                Deque<Integer> deque = new LinkedList<>();
//                System.out.println("first" + arr[0]);

                if(s.length() > 2){
                    for (int j = 0; j < arr.length; j++) {
                        if(arr[j] != null){
                            deque.add(Integer.parseInt(arr[j]));
                        }
                    }
                }

                boolean check = false;
                boolean leftStart = true;
                for (int j = 0; j < command.length(); j++) {
                    char c = command.charAt(j);
                    if (c == 'R') { //reverse
                        leftStart = !leftStart;
                    } else {
                        if (deque.size() == 0) {
                            check = true;
                            break;
                        }
                        if(leftStart){
//                            System.out.println(deque.pollFirst());
                            deque.pollFirst();
                        }else{
                            deque.pollLast();
                        }
                    }
                }


                StringBuilder sb = new StringBuilder();
                if (!check) {
                    sb.append("[");
                    int size = deque.size();
//                    System.out.println("size: "+ size);
                    if(leftStart){
                        for (int j = 0; j < size; j++) {
                            sb.append(deque.pollFirst()).append(",");
                        }
                    }else{
                        for (int j = 0; j < size; j++) {
                            sb.append(deque.pollLast()).append(",");
                        }
                    }
                    if(sb.length() > 1){
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append("]");
                    }else{
                        sb.append("]");
                    }
                } else {
                    sb.append("error");
                }
                System.out.println(sb);
            }
//        }

    }
}
