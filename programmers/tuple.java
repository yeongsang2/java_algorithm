package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class tuple {
    public static void main(String[] args) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }
    public static int[] solution(String s) {
        int[] answer = {};

        // 글자 먼저 파싱해야함
        // "},{" 문자열로 파싱함
        // '{', '}'는 메타 캐릭터이기 때문에 이스케이프 \\ 해야함
        // "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        String[] split = s.split("\\},\\{");
        // ["{{2", "2,1", "2,1,3", "2,1,3,4}}"]

        // 배열의 가장 앞 문자열, 배열의 가장 뒷 문자열에서 '{' , '}' 문자 제거
        split[0] = split[0].replaceAll("[{}]","");
        split[split.length-1] = split[split.length-1].replaceAll("[{}]","");
        // ["2", "2,1", "2,1,3", "2,1,3,4"]


        //System.out.println(split[0]);
        //System.out.println(split[split.length-1]);


        // 길이가 짧은 array 순으로 정렬
        String[][] sortedByLength = new String[split.length][];

        for (int i = 0 ; i < split.length ; i++) {
            String[] ss = split[i].split(",");
            sortedByLength[ss.length-1] = ss;
            //System.out.println(Arrays.toString(sortedByLength[ss.length-1]));
        }
        // [["2"],
        // ["2", "1"],
        // ["2", "1", "3"],
        // ["2", "1", "3", "4"]]

        // 길이가 짧은 array를 먼저 보면서,
        // set에 요소를 담으면서, set에 없었던 요소이면 answerStrArr에 추가
        HashSet<String> mySet = new HashSet<>();
        String[] answerStrArr = new String[split.length];
        for (int i = 0 ; i < sortedByLength.length ; i++) {
            for (int j = 0 ; j < sortedByLength[i].length ; j++) {
                if (!mySet.contains(sortedByLength[i][j])) {
                    answerStrArr[i] = sortedByLength[i][j];
                    mySet.add(sortedByLength[i][j]);
                }
            }
        }
        // set: 2, 1, 3, 4
        // answerStrArr: ["2", "1", "3", "4"]

        // 숫자 배열로 변환
        //System.out.println(Arrays.toString(answerStrArr));
        answer = new int[answerStrArr.length];
        for (int i = 0; i < answerStrArr.length ; i++) {
            answer[i] = Integer.parseInt(answerStrArr[i]);
        }

        //System.out.println(Arrays.toString(answer));

        return answer;
    }
}
