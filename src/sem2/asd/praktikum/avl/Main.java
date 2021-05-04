package sem2.asd.praktikum.avl;

import java.util.Scanner;

public class Main{
    //Jangan ubah kode kelas Main
    //Jangan ubah kode kelas Main
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        AVLTree2 tree = insertTo(new AVLTree2(),
                in.nextLine().split(" "));
        System.out.println(tree.getHeight(in.nextByte()));
    }
    public static AVLTree2 insertTo(AVLTree2 tree, String[] arr){
        for(String x : arr)
            tree.root = tree.insert(tree.root,
                    Integer.parseInt(x));
        return tree;
    }
}
class AVLTree2
{
    //Lengkapi gungsi getHeight untuk menyelesaikan permasalahan
    //Fungsi getHeight digunakan untuk mendapatkan tinggi dari node yang dicari
    //Boleh membuat fungsi baru dalam kelas AVLTREE
    // **************************************************************************************
    AvlNode root;

    int getHeight(int search){
        //Lengkapi fungsi ini
        AvlNode current = root;
        while (current != null) {
            if (current.key == search)
                break;
            if (current.key < search)
                current = current.right;
            else
                current = current.left;
        }

        assert current != null;
        return max(height(current.left), height(current.right)) + 1;
    }



    // A utility function to get height of the tree
    int height(AvlNode N)
    {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    AvlNode rightRotate(AvlNode y)
    {
        AvlNode x = y.left;
        AvlNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    AvlNode leftRotate(AvlNode x)
    {
        AvlNode y = x.right;
        AvlNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(AvlNode N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AvlNode insert(AvlNode avlNode, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (avlNode == null)
            return (new AvlNode(key));

        if (key < avlNode.key)
            avlNode.left = insert(avlNode.left, key);
        else if (key > avlNode.key)
            avlNode.right = insert(avlNode.right, key);
        else // Equal keys not allowed
            return avlNode;

        /* 2. Update height of this ancestor node */
        avlNode.height = 1 + max(height(avlNode.left),
                height(avlNode.right));

		/* 3. Get the balance factor of this ancestor
		node to check whether this node became
		Wunbalanced */
        int balance = getBalance(avlNode);

        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < avlNode.left.key)
            return rightRotate(avlNode);

        // Right Right Case
        if (balance < -1 && key > avlNode.right.key)
            return leftRotate(avlNode);

        // Left Right Case
        if (balance > 1 && key > avlNode.left.key)
        {
            avlNode.left = leftRotate(avlNode.left);
            return rightRotate(avlNode);
        }

        // Right Left Case
        if (balance < -1 && key < avlNode.right.key)
        {
            avlNode.right = rightRotate(avlNode.right);
            return leftRotate(avlNode);
        }

        /* return the (unchanged) node pointer */
        return avlNode;
    }
}

class AvlNode
{
    int key, height;
    AvlNode left, right;

    AvlNode(int d)
    {
        key = d;
        height = 1;
    }
}