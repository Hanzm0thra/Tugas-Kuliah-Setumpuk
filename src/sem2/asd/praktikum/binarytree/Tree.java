package sem2.asd.praktikum.binarytree;

import java.util.Scanner;

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

class TreeQueue {

    TreeNode head = null;
    TreeNode tail = null;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(TreeNode input) {
        if (size == 0) {
            head = input;
        } else {
            tail.next = input;
        }
        tail = input;
        size++;
    }

    public TreeNode dequeue() {
        if (isEmpty()) {
            return null;
        }

        TreeNode current = head;
        head = head.next;
        size--;
        return current;
    }
}

public class Tree {
    private TreeNode root;
    private boolean isLeft = false;

    public Tree() {
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
        if (treeNode == null) return;

        System.out.printf("%d ", treeNode.data);
        preorder(treeNode.treeNodeKiri);
        preorder(treeNode.treeNodeKanan);
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(TreeNode treeNode) {
        if (treeNode == null) return;
        inorder(treeNode.treeNodeKiri);
        System.out.printf("%d ", treeNode.data);
        inorder(treeNode.treeNodeKanan);
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(TreeNode treeNode) {
        if (treeNode == null) return;
        postorder(treeNode.treeNodeKiri);
        postorder(treeNode.treeNodeKanan);
        System.out.printf("%d ", treeNode.data);
    }

    public void levelOrder() {
        TreeQueue queue = new TreeQueue();
        if (root != null) {
            queue.enqueue(root);
            levelOrder(queue);
        }
    }

    public void levelOrder(TreeQueue queue) {
        if (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.print(node.data + " ");

            if (node.treeNodeKiri != null) {
                queue.enqueue(node.treeNodeKiri);
            }

            if (node.treeNodeKanan != null) {
                queue.enqueue(node.treeNodeKanan);
            }

            levelOrder(queue);
        }
    }

    public static void main(String args[]) {
        Tree tree = new Tree();

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        System.out.print("Preorder traversal\n");
        tree.preorderTraversal();
        System.out.print("Inorder traversal\n");
        tree.inorderTraversal();
        System.out.print("Postorder traversal\n");
        tree.postorderTraversal();
    }
}