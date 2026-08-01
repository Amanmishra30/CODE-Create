class Solution {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;

        int sum = a ^ b;              // Add without carry
        int carry = (a & b) << 1;     // Carry

        return getSum(sum, carry);    // Recursive call
    } 
    }
