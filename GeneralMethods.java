public class GeneralMethods {

    public static void main(String[] args) {
        System.out.println(new GeneralMethods().isPowerOfThree(27));

        LRU_Use_LinkedHashMap<String, Integer> lru = new LRU_Use_LinkedHashMap<>(5);
        lru.put("1", 1);
        lru.put("2", 2);
        System.out.println(lru);
        lru.put("3", 3);
        lru.put("4", 4);
        System.out.println(lru);
        lru.get("2");
        System.out.println(lru);

    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}