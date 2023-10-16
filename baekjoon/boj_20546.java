package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int totalCashA = t;
        int stockCountA = 0;

        int nowStockPrice = 0;
        int prevStockPrice = -1;

        int totalCashB = t;
        int buyFlagB = 2;
        int upDownCountB = 0;
        int stockCountB = 0;

        String stock[] = br.readLine().split(" ");
        Integer stockList[] = new Integer[stock.length];
        for(int i =0 ; i< stock.length ; i++){
            stockList[i] = Integer.parseInt(stock[i]);
        }

        for(int i =0 ; i< stock.length ; i++){

            nowStockPrice = stockList[i];

            // A 살수 있음면 삼
            if( (totalCashA / nowStockPrice) > 0 ){
                int buyCountA = totalCashA / nowStockPrice;
                stockCountA = stockCountA + buyCountA;
                totalCashA = totalCashA - nowStockPrice*stockCountA;
            }

            if(i >= 1) {

                // 전날보다 주식 쌈
                if (prevStockPrice > nowStockPrice) {
                    if (buyFlagB == 0) {
                        upDownCountB -= 1;
                        if (upDownCountB <= -3) {  // 3일연속 하락장 -> 주식 매수
                            int buyCountB = totalCashB / nowStockPrice;
                            stockCountB = stockCountB + buyCountB;
                            totalCashB = totalCashB - nowStockPrice * buyCountB;
                        }
                    } else {
                        upDownCountB = 0; //초기화
                        upDownCountB -= 1;

                    }
                    buyFlagB = 0;
                }

                // 전날보다 주식 비쌈
                if (prevStockPrice < nowStockPrice) {
                    if (buyFlagB == 1) {
                        upDownCountB += 1;
                        if (upDownCountB >= 3) {  // 3일연속 상승장 -> 팔아재낌
                            totalCashB = totalCashB + stockCountB * nowStockPrice;
                            stockCountB = 0;
                        }
                    } else {
                        upDownCountB = 0;
                        upDownCountB += 1;
                    }
                    buyFlagB = 1;
                }

                if (prevStockPrice == nowStockPrice) {
                    upDownCountB = 0;
                    buyFlagB = 2;
                }
            }
            prevStockPrice = nowStockPrice;
        }

        totalCashA = totalCashA + stockCountA*nowStockPrice;
        totalCashB = totalCashB + stockCountB*nowStockPrice;
//        System.out.println(totalCashA);
//        System.out.println(totalCashB);

        if (totalCashA == totalCashB){
            System.out.println("SAMESAME");
        } else if(totalCashA > totalCashB){
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }
}
