class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;

        if (n == 0) return 0;

        long sum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
            f += (long) i * A[i];
        }

        long max = f;

        for (int k = 1; k < n; k++) {
            f = f + sum - (long) n * A[n - k];
            max = Math.max(max, f);
        }

        return (int) max;
    }
}