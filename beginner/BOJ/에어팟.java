import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;
public class 에어팟 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>list = new ArrayList<>();
        list.add(0);
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        // 만약 다른 핸드폰이면 2%
        // 같은 핸드폰이면 그 전에 사용량이 temp 라면 temp * 2만큼 배터리 나간다.
        // 100퍼 넘으면 에어팟 연결 해제 그 사용량도 초기화
        int temp = 0;
        int usage = 0;
        boolean change = false;
        for(int i=1;i<list.size();i++){
            if (!change && Objects.equals(list.get(i - 1), list.get(i))){
                temp += usage * 2;
                usage *= 2;
            }else{
                usage = 2;
                temp += 2;
                change = false;
            }

            if(temp>=100){
                usage = 0;
                temp = 0;
                change = true;
            }
        }
        System.out.println(temp);
    }
}
