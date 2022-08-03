
import java.util.Arrays;

/*
    피보나치
    memorization
 */
public class 피보나치수 {

    public static void main(String[] args) {
        System.out.println(fibonacci(44));
    }

    public static int fibonacci(int n) {
        int answer = 0;
        int a = 0, b = 1;

        for(int i=2;i<=n;i++){
            answer = (a + b) %1234567; //
            a = b;
            b = answer;
        }
        return answer;
    }
}
