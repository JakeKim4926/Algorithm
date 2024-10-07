package programmers;

public class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for(int i = 0 ; i < name.length(); i++) {
            answer += Math.min('Z' - name.charAt(i) + 1 , name.charAt(i) - 'A');
        }

        if(name.length() == 1)
            return answer;

        for(int i = 0; i < name.length(); i++) {
            int count = 0;
            int idx = i+1;
            while(idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }

            move =  Math.min(move, i * 2 + name.length() - idx);
            move =  Math.min(move, (name.length() - idx) * 2 + i);
        }

        answer += move;
        return answer;
    }
}
