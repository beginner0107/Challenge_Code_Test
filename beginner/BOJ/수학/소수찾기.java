package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(str.nextToken());
			if(isPrime(num)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isPrime(int k) {
		if(k==0||k==1) return false;
		for(int i=2;i<=Math.sqrt(k);i++) {
			if(k%i==0) return false;
		}
		return true;
	}
}
