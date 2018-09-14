import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> aPath = new ArrayList<>();

        transverse(root, sum, result, aPath);

        return result;
    }

    private void transverse(TreeNode root, int sum, List<List<Integer>> result, List<Integer> aPath) {
        if(root == null) return;
        else {
            aPath.add(root.val);
            if(listSum(aPath) == sum && root.left == null && root.right == null)
                result.add(new ArrayList(aPath));
            transverse(root.left, sum, result, aPath);
            transverse(root.right, sum, result, aPath);
            aPath.remove(aPath.size() - 1);
        }
    }

    private int listSum(List<Integer> aPath) {
        if(aPath.size() == 0) return 0;
        else{
            int sum = 0;
            for (int a : aPath) sum += a;
            return sum;
        }
    }
}

class PathSumIITest{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        new PathSumII().pathSum(root, 22);
    }
}