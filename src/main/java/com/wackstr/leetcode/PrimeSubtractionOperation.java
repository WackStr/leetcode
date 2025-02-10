package com.wackstr.leetcode;

public class PrimeSubtractionOperation {

    private static final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public static int[] generatePrimes(int k) {
        if(k >= 2) {
            int totalCount = k - 1;
            int[] array = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                array[i] = i;
            }
            array[1] = 0;
            for (int i = 2; i <= k; i++) {
                for (int j = 2; j <= k / i; j++) {
                    if(array[i*j] != 0) {
                        array[i * j] = 0;
                        totalCount--;
                    }
                }
            }
            int[] finalArray = new int[totalCount];
            int index = 0;
            for (int i = 0; i <= k; i++) {
                if (array[i] != 0) {
                    finalArray[index++] = array[i];
                }
            }
            return finalArray;
        }else{
            return new int[0];
        }
    }

    public boolean primeSubOperation(int[] nums) {
        nums[0] = nums[0] - findSupremum(nums[0], primeNumbers);
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] >= nums[i]) return false;
            nums[i] = nums[i] - findSupremum(nums[i] - nums[i-1], primeNumbers);
            if(nums[i-1] >= nums[i]) return false;
        }
        return true;
    }

    public int findSupremum(int lookup, int[] nums){
        return bisect(lookup, 0, nums.length, nums);
    }

    public int bisect(int lookup, int left, int right, int[]nums){
        int currIndex = (left + right) / 2;
        if(left == right || currIndex == left) {
            int returnCandidate = nums[left];
            if (returnCandidate < lookup){
                return returnCandidate;
            }else if(left > 0){
                return nums[left - 1];
            }else{
                return 0;
            }
        }
        int currItem = nums[currIndex];
        if(currItem > lookup) return bisect(lookup, left, currIndex, nums);
        return bisect(lookup, currIndex, right, nums);
    }


    public static void main(String[] args) {
        int[] nums = {4,9,6,10};
        PrimeSubtractionOperation sol = new PrimeSubtractionOperation();
        //System.out.println(Arrays.toString(sol.generatePrimes(1000)));
        // System.out.println(sol.findSupremum(15, nums));
        System.out.println(sol.primeSubOperation(nums));
    }
}
