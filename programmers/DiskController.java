package programmers;

import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행 후 시간
        int jobsIdx= 0; // job 배열 인ㄷ게스
        int count = 0; //수행된 요청 갯수
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]); //오름차순 0보다 작을경우 a가 앞, 클경우 b가 앞

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 작업시간의 오름차순


        while(count <  jobs.length){

            // 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
            while( jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                priorityQueue.add(jobs[jobsIdx++]);
            }

            if(priorityQueue.isEmpty()){
                end = jobs[jobsIdx][0];
            }else {
                int[] temp = priorityQueue.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
