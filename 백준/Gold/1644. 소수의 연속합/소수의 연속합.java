import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==2) {
            System.out.println(1);
            return;
        }else if(n==1){
            System.out.println(0);
            return;
        }
        boolean[] prime = new boolean[n+1];

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(prime[i]) continue;
            for(int j = i*i ; j < n + 1; j = j + i){
                prime[j] = true;
            }
        }

        int cnt = 1;
        int[] primeArr = new int[n+1];
        for(int i = 2 ; i < n +1 ; i++){
            if(!prime[i]){
                primeArr[cnt] = i + primeArr[cnt-1];
//                System.out.print(i + " ");
                cnt++;
            }
        }

        int answer = 0;
        int left = 1;
        int right = 2;
        while(left<= right && right != cnt){
            if( (primeArr[right] - primeArr[left -1]) == n){
                answer++;
                right++;
                left++;
            }else if(primeArr[right] - primeArr[left] < n){
                right++;
            }else{
                left++;
            }
        }
        System.out.println(answer);



    }
}
