class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }
        for (int card : hand) {
            if (freq.get(card) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int curr = card + i;
                if (freq.getOrDefault(curr, 0) == 0) {
                    return false;
                }
                freq.put(curr, freq.get(curr) - 1);
            }
        }
        return true;
    }
}