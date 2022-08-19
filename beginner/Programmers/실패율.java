import java.util.*;
class 실패율 {
       public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int stage : stages){
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        double [] failureRate = new double[N+1];

        int total = stages.length;
        for(int i=1;i<=N;i++){
            double a = map.getOrDefault(i, 0);
            if(a==0.0&&total==0.0) continue;
            failureRate[i] = (double)(a/total);
            total -= a;
        }

        // 실패율을 구하고
        double []copy = Arrays.copyOfRange(failureRate, 0, failureRate.length);
        Arrays.sort(failureRate);
        int[]result = new int[N];

        int cnt = 0;
        for(int i=failureRate.length-1;i>=1;i--){
            for(int j=1;j<=copy.length;j++){
                if(failureRate[i]==copy[j]){
                    copy[j] = -1;
                    result[cnt++] = j;
                    break;
                }
            }
        }

        return result;
    }
}