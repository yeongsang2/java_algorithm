import java.io.*;
import java.util.*;
class Test {
    public static int[][] visited;
    public static int[][] area;
    public static int lines;
    public static List<Integer> list = new LinkedList();

    //상 하 좌 우
    public static int[] mi = {-1, 1 ,0,0};
    public static int[] mj = {0, 0 ,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
        visited = new int[lines][lines];
        for(int i=0; i<lines; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< lines; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<lines; i++){
            for(int j=0; j< lines; j++){
                visited[i][j] = 0;
            }
        }
        int total = 0;
        Stack<int[]> stack = new Stack();
        List<Integer> list = new LinkedList();
        for(int i=0; i<lines; i++){
            for(int j=0; j< lines; j++){
                if( visited[i][j] == 0 && area[i][j] == 1){
                    int count = 0;
                    stack.add(new int[]{i,j});
                    visited[i][j] = 1;
                    while(!stack.isEmpty()){
                        int[] temp = stack.pop();
                        for(int s = 0; s < 4; s++){
                            int ni = temp[0] + mi[s];
                            int nj = temp[1] + mj[s];
                            if( ni >= 0 && ni < lines && nj >=0 && nj < lines && area[ni][nj] == 1 && visited[ni][nj] == 0) {
                                visited[ni][nj] = 1;
                                stack.add(new int[]{ni,nj});
                            }
                        }
                        count ++;
                    }
                    total++;
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        if(list.size() != 0){
            for(int i= 0; i<list.size();i++){
                System.out.print(list.get(i) + " ");
            }
        }
    }
}