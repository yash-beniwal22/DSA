class Solution {
    public long subArrayRanges(int[] nums) {
        return sumOfMax(nums) - sumOfMin(nums);
    }
    private long sumOfMax(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i <= n; i++) {
            while (top != -1 && (i == n || nums[stack[top]] < (i == n ? Integer.MAX_VALUE : nums[i]))) {
                int mid = stack[top--];
                int left = top == -1 ? -1 : stack[top];
                int right = i;
                sum += (long) nums[mid] * (mid - left) * (right - mid);
            }
            stack[++top] = i;
        }
        return sum;
    }
    private long sumOfMin(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i <= n; i++) {
            while (top != -1 && (i == n || nums[stack[top]] > (i == n ? Integer.MIN_VALUE : nums[i]))) {
                int mid = stack[top--];
                int left = top == -1 ? -1 : stack[top];
                int right = i;
                sum += (long) nums[mid] * (mid - left) * (right - mid);
            }
            stack[++top] = i;
        }
        return sum;
    }
}