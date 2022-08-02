import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 1463 {
	
	static int []a;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		a = new int[n+1];
		System.out.println(go(n));

	}
	
	static int go(int n) {

		if(n==1) {
			return 0;
		}
		
		if(a[n]>0) {
			System.out.println(Arrays.toString(a));
			return a[n];
		}
		
		a[n] = go(n-1) + 1;
		
		if(n%2==0) {
			int temp = go(n/2) + 1;
			if(a[n] > temp) {
				a[n] = temp;
			}
		}
		if(n%3==0) {
			int temp = go(n/3) + 1;
			if(a[n]>temp) {
				a[n] = temp;
			}
		}
		
		System.out.println(Arrays.toString(a));
		return a[n];
	}
}
