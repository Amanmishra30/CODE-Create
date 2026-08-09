class Solution {

    public int numDecodings(String s) {

        if (s.length() == 0)
            return 0;

        Integer[] memo = new Integer[s.length()];

        return decode(0, s, memo);
    }

    private int decode(int index, String s, Integer[] memo) {

        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;

        if (memo[index] != null)
            return memo[index];

        // Take one digit
        int ways = decode(index + 1, s, memo);

        // Take two digits if valid
        if (index + 1 < s.length()) {

            int number =
                (s.charAt(index) - '0') * 10 +
                (s.charAt(index + 1) - '0');

            if (number >= 10 && number <= 26) {
                ways += decode(index + 2, s, memo);
            }
        }

        memo[index] = ways;

        return ways;
    }
}