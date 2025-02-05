class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        //첫번째 떔
        int length = sticker.length;
        int[] dpA = new int[length];
        int temp = sticker[length-1];
        sticker[sticker.length-1] = 0;
        dpA[0] = sticker[0];
        dpA[1] = sticker[0];
        int answerA = Math.max(dpA[0], dpA[1]);
        
        for(int i = 2 ; i < length ; i++){
            dpA[i] = Math.max(dpA[i-1], dpA[i-2] + sticker[i]);
            answerA = Math.max(answerA, dpA[i]);
        }
            
        // 첫번째 안떔
        sticker[length-1] = temp;
        int[] dpB = new int[sticker.length];
        dpB[0] = 0;
        dpB[1] = sticker[1];

        int answerB = Math.max(dpB[0], dpB[1]);
        for(int i = 2 ; i < length ; i++){
            dpB[i] = Math.max(dpB[i-1], dpB[i-2] + sticker[i]);
            answerB = Math.max(answerB, dpB[i]);
        }
        
        return Math.max(answerA, answerB);
    }
}