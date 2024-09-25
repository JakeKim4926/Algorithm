package programmers;

import java.util.*;

public class 베스트앨범 {
    class Song {
        String genre;
        int plays;
        int num;
        int count;

        Song(String genre, int plays, int num) {
            this.genre = genre;
            this.plays = plays;
            this.num = num;
        }

        @Override
        public String toString() {
            return genre + "/" + plays + "/" + num + "/" + count;
        }
    }

    class SongComparator implements Comparator<Song> {
        @Override
        public int compare (Song s1, Song s2){
            int genre = Integer.compare(s2.count, s1.count);

            if(genre != 0)
                return genre;

            int result = Integer.compare(s2.plays, s1.plays);

            if(result == 0)
                return Integer.compare(s1.num, s2.num);

            return Integer.compare(s2.plays, s1.plays);
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genreMap = new HashMap<>();
        Song[] songs = new Song[genres.length];

        for(int i = 0; i < genres.length; i++) {
            songs[i] = new Song(genres[i], plays[i], i);
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        for(Song s : songs) {
            s.count = genreMap.get(s.genre);
        }

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(songs, new SongComparator());

        for(Song s : songs) {
            if(map.get(s.genre) == null || map.get(s.genre) < 2) {
                map.put(s.genre, map.getOrDefault(s.genre, 0) + 1);
                list.add(s.num);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

//    public int[] solution(String[] genres, int[] plays) {
//        int[] answer = {};
//        HashMap<String, Integer> songs = new HashMap();
//
//        // 같은 장르로 play한 횟수
//        for (int i = 0; i < genres.length; i++) {
//            if (songs.containsKey(genres[i])) {
//                songs.put(genres[i], songs.get(genres[i]) + plays[i]);
//            } else {
//                songs.put(genres[i], plays[i]);
//            }
//        }
//
//        // 내림차순
//        List<String> genresList = new ArrayList<>(songs.keySet());
//        Collections.sort(genresList, (o1, o2) -> (songs.get(o2).compareTo(songs.get(o1))));
//
//        // 장르별 play
//        List<Integer> answerList = new ArrayList<>();
//        genresList.forEach(li -> {
//            HashMap<Integer, Integer> playsMap = new HashMap<>();
//            for (int i = 0; i < genres.length; i++) {
//                if (li.equals(genres[i])) {
//                    playsMap.put(i, plays[i]);
//                }
//            }
//
//            // 내림차순
//            List<Integer> playsList = new ArrayList<>(playsMap.keySet());
//            Collections.sort(playsList, (o1, o2) -> (playsMap.get(o2).compareTo(playsMap.get(o1))));
//
//            answerList.add(playsList.get(0));
//            if (playsList.size() != 1) {
//                answerList.add(playsList.get(1));
//            }
//        });
//
//        answer = new int[answerList.size()];
//
//        for (int idx = 0; idx < answerList.size(); idx++) {
//            answer[idx] = answerList.get(idx);
//        }
//
//        return answer;
//    }
}
