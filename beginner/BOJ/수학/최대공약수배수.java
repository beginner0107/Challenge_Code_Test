package 수학;

import java.util.Scanner;

public class 최대공약수배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(gcd(n,m));
		System.out.println(lmc(gcd(n,m),n,m));
	}
	
	public static int gcd(int n, int m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	
	public static int lmc(int gcd,int n, int m) {
		return gcd*(n/gcd)*(m/gcd);
	}
}
