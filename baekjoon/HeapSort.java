package baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort {

    static class Issue{
        int year;
        String value;

        public Issue(int year, String value) {
            this.year = year;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        String line;
        Issue[] arr = new Issue[11];

        File file = new File("C:\\java_algorithm\\baekjoon\\input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int i =1;
            while ((line = br.readLine()) != null) {
                arr[i] = new Issue(Integer.parseInt(line.substring(0,4)), line.substring(5,line.length()));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 정렬전
        System.out.println("정렬 전");
        for(int i =1 ; i < 11;i++){
            Issue issue = arr[i];
            System.out.println(issue.year + " " + issue.value);
        }
        //Issue 배열을 힙으로 만듬
        buildHeap(arr);

        //힙을 이용해서 정렬
        heapSort(arr);
        System.out.println("--------------------------------------");
        System.out.println("정렬후");
        for(int i =1 ; i < 11;i++){
            Issue issue = arr[i];
            System.out.println(issue.year + " " + issue.value);
        }


    }

    static void heapSort(Issue[] arr){
        int eNN = arr.length -1;
        while(eNN >1){
            swap(arr, 1, eNN);
            eNN--;
            pushDown(arr, 1, eNN);
        }
    }

    //eNN = endNodeNUmber
    //tNN = tempNodeNumber
    static void buildHeap(Issue[] arr){
        int eNN = arr.length -1; // 마지막 노드
        int tNN = eNN/2 +1; //첫번째 리프노드 번호

        while(tNN > 1){
            tNN--; //자식을 가지고 있는 마지막 노드 부터 시작
            pushDown(arr, tNN, eNN);
        }
    }

    static void pushDown(Issue[] arr, int tNN, int eNN){
        int y = findLarger(arr, tNN, eNN);
        //자식 노드중 루트 노드보다 더 큰 값을 가지는 노드 번호 얻어냄

        while(arr[tNN].year < arr[y].year){
            swap(arr, tNN, y);
            tNN  =y;
            y = findLarger(arr, tNN, eNN);
            // leaf노드 쪽으로 내려가면서 값의 제자리를 찾아감
        }
    }

    static int findLarger(Issue[] arr, int tNN, int eNN){
        int tmp = tNN*2+1; // 오른쪽 자식 노드의 번호
        int y = tNN;

        if(tmp <= eNN){ //자식 노드가 두개인 경우
            if(arr[tNN].year < arr[tmp].year){ //오른쪽 잣기 노드의 value가 더 크다면
                y = tmp;
            }
            if(arr[y].year < arr[tmp-1].year){
                y= tmp-1;
            }
        }else if(tmp-1 <= eNN){ //자식 노드가 1개인 경우
            if(arr[tNN].year < arr[tmp-1].year) { //자식 노드의 value가 더 크다면
                y = tmp - 1;
            }
        }
        return y;
    }

    static void swap(Issue[] arr, int a, int b){
        Issue tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


}
