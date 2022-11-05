import java.util.*;

public class 압축 {

    static HashMap<String, Integer> dictionary;

    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        dictionary = new HashMap<>();

        char start = 'A';
        for(int i=1;i<=26;i++){
            dictionary.put(String.valueOf(start++), i);
        }
        int startI = 27;

        // 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        for(int i=0;i<msg.length();i++){
            StringBuilder w = new StringBuilder(String.valueOf(msg.charAt(i)));
            boolean isOk = false;
            while(dictionary.containsKey(w.toString())){
                i++;
                if(msg.length()==i) {
                    isOk = true;
                    break;
                }
                w.append(msg.charAt(i));
            }

            if(isOk){
                answer.add(dictionary.get(w.toString()));
                break;
            }
            answer.add(dictionary.get(w.substring(0, w.length()-1)));
            dictionary.put(w.toString(), startI++);
            i--;
        }


        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        압축 s = new 압축();
        System.out.println(Arrays.toString(s.solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
