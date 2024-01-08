package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20438 {


    static List<Integer> tiredStudent = new ArrayList<>();
    static List<Integer> sendStudent = new ArrayList<>();
    static List<Range> rangeList = new ArrayList<>();

    static boolean[] student;

    static class Range{
        int start;
        int end;
        public Range(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        student = new boolean[n+3];

        st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            tiredStudent.add(Integer.parseInt(st.nextToken()));
        }

        st=  new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            sendStudent.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st=  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rangeList.add(new Range(start ,end));
        }

        for(Integer s : sendStudent){
            if(!tiredStudent.contains(s)){
                student[s] = true;
                recur(s, s);
            }
        }
        StringBuilder sb= new StringBuilder();

        for(Range range : rangeList){
            int cnt = 0;
            int s = range.start;
            int e = range.end;
            for (int i = s; i < e+1; i++) {
                if(!student[i]){
                    cnt++;
                }
            }

            sb.append(Integer.toString(cnt)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void recur(int stu, int plus){
        if(stu + plus > n+2){
            return;
        }

        recur(stu + plus, plus);
        if(!tiredStudent.contains(stu+plus)){
            student[stu+plus] = true;
            recur(stu + stu, stu);
        }
    }
}
