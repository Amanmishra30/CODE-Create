class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            int count = 1;

            // Find largest power-of-2 multiple of divisor
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            dvd -= temp;
            quotient += count;
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }

        return quotient;
    }
}