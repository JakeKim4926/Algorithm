package programmers.kakao_winter_internship_2024;

import java.util.HashMap;

// https://github.com/JakeKim4926/Algorithm

public class 가장많이받은선물 {
    public static int solution(String[] friends, String[] gifts) {

        int answer = 0;

        HashMap<String, Integer> friendsMap = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            friendsMap.put(friends[i], i);
        }

        int[][] presents = new int[friends.length][friends.length];
        int[] presentValues = new int[friends.length];

        for(int i = 0; i < gifts.length; i++) {
            String from = gifts[i].split(" ")[0];
            String to = gifts[i].split(" ")[1];

            presents[friendsMap.get(from)][friendsMap.get(to)]++;
            presentValues[friendsMap.get(from)]++;
            presentValues[friendsMap.get(to)]--;
        }

        int[] results = new int[friends.length];

        for(int i = 0; i < friends.length-1; i++) {
            for(int j = 0; j < friends.length;j++){
                if(i == j)
                    continue;

                if(presents[i][j] != presents[j][i]) {
                    if(presents[i][j] > presents[j][i])
                        results[i]++;
                } else if(presentValues[i] > presentValues[j]){
                    results[i]++;
                }
            }
        }

        for(int i = 0; i < friends.length; i++) {
            if(answer < results[i])
                answer = results[i];
        }


        return answer;
    }
}
