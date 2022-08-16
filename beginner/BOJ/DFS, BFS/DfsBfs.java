import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class DfsBfs {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째 줄에는 정점의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 간선의 개수 M
        int M = Integer.parseInt(st.nextToken());
        // 탐색을 시작할 정점의 번호 V
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
    }

    private static void bfs(int V) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[V] = true;
        queue.add(V);
        System.out.print(V + " ");
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i=1;i<arr.length;i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
            if(!queue.isEmpty()) System.out.print(queue.peek() + " ");
        }
    }

    private static void dfs(int V) {
        if(V == arr.length)return;
        visited[V] = true;
        System.out.print(V + " ");

        for(int i=1;i<arr.length;i++){
            if(arr[V][i]==1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

}