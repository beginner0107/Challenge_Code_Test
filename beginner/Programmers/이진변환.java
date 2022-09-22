class 이진변환 {
    public int[] solution(String s) {
        int[]answer = new int[2];

        while(s.length()!=1){
            answer[0]++;
            int len = s.length();
            s = s.replace("0", "");
            answer[1] += len - s.length();
            StringBuilder sb = new StringBuilder();
            int tmp = s.length();
            while(tmp>0){
                sb.append(tmp%2);
                tmp /= 2;
            }
            s = sb.reverse().toString();
        }
        return answer;
    }
}