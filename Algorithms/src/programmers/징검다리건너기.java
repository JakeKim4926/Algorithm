package programmers;

public class 징검다리건너기 {
    public int solution(int[] stones, int k) {

        int start = 0;
        int end = 200000000;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(ableToCross(stones, k, mid))
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start;
    }

    public boolean ableToCross(int[] stones, int k, int people) {
        int count = 0;
        for(int stone : stones) {
            if(stone - people <= 0) {
                count++;
                if(count >= k)
                    return false;
            }  else
                count = 0;
        }

        return true;
    }
}
