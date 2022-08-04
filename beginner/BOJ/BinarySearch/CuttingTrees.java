import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuttingTrees {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long max = 0;
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, height[i]);
        }

        long left = 0, right = max;
        long answer = 0;
        while(left<=right){
            long mid = (left + right)/2;
            long sum = 0;
            for(int tree : height){
                if(tree > mid){
                    sum += tree - mid;
                }
            }
            if (sum >= m) {
                left = mid + 1;
                answer = Math.max(mid, answer);
            }else{
                right = mid -1;
            }
        }
        System.out.println(answer);
    }

}
