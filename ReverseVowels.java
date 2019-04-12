import java.util.*;

public class ReverseVowels {
    public String reverseVowels(String s) {
        if(s == null || s.length() < 1) return s;
        char[] array = s.toCharArray();

        Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        List<Character> list = Arrays.asList(vowels);
        Set<Character> vowelSet = new TreeSet<>(list);

        int left = 0, right = array.length - 1;

        while (left < right){
            while (!vowelSet.contains(array[left])) left++;
            while (!vowelSet.contains(array[right])) right--;
            if(left < right) swap(array, left++, right--);
        }

        return String.valueOf(array);
    }

    void swap(char[] array, int left, int right){
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args){
        System.out.println(new ReverseVowels().reverseVowels("aeioudddAEIOU"));
    }
}
