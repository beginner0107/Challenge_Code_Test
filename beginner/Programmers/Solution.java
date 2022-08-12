class Solution {
		public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		long current = n;

		if (k != 10) {
			while (current > 0) {
				sb.append(current % k);
				current /= k;
			}
		} else {
			sb.append(n);
		}

		sb.append(0);

		String[] a = null;
		if (k == 10) {
			a = sb.toString().split("0");
		} else {
			a = (sb.reverse() + "").split("0");
		}

		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals("") && isPrime(Long.parseLong(a[i]))) {
				answer++;
			}
		}

		return answer;
	}

	private boolean isPrime(long n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}