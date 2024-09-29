package programmers;

import java.util.ArrayList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        int[] peopleFirst = {1,2,3,4,5};
        int[] peopleSecond = {2,1,2,3,2,4,2,5};
        int[] peopleThird = {3,3,1,1,2,2,4,4,5,5};

        int indexFirst = 0;
        int indexSecond = 0;
        int indexThird = 0;
        int max = 0;
        for(int num : answers) {
            if(peopleFirst[indexFirst++] == num)     answer[0]++;
            if(peopleSecond[indexSecond++] == num)   answer[1]++;
            if(peopleThird[indexThird++] == num)     answer[2]++;

            if(indexFirst >= peopleFirst.length)    indexFirst = 0;
            if(indexSecond >= peopleSecond.length)  indexSecond = 0;
            if(indexThird >= peopleThird.length)    indexThird = 0;
        }
        for(int num : answer)
            max = Math.max(max,num);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < answer.length; i++) {
            if(max == answer[i])
                list.add(i+1);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}
