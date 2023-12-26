package softeer;

import javax.annotation.processing.Generated;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem2 {
    static class myQueue{
        String alpa;
        Integer cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() == 7){
                //deque
            }else {


            }

        }
    }
}
