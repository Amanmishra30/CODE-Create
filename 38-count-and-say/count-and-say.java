class Solution {
    public String countAndSay(int n) {
           if (n == 1)
            return "1";

        String RLE = countAndSay(n - 1);

        StringBuilder newRLE = new StringBuilder();
        int count = 1;

        for (int i = 1; i < RLE.length(); i++) {
            if (RLE.charAt(i - 1) == RLE.charAt(i)) {
                count++;
            } else {
                newRLE.append(count).append(RLE.charAt(i - 1));
                count = 1;
            }
        }

        newRLE.append(count).append(RLE.charAt(RLE.length() - 1));

        return newRLE.toString();
    }
}