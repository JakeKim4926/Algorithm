package programmers;

import java.util.*;

public class 단어변환 {
    class Point{
        String word;
        int count;

        Point(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visit = new boolean[words.length];

        Queue<Point> bfs = new LinkedList<>();
        bfs.add(new Point(begin, 0));

        while(!bfs.isEmpty()) {
            Point temp = bfs.poll();

            if(temp.word.equals(target)) {
                return temp.count;
            }

            for(int i = 0; i < words.length; i++) {
                if(visit[i])
                    continue;

                int count = 0;
                for(int j = 0; j < temp.word.length(); j++) {
                    if(words[i].charAt(j) == temp.word.charAt(j))
                        count++;
                }

                if(count == target.length()-1) {
                    visit[i] = true;
                    bfs.add(new Point(words[i], temp.count+1));
                }
            }


        }

        return answer;
    }
}
