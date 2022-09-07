import java.util.HashMap;

public class 단체사진찍기 {

    static String[]d;
    static boolean[]visited;
    static int[] ints;
    static HashMap<Character, Integer> map;
    static int answer;
    public int solution(int n, String[] data) {
        d = data;
        ints = new int[8];
        map = new HashMap<>();
        visited = new boolean[8];
        answer = 0;
        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        dfs(0);

        return answer;
    }

    private void dfs(int idx) {
        if(idx==8){
            if(check()) answer++;
        }
        else{
            for(int i=0;i<8;i++){
                if(!visited[i]){
                    visited[i] = true;
                    ints[idx] = i;
                    dfs(idx+1);
                    visited[i] = false;
                }
            }
        }
    }

    private boolean check() {
        int a, b, res;
        char op;
        for(String s : d){
            a = ints[map.get(s.charAt(0))];
            b = ints[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = (s.charAt(4) - '0') + 1;
            switch (op){
                case '=':
                    if(res != Math.abs(a-b)) return false;
                    break;
                case '>':
                    if(res >= Math.abs(a-b)) return false;
                    break;
                case '<':
                    if(res <= Math.abs(a-b)) return false;
                    break;
            }
        }
        return true;
    }

}