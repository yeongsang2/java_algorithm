class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int point = 0;
        for(int i = 1; i < n+1 ; i++){
            int start = stations[point] - w;
            int end = stations[point] + w;
            if( start <= i && i <= end ){ // 기지국
                i = end;
                if(point < stations.length - 1){
                    point++;
                }
            }else {
                i = i + 2*w;
                answer++;
            }
        }

        return answer;
    }
}