package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 개어려움 계속 틀림
public class 퇴사 {
	static int N;
	
	static int pi[];
	static int ti[];
	
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		pi = new int[N+1];
		ti = new int[N+1];
		
		StringTokenizer st = null;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			pi[i] = Integer.parseInt(st.nextToken());
			ti[i] = Integer.parseInt(st.nextToken());
		}
		
		go(1,0);
		
		System.out.println(ans);
	}
	
	static void go(int day, int sum) {
		if(day==N+1) {
			if(ans<sum) ans = sum;
			return;
		}
		
		if(day>N+1) {
			return;
		}
		go(day+1, sum);
		go(day+pi[day], sum + ti[day]);
	}
}
