import java.util.*;
class Solution {
        public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : entryList) {
            sum += entry.getValue();
            answer ++;
            if(sum >= k) break;
        }

        return answer;
    }
}