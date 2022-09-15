class 모음사전 {
    static int n;
    static int answer;
    static String[] words = new String[]{"A","E","I","O","U"};
    public int solution(String word) {
        n = 0;
        answer = 0;
        dfs("", word);
        return answer;
    }

    private void dfs(String ws, String word) {
        if(word.equals(ws)){
            answer = n;
            return;
        }
        if(ws.length()==5)return;
        for(int i=0;i<5;i++){
            ws += words[i]; // AAAAA
            n++;
            dfs(ws, word); //
            if(answer!=0) return;
            ws = ws.substring(0,ws.length()-1);
        }

    }
}