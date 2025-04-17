class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;

        long[] pulse1 = new long[n]; // [-1, 1, -1, 1, ...]
        long[] pulse2 = new long[n]; // [1, -1, 1, -1, ...]

        int init = -1;
        for (int i = 0; i < n; i++) {
            pulse1[i] = (long) sequence[i] * init;
            pulse2[i] = (long) sequence[i] * -init;
            init = -init;
        }

        // prefix sum
        for (int i = 1; i < n; i++) {
            pulse1[i] += pulse1[i - 1];
            pulse2[i] += pulse2[i - 1];
        }

        long min1 = 0, min2 = 0;
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, pulse1[i] - min1);
            min1 = Math.min(min1, pulse1[i]);

            max2 = Math.max(max2, pulse2[i] - min2);
            min2 = Math.min(min2, pulse2[i]);
        }

        return Math.max(max1, max2);
    }
}
