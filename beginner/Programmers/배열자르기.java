public class 배열자르기 {
    public int[] solution(int n, long left, long right) {
        int cnt = 0;
        int[]result = new int[(int)right+1-(int)left];
        for(long i=left;i<right+1;i++) result[cnt++] = (int) Math.max(i/n+1, i%n+1);
        return result;
    }
}
