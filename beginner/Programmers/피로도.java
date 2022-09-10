class 피로도 {
    static boolean[]visited;

    static int max = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        recursion(k, dungeons, 0);

        return max;
    }

    private void recursion(int k, int[][] dungeons, int cnt) {
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i]&&dungeons[i][0]<=k){
                visited[i] = true;
                recursion(k - dungeons[i][1], dungeons, cnt+1);
                visited[i] = false;
            }
        }
        max = Math.max(max, cnt);
    }
}