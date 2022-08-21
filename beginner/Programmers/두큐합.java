import java.util.ArrayDeque;
import java.util.Queue;
class 두큐합 {
    public long solution(int[] queue1, int[] queue2) {
        int sum = 0;
        long que1 = 0, que2 = 0;
        Queue<Integer>a1 = new ArrayDeque<>();
        Queue<Integer>a2 = new ArrayDeque<>();
        for(int i=0;i<queue1.length;i++){
          que1 += queue1[i];
            a1.add(queue1[i]);
            que2 += queue2[i];
            a2.add(queue2[i]);
            sum += queue1[i] + queue2[i];
        }

        int mid = sum / 2;
        int cnt = 0;
        long len = queue1.length * 3;


        while(cnt<len){
            cnt++;
            if(que1>que2){
                Integer poll = a1.poll();
                a2.add(poll);
                que1 -= poll;
                que2 += poll;
            }else if(que1<que2){
                Integer poll = a2.poll();
                a1.add(poll);
                que2 -= poll;
                que1 += poll;
            }else{
                return 0;
            }
            if(que1==que2)break;
        }

        return cnt==len?-1:cnt;
    }
}