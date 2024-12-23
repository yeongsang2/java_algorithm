
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        if(truthNum > 0){
            List<Integer> truthList = new LinkedList<>();

            for (int i = 0; i < truthNum; i++) {
                truthList.add(Integer.parseInt(st.nextToken()));
            }

            List<List<Integer>> graph = new LinkedList<>();

            for (int i = 0; i < n+1; i++) {
                graph.add(new LinkedList<>());
            }

            List<List<Integer>> partyList = new LinkedList<>();

            for (int i = 0; i < m; i++) { // 파티 개수 시작
                partyList.add(new LinkedList<>());

                st = new StringTokenizer(br.readLine());
                int participantNum = Integer.parseInt(st.nextToken());
                if(participantNum > 1){
                    List<Integer> tempList = new LinkedList<>();
                    for (int j = 0; j < participantNum; j++) {
                        int peopleNum = Integer.parseInt(st.nextToken());
                        tempList.add(peopleNum);
                        partyList.get(i).add(peopleNum);
                    }

                    for (int j = 0; j < participantNum; j++) {
                        for (int k = 0; k < participantNum; k++) {
                            if(j==k) continue;
                            int a = tempList.get(j);
                            int b = tempList.get(k);
                            graph.get(a).add(b);
                            graph.get(b).add(a);
                        }
                    }
                }else{
                    partyList.get(i).add(Integer.parseInt(st.nextToken()));
                }
            }

            boolean[] answer = new boolean[n+1];
            boolean[] checked = new boolean[n+1];

            for(Integer truth : truthList){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(truth);
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();
                    answer[poll] = true;
                    for(Integer people : graph.get(poll)){
                            if(!checked[people]){
                            checked[people]= true;
                            queue.add(people);
                        }
                    }
                }
            }

//            for (int i = 1; i < answer.length; i++) {
//                System.out.print(answer[i] + " ");
//            }
//            System.out.println();

            int cnt = 0;


            for (int i = 0; i < partyList.size(); i++) {
                    List<Integer> pList = partyList.get(i);
                    boolean flag = false;
                    for(Integer a1 :pList){
                        if(answer[a1]){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) {
//                        System.out.println(i);
                        cnt++;
                    }
            }
            System.out.println(cnt);

            // 꼬리를 쫙 만들기
        }else{
            System.out.println(m);
            return;
        }


    }
}
