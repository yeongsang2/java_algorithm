class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;
        int point = 0;
        int i = 1;

        while(i <= n) {
            if(point < stations.length && i >= stations[point] - w) {
                i = stations[point] + w + 1;
                point++;
            } else {
                answer++;
                i += 2*w + 1;
            }
        }
        return answer;

    }
}