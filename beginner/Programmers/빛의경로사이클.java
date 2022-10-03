import java.util.ArrayList;
import java.util.Arrays;

public class 빛의경로사이클 {


    public static void main(String[] args) {
        빛의경로사이클 q = new 빛의경로사이클();
        System.out.println(Arrays.toString(q.solution(new String[]{"RS"})));
    }

    static int R, C;
    static int []dx = {-1,0,1,0}, dy = {0,-1,0,1}; // 아래, 왼쪽, 오른쪽, 위
    static boolean [][][] visited;

    public int[] solution(String[] grid) {
        ArrayList<Integer>list = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();
        visited = new boolean[R][C][4];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                for(int k=0;k<4;k++){
                    if(!visited[i][j][k]){
                        list.add(dfs(grid, i, j, k));
                    }
                }
            }
        }
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int dfs(String[]grid, int i, int j, int k){
        int cnt = 0;
        while(!visited[i][j][k]){
            cnt++;
            visited[i][j][k] = true;
            if(grid[i].charAt(j)=='L'){
                k = k==0 ? 3 : k - 1;
            }
            else if(grid[i].charAt(j)=='R'){
                k = k==3 ? 0 : k + 1;
            }

            i = (i + dx[k] + R) % R;
            j = (j + dy[k] + C) % C;
        }
        return cnt;
    }
}