package programmers.kakao_winter_internship_2024;

import java.util.HashMap;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> presents = new HashMap<>();

        int index = 0;
        for (String friend : friends) {
            presents.put(friend, index++);
        }

        int[][] arrPresents = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String from = gift.split(" ")[0];
            String to = gift.split(" ")[1];

            int fromIndex = presents.get(from);
            int toIndex = presents.get(to);

            arrPresents[fromIndex][toIndex]++;
        }

        int[] presentsCount = new int[arrPresents.length];
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};

        for (int i = 0; i < arrPresents.length; i++) {
            int row = i;
            int col = i;
            for(int j = 0; j < dr.length; j++) {
                int movedRow = row + dr[j];
                int movedCol = col + dc[j];

                while(movedCol >= 0 && movedCol < arrPresents.length
                        && movedRow >= 0 && movedRow < arrPresents.length) {
                    if(j < 2)
                        presentsCount[i]++;
                    else
                        presentsCount[i]--;

                    movedRow = row + dr[j];
                    movedCol = col + dc[j];
                }


            }
        }

        return answer;
    }
}
