package programmers;

public class minimumRectangular {
    public static void main(String[] args) {
        solution();
    }
    public static int solution(int[][] sizes) {
        int answer = 0;
        int w, h;
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < sizes.length; i++) {
            w = Integer.max(sizes[i][0],sizes[i][1]);
            h = Integer.min(sizes[i][0], sizes[i][1]);
            maxW = Integer.max(w, maxW);
            maxH = Integer.max(h, maxH);
        }
        return maxW*maxH;
    }
}
