//package swea;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class swea_18662 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int t = Integer.parseInt(br.readLine());
//
//        for (int i = 1; i < t+1; i++) {
//            st = new StringTokenizer(br.readLine());
//            double a = Integer.parseInt(st.nextToken());
//            double b = Integer.parseInt(st.nextToken());
//            double c = Integer.parseInt(st.nextToken());
//            double x;
//
//            if( (b-a) == (c-b) ) {
//                System.out.println("#" + t+ " 0.0");
//                continue;
//            }
//
//            // a에 뺌  / b-c 차이을 a 에 더함
//            x = a - (b-c);
//            // a에 더함  / 2 6 8
//            x = (b - c)
//            // b에 빼거나 더함
//            x = b - ( a+c / 2 );
//
//            x = ( a + c / 2) - b
//            // c에 빼거나 더함
//        }
//    }
//}
