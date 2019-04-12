import com.sun.javafx.image.IntPixelGetter;

import java.util.*;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++){
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new TopKFrequent().topKFrequent(new int[]{1}, 1));
    }
}
