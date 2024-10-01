package programmers;

import java.util.*;

public class N으로표현 {
    public int solution(int N, int number) {
        int answer = -1;

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++)
            list.add(new HashSet<>());

        if(number == N)
            return 1;

        list.get(1).add(N);

        for(int i = 2; i <= 8; i++) {
            HashSet<Integer> set = list.get(i);
            for(int j = 1; j <= i;j++) {
                HashSet<Integer> preSet = list.get(j);
                HashSet<Integer> postSet = list.get(i-j);

                for(int preNum : preSet) {
                    for(int postNum: postSet) {
                        set.add(preNum + postNum);
                        set.add(preNum - postNum);
                        set.add(preNum * postNum);
                        if(postNum != 0)
                            set.add(preNum / postNum);
                    }
                }
            }

            int num = 0;
            for(int j = 0; j < i; j++)
                num = num*10 + N;

            set.add(num);
        }

        for(int i = 2 ;i < list.size(); i++) {
            if(list.get(i).contains(number))
                return i;
        }


        return answer;
    }
}
