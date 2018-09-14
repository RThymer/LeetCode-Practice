import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingDNASequence{
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 10) return result;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length() - 10; ++i){
            String sub = s.substring(i, i + 10);
            if(map.containsKey(sub)) map.put(sub, map.get(sub) + 1);
            else map.put(sub, 1);
        }

        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(e.getValue() > 1) result.add(e.getKey());
        }
        return result;
    }

    public static void main(String[] args){
        new RepeatingDNASequence().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
