package programmers;

public class N개의최소공배수 {
    class Solution {
        public int solution(int[] arr) {
            int answer = 0;

            int gcd = arr[0];
            for(int i = 1; i < arr.length; i++) {
                int bigger = Math.max(gcd, arr[i]);
                int smaller = Math.min(gcd, arr[i]);

                gcd *= arr[i];

                while(smaller != 0) {
                    int temp = bigger % smaller;
                    bigger = smaller;
                    smaller = temp;
                }

                gcd /= bigger;
            }

            return gcd;
        }
    }
}
