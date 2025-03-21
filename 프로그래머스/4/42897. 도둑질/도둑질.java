class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int n = money.length;
        int[] dp1 = new int[n]; // 첫번째 선택
        int[] dp2 = new int[n];
        
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        dp2[0] = 0;
        dp2[1] = money[1];
        
        int maxA = 0;
        for(int i = 2 ; i < n - 1; i++){
            dp1[i] = Math.max(dp1[i-1], money[i] + dp1[i-2]);
            maxA = Math.max(maxA, dp1[i]);
        }
        
        int maxB = 0;
        for(int i = 2 ; i < n; i++){
            dp2[i] = Math.max(dp2[i-1], money[i] + dp2[i-2]);
            maxB = Math.max(maxB, dp2[i]);
        }
        
        answer = Math.max(maxA, maxB);
        return answer;
    }
}