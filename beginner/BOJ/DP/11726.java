import java.util.*;
public class 11726 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 10007;
        }
        System.out.println(arr[n]);
    }
}