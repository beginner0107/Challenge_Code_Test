import java.util.Scanner;

public class 테트로미노 {
	static int[][][] block = { { { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 1, 0 }, { 2, 0 }, { 3, 0 } },
			{ { 1, 0 }, { 1, 1 }, { 1, 2 } }, { { 0, 1 }, { 1, 0 }, { 2, 0 } }, { { 0, 1 }, { 0, 2 }, { 1, 2 } },
			{ { 1, 0 }, { 2, 0 }, { 2, -1 } }, { { 1, 0 }, { 1, -1 }, { 1, -2 } }, { { 1, 0 }, { 2, 0 }, { 2, 1 } },
			{ { 0, 1 }, { 0, 2 }, { 1, 0 } }, { { 0, 1 }, { 1, 1 }, { 2, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 } },
			{ { 0, 1 }, { -1, 1 }, { -1, 2 } }, { { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 0, 1 }, { 1, 1 }, { 1, 2 } },
			{ { 1, 0 }, { 1, -1 }, { 2, -1 } }, { { 0, 1 }, { 0, 2 }, { -1, 1 } }, { { 0, 1 }, { 0, 2 }, { 1, 1 } },
			{ { 1, 0 }, { 2, 0 }, { 1, 1 } }, { { 1, 0 }, { 2, 0 }, { 1, -1 } }, };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<19;k++) {
					int sum = a[i][j];
					boolean ok = true; 
					for(int l=0;l<3;l++) {
						int x = i + block[k][l][0];
						int y = j + block[k][l][1];
						
						if(x<n&&x>=0&&y<m&&y>=0) {
							sum += a[x][y];
						}else {
							ok = false;
							break;
						}
					}
					if(ok && ans<sum) {
						ans = sum;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}