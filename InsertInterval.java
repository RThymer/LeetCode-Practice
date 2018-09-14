import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> results = new ArrayList<>();

        for(int index = 0; index < intervals.size() - 1; ){
            if(intervals.get(index).end >= intervals.get(index + 1).start){
                intervals.get(index + 1).start = intervals.get(index).start;
                if(intervals.get(index).end >= intervals.get(index + 1).end)
                    intervals.get(index + 1).end = intervals.get(index).end;
                intervals.remove(index);
                index = 0;
            }
            else index++;
        }

        return intervals;
    }

}


class InsertIntervalTest {
    public static void main(String[] args) {

        List<Interval> li= new ArrayList<>();
        li.add(new Interval(1,2));
        li.add(new Interval(3,5));
        li.add(new Interval(6,7));
        li.add(new Interval(8,10));
        System.out.println(new InsertInterval().insert(li, new Interval(4,8)));
    }
}
