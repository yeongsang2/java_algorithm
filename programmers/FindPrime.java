package programmers;
import java.util.*;

public class FindPrime {
    static String[] numberList;
    static Set<Integer> primeSet = new HashSet();
    public int solution(String numbers) {
        int answer = 0;
        numberList = new String[numbers.length()];

        for(int i =0; i< numbers.length(); i++){
            // numberList[i] = Character.g기tNumericValue(numbers.charAt(i));
            numberList[i] = String.valueOf(numbers.charAt(i));
        }
        for(int i =0; i< numberList.length; i++){
            List<Integer> idxList = new LinkedList();
            idxList.add(i);
            dfs(numberList[i], idxList);
        }

        return primeSet.size();
    }

    public void dfs(String path, List<Integer> idxList){
        // 이미 없고, 소수 일경우
        int number = Integer.parseInt(path);
        if ( checkPrime(number) == 1 ){
            primeSet.add(number);
        }

        // 다썻으면
        if (path.length() == numberList.length){
            return;
        }

        for(int i =0; i< numberList.length; i++){
            if(!idxList.contains(i)){
                idxList.add(i);
                dfs(path + numberList[i], idxList);
                idxList.remove(Integer.valueOf(i));
            }
        }
    }

    public int checkPrime(int number){
        if ( number < 2){
            return 0;
        }

        // 나누어떨어지는게 1과 자기자신
        for(int i = 2 ; i < number ;i++){
            if ( number % i == 0){
                return 0;
            }
        }
        return 1;
    }
}
