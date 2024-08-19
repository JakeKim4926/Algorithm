package programmers;

import java.util.*;
public class 여행경로 {
    private Map<String, PriorityQueue<String>> map;
    private List<String> result;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        result = new ArrayList<>();

        for (String[] ticket : tickets) {
            String departure = ticket[0];
            String arrival = ticket[1];

            PriorityQueue<String> destinations = map.get(departure);

            if (destinations == null) {
                destinations = new PriorityQueue<>();
                map.put(departure, destinations);
            }

            destinations.add(arrival);
        }

        dfs("ICN");

        return result.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = map.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        result.add(0, airport);
    }
}
