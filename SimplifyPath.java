import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] res = path.split("/");

        Deque<String> deque = new ArrayDeque<>();
        //String curDir = new String();
        for (String str : res) {
            switch (str) {
                case "":
                    break;
                case ".":
                    break;
                case "..":
                    if (!deque.isEmpty())
                        deque.removeLast();
                    break;
                default:
                    deque.add(str);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) sb.append("/");
        while (!deque.isEmpty()) {
            sb.append("/" + deque.pollFirst());
        }

        return sb.toString();
    }
}

class SimplifyPathTest {
    public static void main(String[] args) {
        new SimplifyPath().simplifyPath("/");
    }

}
