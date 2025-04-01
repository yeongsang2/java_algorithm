
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> listA = new ArrayList<>(); // 양수
        List<Integer> listB = new ArrayList<>(); // 음수


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !listB.contains(num)){
                listB.add(num);
            }else if (num > 0){
                listA.add(num);
            }else{
                listB.add(num);
            }
        }

        Collections.sort(listA);
        Collections.sort(listB);

        List<Integer> answerList = new ArrayList<>();

        for(int i = listA.size() - 1 ; i >= 0 ; i-=2){
            if(i > 0){
                int now = listA.get(i);
                int next = listA.get(i - 1);
                if(now * next > now) answerList.add(listA.get(i) * listA.get(i - 1));
                else {
                    answerList.add(listA.get(i));
                    i++;
                }
            }else if(i == 0){
                answerList.add(listA.get(i));
            }
        }

        for(int i = 0 ; i < listB.size() ; i+=2){
            if(i < listB.size() - 1){
                int now = listB.get(i);
                int next = listB.get(i + 1);
                if(now * next > now) answerList.add(now * next);
                else {
                    answerList.add(now);
                    i--;
                }
            }else{
                answerList.add(listB.get(i));
            }
        }
        int answer = 0 ;
        for(Integer i : answerList){
            answer += i;
        }
        System.out.println(answer);

    }
}
