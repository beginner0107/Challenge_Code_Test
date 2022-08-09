package 재귀;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
	세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여있다.
 */
public class 하노이탑이동순서 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		if(N>20) return;
		bw.write((int)(Math.pow(2, N) -1)  + "\n");
		Hanoi(N, 1, 2, 3);
		
		bw.flush();
		bw.close();

	}
	
	public static void Hanoi(int n,int from, int mid, int to) throws IOException {
		
		if(n==1) {
			bw.write(from + " " + to + "\n");
			return;
		}
		
		if(n>=2) {
			Hanoi(n-1, from, to, mid);
			bw.write(from + " " + to + "\n");
			Hanoi(n-1, mid, from, to);
		}
	}

}
