import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] chars = skill.toCharArray();
        List<Character> skillList = new ArrayList<>();
        for(Character c : chars) {
            skillList.add(c);
        }

        for(String skill_tree : skill_trees) {
            int idx = 0;
            boolean isUse = true;

            for(int i = 0; i < skill_tree.length() && idx < skill.length(); i ++) {
                if(skill_tree.charAt(i) == skill.charAt(idx)) {
                    idx++;
                    isUse = true;
                }
                else {
                    if(skillList.contains(skill_tree.charAt(i))) {
                        isUse = false;
                        break;
                    }
                }
            }
            if(isUse) answer++;
        }

        return answer;
    }
}
