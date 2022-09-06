public class 카카오프렌즈컬러링북 {

    static int dx[] = {0,0,-1,1};
    static int dy[] = {1,-1,0,0};

    static int size = 0;
    static boolean[][] c;

    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        // 탐색을 했던 곳을 안 가기 위해서
        c = new boolean[m][n];
        // 영역 개수 count
        int cnt = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 영역의 크기를 잴
                size = 0;
                int area = picture[i][j];
                extracted(picture, i, j, area);
                if(size!=0){
                    answer[0]++;
                    answer[1] = Math.max(answer[1], size);
                }
            }
        }

        return answer;
    }

    private static void extracted(int[][] picture, int i, int j, int area) {
        if(!c[i][j]&&area!=0){ //true 인 경우 탐색이 끝났으므로..
            size++;
            c[i][j] = true;
            for(int k=0;k<4;k++){
                int x = i + dx[k];
                int y = j + dy[k];
                if(x>=0&&y>=0&&x< picture.length &&y< picture[0].length){
                    if(area == picture[x][y]){
                        extracted(picture, x, y, area);
                    }
                }
            }
        }
    }
}
