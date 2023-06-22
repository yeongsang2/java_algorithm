package programmers;
import java.util.*;
public class report {

    public static void main(String[] args) {

    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, List<String>> reportMap = new LinkedHashMap();
        HashMap<String, Integer> reportCount = new LinkedHashMap();

        int i =0;
        for(String id : id_list){
            reportMap.put(id, new LinkedList<String>());
            reportCount.put(id, 0);
            answer[i] = 0;
            i++;
        }


        for(String rep : report){

            String[] subStr = rep.split(" ");
            String reportUser = subStr[0];
            String stopUser = subStr[1];
            if(reportMap.get(reportUser).contains(stopUser)){
                continue;
            }
            //신고한 유저 추가
            reportMap.get(reportUser).add(stopUser);
            // 신고횟수 담음
            reportCount.put(stopUser, reportCount.get(stopUser) + 1);
        }
        List<String> stopUserList = new LinkedList();

        for(String key : reportCount.keySet()){
            Integer count = reportCount.get(key);
            if(count >= k){
                stopUserList.add(key);
            }
        }
        int j = 0;
        for(String key : reportMap.keySet()){

            List<String> list = reportMap.get(key);
            for(String s : list){
                if(stopUserList.contains(s)){
                    answer[j]++;
                }
            }
            j++;
        }

        return answer;
    }
}
