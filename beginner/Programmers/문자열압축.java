public class 문자열압축 {
    public static int solution(String s) {
        int answer = s.length();

        // 1. 몇 개씩 자를지 for 문 (처음 기준점 1부터 시작),
        // 압축 레벨이 절반을 넘어갈 시에는 압축이 되지 않으므로 ...
        for(int i=1;i<=s.length()/2;i++){
            // 첫 패턴을 저장
            String pattern = s.substring(0, i);
            // 압축 레벨을 설정해야 함
            int level = 1;
            // 압축 될 문자열이 저장될 StringBuilder
            StringBuilder sb = new StringBuilder();
            // 2. 두번 째 for 문을 돌면서 압축된 문자열을 StringBuilder 에 append
            // j <= s.length()로 만든 이유 마지막 압축된 문자열을 넣기 위해서
            // 반복문을 한번 더 돌려 next = "" 공백값이 되면서 else문으로 진입 
            // pattern을 공백으로 바꾸며 마지막 압축된 문자열까지 추가 완료
            for(int j=i;j<=s.length();j+=i){
                // 문자열을 자른다.
                String next = s.substring(j, Math.min(j+i, s.length()));
                // equal 연산
                if(pattern.equals(next)){
                    level ++;
                }else{
                    sb.append(level>1?level:"").append(pattern);
                    pattern = next;
                    level = 1; // 중복 횟수를 초기화
                }
            }
            // 마지막에 남은 pattern 을 추가
            sb.append(pattern);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
