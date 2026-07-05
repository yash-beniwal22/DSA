class Solution {
    public int maxDigitRange(int[] nums) {
        int maxDiff=-1;
        int sum=0;
        for(int num:nums){
            int curr=num;
            int maxInt=0;
            int minInt=9;
            while(curr>0){
                int currNum=curr%10;
                maxInt=Math.max(maxInt, currNum);
                minInt=Math.min(minInt, currNum);
                curr/=10;
            }
            int diff=maxInt-minInt;
            if(diff>maxDiff){
                maxDiff=diff;
                sum=num;
            }
            else if(diff==maxDiff){
                sum+=num;
            }
        }
        return sum;
    }
}