import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightsideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        //result.add(root.val);

        ArrayDeque<TreeNode> arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> arrayDeque2 = new ArrayDeque<>();

        arrayDeque1.add(root);

        while (!arrayDeque1.isEmpty() || !arrayDeque2.isEmpty()){
            TreeNode levelLast = new TreeNode(0);
            while (!arrayDeque1.isEmpty()){
                TreeNode tmp = arrayDeque1.pollFirst();
                if(tmp.left != null) arrayDeque2.add(tmp.left);
                if(tmp.right != null) arrayDeque2.add(tmp.right);
                levelLast = tmp;
            }
            result.add(levelLast.val);
            ArrayDeque<TreeNode> tmpQueue = arrayDeque1;
            arrayDeque1 = arrayDeque2;
            arrayDeque2 = tmpQueue;
        }

        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new BinaryTreeRightsideView().rightSideView(root));
    }
}
