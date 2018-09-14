import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> validIP = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int length = s.length();
        if (length > 12 || length < 4) return validIP;

        for (int num1 = 1; num1 < 4; num1++) {
            for (int num2 = 1; num2 < 4; num2++) {
                for (int num3 = 1; num3 < 4; num3++) {
                    int num4 = length - num1 - num2 - num3;
                    if (num4 > 0 && num4 < 4) {
                        String s1 = s.substring(0, num1);
                        String s2 = s.substring(num1, num1 + num2);
                        String s3 = s.substring(num1 + num2, num1 + num2 + num3);
                        String s4 = s.substring(num1 + num2 + num3, length);
                        if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                            sb.append(s1).append('.').append(s2).append('.').append(s3).append('.').append(s4);
                            validIP.add(sb.toString());
                            sb.delete(0, sb.length());
                        }


                    }
                }
            }
        }
        return validIP;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() < 1 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        else return true;
    }
}

class RestoreIPTest{
    public static void main(String[] args) {
        new RestoreIP().restoreIpAddresses("25525511135");
    }
}