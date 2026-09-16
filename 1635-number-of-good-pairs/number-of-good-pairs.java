class Solution {
    public int numIdenticalPairs(int[] nums) {

        int[] count = new int [102];
         for ( int num : nums){
            count[num]++;
         }

         int totalcount = 0;
         for( int i : count){
            totalcount += ((i)* (i-1))/2;
         }
         return totalcount ;
    }
}