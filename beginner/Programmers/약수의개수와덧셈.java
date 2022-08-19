import java.util.*;

public class 약수의개수와덧셈 {
    static int divisor(int n){
        int cnt = 1;
        boolean[] a = new boolean[n+1];
        a[1] = true;
        for(int i=2;i<n+1;i++){
            if(a[i]) continue;
            if(n%i==0) {
                cnt++;
                a[i] = true;
            }
            for(int j=i+i;j<n+1;j+=i){
                if(a[j]) continue;
                if(n%j==0){
                    a[j] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int solution(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++){
            int n = divisor(i);
            if(n%2==0) sum += i;
            else sum -= i;
        }

        return sum;
    }
}
