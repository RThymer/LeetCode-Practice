import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o1 + o2);
            } else if (s.equals("-")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o1 - o2);
            } else if (s.equals("*")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o1 * o2);
            } else if (s.equals("/")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                stack.push(o2 / o1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] notation = {"2", "1", "+", "3", "*"};
        ReversePolishNotation reversePolishNotation = new
                ReversePolishNotation();
        System.out.println(reversePolishNotation.evalRPN(notation));
    }
}
