import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Budget {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지방의 수
        int n = Integer.parseInt(br.readLine());
        // 지방의 예산요청을 요청하는 N개의 정수가 빈칸을 사이에 두고 주어진다.
        int a[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());

        long left = 0;
        long right = a[n-1];

        long answer = 0;
        while(left<=right){
            long mid = (left + right)/2;
            long sum = 0;
            for(int money : a){
                if(money>=mid){
                    sum += mid;
                }else{
                    sum += money;
                }
            }
            if(sum<=m){
                left = mid + 1;
                answer = Math.max(mid, answer);
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
