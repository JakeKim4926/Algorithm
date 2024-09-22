package programmers;

import java.util.HashSet;

public class 전화번호목록 {
    public boolean solution(String[] phoneBook) {
        HashSet<String> set = new HashSet<>();
        for(String num : phoneBook)
            set.add(num);

        for(int i = 0 ; i < phoneBook.length; i++) {
            for(int j = 0 ; j < phoneBook[i].length(); j++) {
                if(set.contains(phoneBook[i].substring(0,j)))
                    return false;
            }
        }

        return true;
    }
}
