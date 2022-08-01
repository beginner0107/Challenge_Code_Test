import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M;i<=N;i++) {
			if(sosu(i)) {
				System.out.println(i);
			}
		}
	}
	
	
	public static boolean sosu(int n) {
		if(n==1) return false;
		
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
}
