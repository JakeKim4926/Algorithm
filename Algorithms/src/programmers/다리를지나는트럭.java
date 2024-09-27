package programmers;

import java.util.*;

public class 다리를지나는트럭 {
    class Truck {
        int weight;
        int seconds;

        Truck(int weight, int seconds) {
            this.weight = weight;
            this.seconds = seconds;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> wait = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for(int truck : truck_weights)
            wait.add(truck);

        int nowWeight = 0;
        while(!wait.isEmpty() || !bridge.isEmpty()) {
            if(!bridge.isEmpty()) {
                int size = bridge.size();
                for(int i = 0; i < size; i++) {
                    Truck temp = bridge.poll();
                    bridge.add(new Truck(temp.weight, temp.seconds-1));
                }

                if(bridge.peek().seconds <= 0)
                    nowWeight -= bridge.poll().weight;
            }

            if(!wait.isEmpty()) {
                if(nowWeight + wait.peek() <= weight) {
                    int newWeight = wait.poll();
                    bridge.add(new Truck(newWeight, bridge_length));
                    nowWeight += newWeight;
                }
            }

            answer++;
        }

        return answer;
    }
}
