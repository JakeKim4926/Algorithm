package programmers;

import java.util.*;

public class 합승택시요금 {

    class Solution {
        class Taxi {
            int next;
            int money;

            Taxi(int next, int money) {
                this.next = next;
                this.money = money;
            }
        }

        ArrayList<Taxi>[] map;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = Integer.MAX_VALUE;

            map = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++)
                map[i] = new ArrayList<>();

            for(int i = 0; i < fares.length; i++) {
                map[fares[i][0]].add(new Taxi(fares[i][1], fares[i][2]));
                map[fares[i][1]].add(new Taxi(fares[i][0], fares[i][2]));
            }

            int[] dijkS = new int[n+1];
            int[] dijkA = new int[n+1];
            int[] dijkB = new int[n+1];

            // ★★★★★
            // with Array == O(n^2)
            // with PriorityQueue == O(log n)
            dijkstra(s, dijkS);
            dijkstra(a, dijkA);
            dijkstra(b, dijkB);

            for(int i = 1; i <= n; i++)
                answer = Math.min(answer, dijkS[i] + dijkA[i] + dijkB[i]);

            return answer;
        }

        public void dijkstra(int start, int[] dijk) {
            Arrays.fill(dijk, Integer.MAX_VALUE);
            dijk[start] = 0;

            PriorityQueue<Taxi> pq = new PriorityQueue<>((o1, o2) -> o1.money - o2.money);
            pq.add(new Taxi(start, 0));

            while(!pq.isEmpty()) {
                Taxi current = pq.poll();

                if(dijk[current.next] < current.money)
                    continue;

                for(Taxi taxi : map[current.next]) {
                    int newCost = dijk[current.next] + taxi.money;

                    if(newCost < dijk[taxi.next]) {
                        dijk[taxi.next] = newCost;
                        pq.add(new Taxi(taxi.next, newCost));
                    }
                }
            }
        }
    }

}
