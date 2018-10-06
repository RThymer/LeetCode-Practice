import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TransverseBinaryTree {
    public static void preOrderRecursive(TreeNode root){
        if(root != null){
            System.out.print(root.val);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }
    public static void inOrderRecursive(TreeNode root){
        if(root != null){
            inOrderRecursive(root.left);
            System.out.print(root.val);
            inOrderRecursive(root.right);
        }
    }
    public static void postOrderRecursive(TreeNode root){
        if(root != null){
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.print(root.val);
        }
    }
    public static void preOrderNonRecursive(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        while (iter != null || !stack.empty()){
            while (iter != null){
                System.out.print(iter.val);
                stack.push(iter);
                iter = iter.left;
            }
            if (!stack.empty()){
                iter = stack.pop();
                iter = iter.right;
            }
        }
        System.out.println();
    }
    public static void inOrderNonRecursive(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode iter = root;
        while (iter != null || !stack.empty()){
            while (iter != null){
                stack.push(iter);
                iter = iter.left;
            }
            if (!stack.empty()){
                iter = stack.pop();
                System.out.print(iter.val);
                iter = iter.right;
            }
        }
        System.out.println();
    }
    public static void postOrderNonRecursive(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode iter = stack.pop();
            list.add(iter.val);
            if(iter.left != null) stack.push(iter.left);
            if(iter.right != null) stack.push(iter.right);
        }
        for(int i = list.size() - 1; i >= 0; --i){
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    public static TreeNode buildTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args){
        TreeNode root = buildTree();

        preOrderRecursive(root);
        System.out.println();

        inOrderRecursive(root);
        System.out.println();

        postOrderRecursive(root);
        System.out.println();

        preOrderNonRecursive(root);
        inOrderNonRecursive(root);
        postOrderNonRecursive(root);
    }
}
