import java.util.LinkedHashMap;
import java.util.Set;
class 성격유형검사하기 {
    static LinkedHashMap<String, Integer> map= new LinkedHashMap<>();
    public String solution(String[] survey, int[] choices) {
        createMap();

        for(int i=0;i<survey.length;i++){
            String[]str = survey[i].split("");
            int choice = choices[i];
            if(choice==1||choice==2||choice==3){
                switch (choice){
                    case 1:
                        map.put(str[0], map.getOrDefault(str[0], 0) + 3);
                        break;
                    case 2:
                        map.put(str[0], map.getOrDefault(str[0], 0) + 2);
                        break;
                    case 3:
                        map.put(str[0], map.getOrDefault(str[0], 0) + 1);
                        break;
                }
            }
            else if(choice==5||choice==6||choice==7){
                switch (choice){
                    case 5:
                        map.put(str[1], map.getOrDefault(str[1], 0) + 1);
                        break;
                    case 6:
                        map.put(str[1], map.getOrDefault(str[1], 0) + 2);
                        break;
                    case 7:
                        map.put(str[1], map.getOrDefault(str[1], 0) + 3);
                        break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<String> key = map.keySet();

        int temp = 0;
        int cnt = 0;
        int score = 0;
        String s1 = "";
        String s2 = "";

        for(String sKey : key){
            cnt++;
            if(cnt==2){
                cnt = 0;
                temp = map.get(sKey);
                s2 = sKey;
                if(temp>score){
                    sb.append(s2);
                }else if(score>temp){
                    sb.append(s1);
                }else{
                    if(s1.toCharArray()[0] - s2.toCharArray()[0]<0){
                        sb.append(s1);
                    }else{
                        sb.append(s2);
                    }
                }
            }else{
                score = map.get(sKey);
                s1 = sKey;
            }
        }

        return sb.toString();
    }

    private void createMap() {
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
    }
}