package programmers;

import java.util.HashSet;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int answer = 0;

        HashSet<Long> set = new HashSet<>();

        int size = 1;
        int index = 0;
        while(size <= elements.length) {
            long sum = 0;
            for(int i = 0; i < size; i++) {
                sum += elements[(index + i) % elements.length];
            }

            set.add(sum);
            index++;

            if(index >= elements.length) {
                index = 0;
                size++;
            }
        }


        return set.size();
    }
}
