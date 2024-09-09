package programmers;


public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 1;

        while(n > 1) {
            if(n % 2 == 1)
                ans++;

            n /= 2;
        }

        return ans;
    }
}

// 시간초과
//
//import java.util.*;
//
//public class Solution {
//    class IronMan{
//        int point;
//        int battery;
//
//        IronMan(int point, int battery) {
//            this.point = point;
//            this.battery = battery;
//        }
//    }
//
//    public int solution(int n) {
//        int ans = 0;
//
//        Queue<IronMan> bfs = new LinkedList<>();
//        bfs.add(new IronMan(1,1));
//
//        while(!bfs.isEmpty()) {
//            IronMan temp = bfs.poll();
//
//            if(temp.point > n)
//                continue;
//
//            if(temp.point == n)
//                return temp.battery;
//
//            bfs.add(new IronMan(temp.point + temp.point, temp.battery));
//            bfs.add(new IronMan(temp.point+1, temp.battery+1));
//        }
//
//
//        return ans;
//    }
//}