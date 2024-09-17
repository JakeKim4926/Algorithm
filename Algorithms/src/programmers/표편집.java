package programmers;

import java.util.*;

public class 표편집 {
    TreeSet<Integer> table = new TreeSet<>(); // 남아있는 행을 저장하는 TreeSet
    Stack<Integer> deleted = new Stack<>(); // 삭제된 행을 저장하는 스택

    // 초기 테이블 구성
        for (int i = 0; i < n; i++) {
        table.add(i);
    }

    int now = k;

        for (String temp : cmd) {
        char command = temp.charAt(0);

        if (command == 'U') {
            int X = Integer.parseInt(temp.split(" ")[1]);
            for (int i = 0; i < X; i++) {
                now = table.lower(now); // 남아있는 행에서 위로 이동
            }
        } else if (command == 'D') {
            int X = Integer.parseInt(temp.split(" ")[1]);
            for (int i = 0; i < X; i++) {
                now = table.higher(now); // 남아있는 행에서 아래로 이동
            }
        } else if (command == 'C') {
            deleted.push(now); // 현재 행 삭제
            table.remove(now); // 테이블에서 제거
            now = table.higher(now) != null ? table.higher(now) : table.lower(now); // 삭제 후 아래 행 선택, 없으면 윗 행 선택
        } else if (command == 'Z') {
            table.add(deleted.pop()); // 가장 최근에 삭제된 행 복구
        }
    }

    StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        if (table.contains(i)) {
            sb.append("O");
        } else {
            sb.append("X");
        }
    }

        return sb.toString();
}
}
