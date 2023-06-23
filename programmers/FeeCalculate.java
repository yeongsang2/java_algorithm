package programmers;
import java.util.*;
public class FeeCalculate {
    public static int basicTime;
    public static int basicFee;
    public static int unitTime;
    public static int unitFee;
    public static Map<String, String> carMap;
    public static Map<String, Integer> feeMap;
    public static Map<String, Integer> feeTime;

    public static void main(String[] args) {
        solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"});
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer;

        basicTime = fees[0];
        basicFee = fees[1];
        unitTime = fees[2];
        unitFee = fees[3];

        carMap = new HashMap();
        feeMap = new HashMap();
        feeTime = new HashMap<>();

        for(String record : records){
            String[] subStr = record.split(" ");
            String nowTime= subStr[0];
            String carNumber = subStr[1];
            String type = subStr[2];

            if(type.equals("IN")){
                carMap.put(carNumber, nowTime);
                continue;
            }
            if(type.equals("OUT")){
                int diff = calculateDiff(carNumber,nowTime);
                feeTime.put(carNumber, feeTime.getOrDefault(carNumber,0) + diff);
                carMap.remove(carNumber);
            }
        }
        String[] restCar = carMap.keySet().toArray(new String[0]);

        // 출차안한차들계산
        for(String carNumber : restCar){
            int diff = calculateDiff(carNumber,"23:59");
            feeTime.put(carNumber, feeTime.getOrDefault(carNumber,0) + diff);
            carMap.remove(carNumber);
        }

        // 요금계산
        for(String carNumber: feeTime.keySet()){
            int fee = calculateFee(feeTime.get(carNumber));
            feeMap.put(carNumber, feeMap.getOrDefault(carNumber,0) + fee);
        }

        // 정렬
        List<String> list = new LinkedList();
        for(String carNumber : feeMap.keySet()){
            list.add(carNumber);
        }
        Collections.sort(list);


        answer = new int[list.size()];
        for(int i =0; i< answer.length; i++){
            answer[i] = feeMap.get(list.get(i));
        }
        return answer;
    }
    public static int calculateFee(Integer diff){
//        System.out.println(diff);
        if(diff <= basicTime){
            return basicFee;
        }
//        System.out.println(basicFee +  (int) Math.ceil(( (diff - basicTime) / unitTime )) *unitFee);

        return basicFee + (int) Math.ceil( (double)(diff - basicTime) / unitTime ) * unitFee;
    }

    public static int calculateDiff(String carNumber, String nowTime){

        String inTime = carMap.get(carNumber);
        String[] subInTime = inTime.split(":");
        Integer mInTime = Integer.parseInt(subInTime[0]) * 60 + Integer.parseInt(subInTime[1]);

        String[] subNowTime = nowTime.split(":");
        Integer mNowTime = Integer.parseInt(subNowTime[0]) * 60 + Integer.parseInt(subNowTime[1]);

        int diff = mNowTime - mInTime;
        return diff;
    }
}
