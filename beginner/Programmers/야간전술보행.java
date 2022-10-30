import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 1. 화랑이가 움직이는 부분
 * 2. 경비병이 근무, 휴식 취하는지 확인하는 파트 (1, 0)
 */
public class 야간전술보행 {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;
        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 0; i < scope.length; i++) {
            int startMonitoredZones = Math.min(scope[i][0], scope[i][1]);
            int endMonitoredZones = Math.max(scope[i][0], scope[i][1]);

            int startTime = times[i][0];
            int endTime = times[i][1];

            boolean[] c = new boolean[distance + 1];
            int start = 1;
            loop:
            while (start < distance) {
                for (int k = start; k < start + startTime; k++) {
                    if(k>distance) break loop;
                    c[k] = true;
                }
                start = start + startTime + endTime;
            }

            int j;
            for (j = startMonitoredZones; j <= endMonitoredZones; j++) {
                if (c[j]) {
                    break;
                }
            }
            if(j == endMonitoredZones + 1){
                j = distance;
            }
            list.add(j);
        }
        Collections.sort(list);
        answer = list.get(0);
        return answer;
    }


}
