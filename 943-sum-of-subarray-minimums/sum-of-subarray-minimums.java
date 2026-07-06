class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007;
        int n = arr.length;
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                long count = (long) (mid - left) * (right - mid);
                ans = (ans + count * arr[mid]) % mod;
            }
            stack.push(i);
        }
        return (int) ans;
    }
}