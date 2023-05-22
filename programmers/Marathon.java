package programmers;

import java.util.*;

public class Marathon {
    public static void main(String[] args) {

        String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion =  { "josipa", "filipa", "marina", "nikola" };
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if ( i == ( participant.length - 1 )) {
                answer = participant[i];
                break;
            }
            if( !participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
        }
        System.out.println(answer);
    }
}
