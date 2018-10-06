import java.util.*;

public class StringExpressionValue {
    public int calculate(String s) {
        String nonBlank = s.replace(" ", "");
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();

        for(int index = 0; index < nonBlank.length();){
            if(nonBlank.charAt(index) == '*' || nonBlank.charAt(index) == '/'){
                char op = nonBlank.charAt(index);
                int o1 = nums.pollLast();
                int o2 = nextInt(nonBlank, ++index);

                while (index < nonBlank.length() &&
                        !isOprand(nonBlank, index)) index++;

                if(op == '*') nums.addLast(o1 * o2);
                if(op == '/') nums.addLast(o1 / o2);
            }else if(nonBlank.charAt(index) == '+' || nonBlank.charAt(index) == '-'){
                operator.addLast(nonBlank.charAt(index));
                ++index;
            }else {
                nums.addLast(nextInt(nonBlank, index));
                while (index < nonBlank.length() &&
                        !isOprand(nonBlank, index)){
                    index++;
                }
            }
        }

        while (!operator.isEmpty()){
            char op = operator.pollFirst();
            int o1 = nums.pollFirst();
            int o2 = nums.pollFirst();
            if(op == '+') nums.addFirst(o2 + o1);
            if(op == '-') nums.addFirst(o1 - o2);
        }
        return nums.pollFirst();
    }

    private static int nextInt(String s, int index){
        char c = s.charAt(index);
        if(c < '0' || c > '9') return -1;
        int result = 0;
        while (c >= '0' && c <= '9'){
            result = result * 10 + (c - '0');
            if(index == s.length() - 1) break;
            c = s.charAt(++index);
        }
        return result;
    }
    private static boolean isOprand(String s, int index){
        char c = s.charAt(index);
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //使用正则表达式匹配选取各个数、符号
    //Runtime > 1000ms
    public int calculate(String s, boolean useRegex, boolean useSwitch) {
        String nonBlank = s.replace(" ", "");
        List numString = Arrays.asList(nonBlank.split("\\+|\\-|\\*|\\/"));
        List oprandString = Arrays.asList(nonBlank.split("[0-9]+"));
        List<Integer> nums = new ArrayList<>();
        List<Character> oprands = new ArrayList<>();
        for (Object o : numString) nums.add(Integer.parseInt((String) o));
        for (int i = 1; i < oprandString.size(); ++i)
            oprands.add(((String) oprandString.get(i)).charAt(0));

        for(int index = 0; index < oprands.size(); ++index){
            if(oprands.get(index) == '*' || oprands.get(index) == '/'){
                int op1 = nums.get(index);
                int op2 = nums.get(index + 1);
                char op = oprands.get(index);
                if(op == '*') nums.set(index, op1 * op2);
                else nums.set(index, op1 / op2);
                nums.remove(index + 1);
                oprands.remove(index);
                index--;
            }
        }
        for(int index = 0; index < oprands.size(); ++index){
            if(oprands.get(index) == '+' || oprands.get(index) == '-'){
                int op1 = nums.get(index);
                int op2 = nums.get(index + 1);
                char op = oprands.get(index);
                if(op == '+') nums.set(index, op1 + op2);
                else nums.set(index, op1 - op2);
                nums.remove(index + 1);
                oprands.remove(index);
                index--;
            }
        }
        return nums.get(0);
    }

    public static void main(String[] args){
        System.out.println(
                new StringExpressionValue().
                        calculate(" 15 / 3 - 2 + 1 ", true, false));
    }
}
