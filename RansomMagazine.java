import java.util.HashMap;
import java.util.Map;

public class RansomMagazine {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magOccurMap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            if (magOccurMap.containsKey(c)) {
                magOccurMap.put(c, magOccurMap.get(c) + 1);
            } else {
                magOccurMap.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (magOccurMap.containsKey(c)) {
                int left = magOccurMap.get(c) - 1;
                if (left < 0) {
                    return false;
                }
                magOccurMap.put(c, left);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean canConstructByArray(String ransomNote, String magazine) {
        int[] magazineArray = new int[26];

        for (char c : magazine.toCharArray()) {
            magazineArray[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--magazineArray[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RansomMagazine().canConstruct("kill", "aibcdfjkoll"));
        System.out.println(new RansomMagazine().canConstructByArray("kill", "aibcdfjkoll"));
        System.out.println(new RansomMagazine().canConstructByArray("a", "b"));
    }
}
