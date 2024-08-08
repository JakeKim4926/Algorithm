package programmers;

import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> songs = new HashMap();

        // 같은 장르로 play한 횟수
        for (int i = 0; i < genres.length; i++) {
            if (songs.containsKey(genres[i])) {
                songs.put(genres[i], songs.get(genres[i]) + plays[i]);
            } else {
                songs.put(genres[i], plays[i]);
            }
        }

        // 내림차순
        List<String> genresList = new ArrayList<>(songs.keySet());
        Collections.sort(genresList, (o1, o2) -> (songs.get(o2).compareTo(songs.get(o1))));

        // 장르별 play
        List<Integer> answerList = new ArrayList<>();
        genresList.forEach(li -> {
            HashMap<Integer, Integer> playsMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                if (li.equals(genres[i])) {
                    playsMap.put(i, plays[i]);
                }
            }

            // 내림차순
            List<Integer> playsList = new ArrayList<>(playsMap.keySet());
            Collections.sort(playsList, (o1, o2) -> (playsMap.get(o2).compareTo(playsMap.get(o1))));

            answerList.add(playsList.get(0));
            if (playsList.size() != 1) {
                answerList.add(playsList.get(1));
            }
        });

        answer = new int[answerList.size()];

        for (int idx = 0; idx < answerList.size(); idx++) {
            answer[idx] = answerList.get(idx);
        }

        return answer;
    }
}
