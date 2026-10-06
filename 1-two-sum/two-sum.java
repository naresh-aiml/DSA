class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            int need = target - arr[i];

            if(map.containsKey(need)) {
                return new int[] { map.get(need), i };
            }

            map.put(arr[i], i);
        }
        return new int[] {};
    }
}