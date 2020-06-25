import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    private class Node implements Comparable<Node> {
        char aChar;
        int freq;
        boolean isLeaf;
        Node left, right;

        Node(char ch, int freq) {
            this.aChar = ch;
            this.freq = freq;
            this.isLeaf = true;
        }

        Node(Node left, Node right, int freq) {
            this.left = left;
            this.right = right;
            this.freq = freq;
            this.isLeaf = true;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public Map<Character, String> encode(Map<Character, Integer> frequencyOfChar) {
        //优先队列按照放入对象其提供的比较器结果按大小放置
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Character c : frequencyOfChar.keySet()) {
            priorityQueue.add(new Node(c, frequencyOfChar.get(c)));
        }
        //计算最大的哈夫曼权值,同时构造左右子树关系;
        while (priorityQueue.size() != 1) {
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();
            //同时构建左右子树
            priorityQueue.add(new Node(node1, node2, node1.freq + node2.freq));
        }

        Map<Character, String> encodingForChar = new HashMap<>();
        genCode(priorityQueue.poll(), "", encodingForChar);
        return encodingForChar;
    }

    private void genCode(Node node, String encoding, Map<Character, String> encodingForChar) {
        if (node.isLeaf) {
            encodingForChar.put(node.aChar, encoding);
            return;
        }
        genCode(node.left, encoding + '0', encodingForChar);
        genCode(node.right, encoding + '1', encodingForChar);
    }
}
