class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp , -1);
        return f(s, 0 , s.length() , dp)-1;
    }
    int f(String s , int i , int n , int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int mincost= Integer.MAX_VALUE;
        for(int k=i;k<n;k++){
            if(isPallindrome(i , k , s)){
                int cost= 1+ f(s, k+1 , n , dp);
                mincost= Math.min(mincost , cost);
            }
        }
        return dp[i]= mincost;
    }
    boolean isPallindrome(int i , int j , String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}