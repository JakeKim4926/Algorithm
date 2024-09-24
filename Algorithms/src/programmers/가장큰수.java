package programmers;

import java.util.*;

class 가장큰수 {
    public String solution(int[] numbers) {
        String[] temp = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            temp[i] = String.valueOf(numbers[i]);

        Arrays.sort(temp, (o1,o2) -> (o2+o1).compareTo(o1+o2));

        if(temp[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String num : temp)
            sb.append(num);

        return sb.toString();
    }
}