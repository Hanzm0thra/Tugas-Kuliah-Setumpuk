package sem2.asd.praktikum.bst;

import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    private TreeNode root;
    private ArrayList<Integer> arrPostorder = new ArrayList<>();
    private ArrayList<Integer> arrPreorder = new ArrayList<>();

    public Solution() {
        root = null;
    }

    public void sisipDtNode(int dtSisip) {
        if (root == null)
            root = new TreeNode(dtSisip);
        else
            root.sisipDt(dtSisip);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        arrPreorder.add(treeNode.data);
        preorder(treeNode.treeNodeKiri);
        preorder(treeNode.treeNodeKanan);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(TreeNode treeNode) {
        if (treeNode == null)
            return ;
        postorder(treeNode.treeNodeKiri);
        postorder(treeNode.treeNodeKanan);
        arrPostorder.add(treeNode.data);
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int node = scanner.nextInt();
            solution.sisipDtNode(node);
        }

        solution.postorderTraversal();
        solution.preorderTraversal();

        for (int index = 0; index < solution.arrPostorder.size(); index++) {
            System.out.print(solution.arrPostorder.get(index) - solution.arrPreorder.get(index) + " ");
        }
    }
}

class TreeNode {
    int data;
    TreeNode treeNodeKiri;
    TreeNode treeNodeKanan;
    TreeNode next;

    public TreeNode(int dt){
        data = dt;
        treeNodeKiri = treeNodeKanan = null;
        this.next = null;
    }

    public void sisipDt(int dtSisip ){

        if (dtSisip < data){
            if(treeNodeKiri == null)
                treeNodeKiri = new TreeNode( dtSisip );
            else treeNodeKiri.sisipDt( dtSisip );
        }

        else if(dtSisip > data){
            if ( treeNodeKanan == null )
                treeNodeKanan = new TreeNode(dtSisip);
            else treeNodeKanan.sisipDt(dtSisip);
        }
    }
}
