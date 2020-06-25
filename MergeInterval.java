import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> results = new ArrayList<>();

        for (int index = 0; index < intervals.size() - 1; ) {
            if (intervals.get(index).end >= intervals.get(index + 1).start) {
                intervals.get(index + 1).start = intervals.get(index).start;
                if (intervals.get(index).end >= intervals.get(index + 1).end)
                    intervals.get(index + 1).end = intervals.get(index).end;
                intervals.remove(index);
                index = 0;
            } else index++;
        }

        return intervals;
    }


}

class MergeIntervalTest {
    public static void main(String[] args) {

        List<Interval> li = new ArrayList<>();
        li.add(new Interval(1, 4));
        li.add(new Interval(0, 2));
        li.add(new Interval(3, 5));
        //li.add(new Interval(15,18));
        System.out.println(new MergeInterval().merge(li));
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public String toString() {
        return "[" + start + "," + end + "]";
    }
}