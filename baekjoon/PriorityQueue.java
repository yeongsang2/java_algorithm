package baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PriorityQueue {


    static class Issue{
        int year;
        String value;

        public Issue(int year, String value) {
            this.year = year;
            this.value = value;
        }
    }

    static class PQueue{
        private int size;
        private Issue[] issues = new Issue[11];

        public PQueue(int size) {
            this.size = size;
        }
    }

    public static void main(String[] args) {


        String line;
        PQueue pQueue = new PQueue(0);

        File file = new File("C:\\java_algorithm\\baekjoon\\input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int i =1;
            System.out.println("우선순위 큐 삽입전");
            while ((line = br.readLine()) != null) {
                Issue issue= new Issue(Integer.parseInt(line.substring(0,4)), line.substring(5,line.length()));
                System.out.println(issue.year + " " + issue.value);
                insert(pQueue, issue);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------");
        System.out.println("우선순위 큐에서 하나씩 extract");
        for(int i = 0; i<11;i++){
            Issue issue = extractMax(pQueue);
            System.out.println(issue.year + " " + issue.value);
        }

    }

    static public void insert(PQueue pQueue, Issue issue){
            pQueue.size++;
            pQueue.issues[pQueue.size] = new Issue(Integer.MIN_VALUE, null);
            increaseKey(pQueue,pQueue.size, issue);
    }

    static public Issue maximum(PQueue pQueue){ //최대값 반환
        return pQueue.issues[1];
    }

    static public Issue extractMax(PQueue pQueue){ //최대값 반환삭제
        Issue max = pQueue.issues[1];
        pQueue.issues[1] = pQueue.issues[pQueue.size];
        pQueue.size--;
        maxHeapify(pQueue, 1);
        return max;
    }

    static public void increaseKey(PQueue pQueue,int i, Issue issue){ // 키 값 증가
        if (issue.year < pQueue.issues[i].year){
            System.out.println("new kye is smaller than current key");
        }
        Issue tmp;
        pQueue.issues[i] = issue;
        while(i > 1 && pQueue.issues[i/2].year < pQueue.issues[i].year){
            tmp = pQueue.issues[i/2];
            pQueue.issues[i/2] = pQueue.issues[i];
            pQueue.issues[i] = tmp;
            i = i/2;
        }

    }
    static public void maxHeapify(PQueue pQueue, int i){
        int left = i+1;
        int right = i+2;
        int largest;
        Issue tmp;
        if(left <= pQueue.size && pQueue.issues[left].year > pQueue.issues[i].year){
            largest = left;
        }else{
            largest = i;
        }
        if(right <= pQueue.size && pQueue.issues[right].year > pQueue.issues[largest].year){
            largest = right;
        }
        if(largest != i){
            tmp = pQueue.issues[i];
            pQueue.issues[i] = pQueue.issues[largest];
            pQueue.issues[largest] = tmp;
            maxHeapify(pQueue, largest);
        }
    }
}
