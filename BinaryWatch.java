import java.util.*;

public class BinaryWatch {

    // 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
    //
    // 每个 LED 代表一个 0 或 1，最低位在右侧。
    //
    public static void main(String[] args) {

        System.out.println(new BinaryWatch().readBinaryWatch(1));

        new BinaryWatch().readBinaryWatchTraceBack(1);
    }

    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> numLight2DateMap = new HashMap<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                int onesInHour = getNumberOfOnes(hour);
                int onesInMinute = getNumberOfOnes(minute);
                List<String> timeList = numLight2DateMap
                        .getOrDefault(onesInHour + onesInMinute, new ArrayList<>());
                timeList.add(minute < 10 ? String.format("%s:0%s", hour, minute) : String.format("%s:%s", hour, minute));
                numLight2DateMap.put(onesInHour + onesInMinute, timeList);
            }
        }

        return numLight2DateMap.getOrDefault(num, new ArrayList<>());
    }

    private int getNumberOfOnes(int num) {
        int num2Calc = num;
        int numOfOnes = 0;
        while (num2Calc != 0) {
            if ((num2Calc & 1) == 1) {
                numOfOnes++;
            }
            num2Calc = num2Calc >> 1;
        }

        return numOfOnes;
    }

    public List<String> readBinaryWatchTraceBack(int num) {
        List<String> time = new ArrayList<>();
        if (num == 0) {
            time.add("0:00");
            return time;
        }
        doTrace(0, num, 0, time);

        Collections.sort(time);

        System.out.println(time);
        return time;
    }

    private void doTrace(int startTracePos, int numOfOnesLeft, int onesOccupied, List<String> result) {
        if (startTracePos >= 10 || numOfOnesLeft < 1) {
            return;
        }
        for (int i = startTracePos; i < 10; i++) {
            if (numOfOnesLeft == 1 && isValidTime(onesOccupied | (1 << i))) {
                int hour = getHour(onesOccupied | (1 << i));
                int minute = getMinute(onesOccupied | (1 << i));
                result.add(minute < 10 ? String.format("%s:0%s", hour, minute) : String.format("%s:%s", hour, minute));
            } else {
                doTrace(i + 1, numOfOnesLeft - 1, onesOccupied | (1 << i), result);
            }
        }
    }

    private boolean isValidTime(int time) {
        int hour = (time & 0X3C0) >> 6;
        int minute = time & 0X3F;

        return hour < 12 && minute < 60;
    }

    private int getHour(int time) {
        return (time & 0X3C0) >> 6;
    }

    private int getMinute(int time) {
        return time & 0X3F;
    }
}
