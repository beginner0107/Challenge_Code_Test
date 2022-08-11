import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class GoodWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            int len = str.length();
            stack.push(str.charAt(0));

            for(int j = 1; j < len; j++) {
                char c = str.charAt(j);
                if(!stack.isEmpty()) {
                    char top = stack.peek();
                    if(c == top) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(c);
            }

            if(stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
