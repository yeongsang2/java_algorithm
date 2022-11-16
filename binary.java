import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class binary {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m,n;
        int check;
        int tc = Integer.parseInt(br.readLine());
        for(int i=1 ; i<tc+1; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            String binaryString = Integer.toBinaryString(m);
            check = 0;

//            System.out.println(binaryString);
            if(binaryString.length() == 0){
                System.out.println("#" + i + " OFF");
            }else {
                    if (binaryString.length() > n) {
                        for (int j = binaryString.length() - 1; j > binaryString.length() - n - 1; j--) {
    //                System.out.println(binaryString.charAt(j));
                            if (binaryString.charAt(j) == '0') {
                                System.out.println("#" + i + " OFF");
                                check = 1;
                                break;
                            }
                        }
                        if (check == 0) {
                            System.out.println("#" + i + " ON");
                        }
                    }else {
                        for (int j = binaryString.length() -1 ; j > -1 ; j--){
                            if (binaryString.charAt(j) == '0') {
                                System.out.println("#" + i + " OFF");
                                check = 1;
                                break;
                            }
                        }
                        if (check == 0) {
                            System.out.println("#" + i + " ON");
                        }
                    }
            }
            }

        }
    }
