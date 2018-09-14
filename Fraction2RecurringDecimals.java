import java.util.HashMap;

public class Fraction2RecurringDecimals {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isPositive = true;
        boolean isRepeated = false;
        long divided = numerator, divide = denominator;
        if(divided == 0) return "0";
        if(divided > 0 && divide < 0) isPositive = false;
        if(divided < 0 && divide > 0) isPositive = false;
        divided = Math.abs(divided);
        divide = Math.abs(divide);

        long intPart = divided / divide;
        long remaining = divided % divide;

        int order = 1;
        long produce = 0;
        int repeatPos = 0;
        HashMap<Integer, Long> produceMap = new HashMap<>();
        HashMap<Integer, Long> remainMap = new HashMap<>();

        while (!isRepeated){
            produce = (remaining * 10) / divide;
            remaining = (remaining * 10) % divide;
            for(int index = 1; index < order; ++index) {
                if (produceMap.get(index) == produce &&
                        remainMap.get(index) == remaining){
                    repeatPos = index;
                    isRepeated = true;
                }
            }
            produceMap.put(order, produce);
            remainMap.put(order, remaining);
            order++;
        }

        produceMap.remove(order - 1);
        StringBuilder sb = new StringBuilder();
        for(int key = 1; key < produceMap.size() + 1; ++key){
            if (key == repeatPos) sb.append('(');
            sb.append(produceMap.get(key));
        }
        sb.append(')');
        if(sb.lastIndexOf("0") == sb.length() - 2)
            sb.deleteCharAt(sb.length() - 2);
        if(sb.lastIndexOf(")") == sb.length() - 1 &&
                sb.lastIndexOf("(") == sb.length() - 2){
            sb.delete(sb.length() - 2, sb.length());
        }
        String unsignedResult = sb.length() == 0 ?
                String.valueOf(intPart) :
                intPart + "." + sb.toString();
        return isPositive ? unsignedResult : '-' + unsignedResult;
    }

    public static void main(String[] args){
        System.out.println(
                new Fraction2RecurringDecimals().
                        fractionToDecimal(1,2));
    }
}
