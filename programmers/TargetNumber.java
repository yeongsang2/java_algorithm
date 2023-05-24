package programmers;

public class TargetNumber {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public static int total = 0;
    public static int targetNum = 0;
    public static int solution(int[] numbers, int target) {
        int start =0;
        targetNum = target;

        dfs(numbers,1, start + numbers[0]);
        dfs(numbers, 1, start - numbers[0]);

        return total;
    }
    public static void dfs(int[] numbers, int count, int sum){
        if(count == numbers.length){
            if(sum == targetNum){
                total++;
            }
            return;
        }
        dfs(numbers,count+1,sum + numbers[count]);
        dfs(numbers, count+1, sum - numbers[count]);
    }
}
