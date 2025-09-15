package Array;
class rearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int p = 0;  // pointer for positive numbers (even indices)
        int np = 1; // pointer for negative numbers (odd indices)

        for(int num : nums){
            if(num > 0){
                result[p] = num;
                p += 2;  // move to next even index
            } else {
                result[np] = num;
                np += 2;  // move to next odd index
            }
        } 
        return result;
    }
}
