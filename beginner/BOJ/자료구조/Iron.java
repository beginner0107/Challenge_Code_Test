import java.util.Scanner;
import java.util.Stack;

public class Iron {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(1);
            }
            else{
                stack.pop();
                if(s.charAt(i-1)=='('){
                    answer += stack.size();
                }else{
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
