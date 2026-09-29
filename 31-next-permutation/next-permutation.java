class Solution { 
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            int left=0;
            int right=nums.length-1;
            while(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
            return;
        }
        int replacer=-1;
        for(int i=nums.length-1;i>pivot;i--){
            if(nums[pivot]<nums[i]){
                replacer=i;
                break;
            }
        }
        int temp=nums[pivot];
        nums[pivot]=nums[replacer];
        nums[replacer]=temp;
        int left=pivot+1;
        int right=nums.length-1;
        while(left<right){
            int Temp=nums[left];
            nums[left]=nums[right];
            nums[right]=Temp;
            left++;
            right--;
        }

    }
}