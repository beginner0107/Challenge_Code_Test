import java.util.Stack;
public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int cnt = 0;
        for (int k : moves) {
            int move = k - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][move] != 0) {
                    if (stack.peek() == board[j][move]) {
                        stack.pop();
                        cnt += 2;
                    } else {
                        stack.push(board[j][move]);
                    }
                    board[j][move] = 0;
                    break;
                }
            }
        }

        return cnt;
    }
}