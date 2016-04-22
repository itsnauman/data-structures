import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Class to implement the Binary Search Tree
 * @author Nauman Ahmad
 */
public class BinarySearchTree <E extends Comparable<E>> {
    private BSTNode <E> root;
    private int size;

    public void add(E value) {
        root = add(value, root);
        size++;
    }

    private BSTNode <E> add(E value, BSTNode <E> node) {
        if (node == null)
            return new BSTNode<>(value);
        else if (value.compareTo(node.data) < 0)
            node.left = add(value, node.left);
        else
            node.right = add(value, node.right);
        return node;
    }

    public E remove(E value) {
        BSTNode <E> rem = remove(value, root);
        root = remove(value, root);
        size--;
        return rem.data;
    }

    private BSTNode <E> remove(E value, BSTNode <E> node) {
        if (node == null)
            throw new NoSuchElementException();
        else if (value.compareTo(node.data) < 0)
            node.left = remove(value, node.left);
        else if (value.compareTo(node.data) > 0)
            node.right = remove(value, node.right);
        else {
            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            // Get the predecessor of the value to be removed
            E val = getNodeReplaceValue(node.left);
            node.data = val;
            remove(val, node.left);
        }

        return node;
    }

    /**
     * Get the predecessor or successor to a node
     */
    private E getNodeReplaceValue(BSTNode <E> node) {
        if (node.right == null)
            return node.data;

        return getNodeReplaceValue(node.right);
    }

    public E get(E value) {
        return get(value, root).data;
    }

    private BSTNode <E> get(E value, BSTNode <E> node) {
        if (node == null)
            throw new NoSuchElementException();
        else if (value.compareTo(node.data) == 0)
            return node;
        else if (value.compareTo(node.data) < 0)
            return get(value, node.left);
        else
            return get(value, node.right);
    }

    /**
     * Swap the children to get the mirror image of the tree.
     */
    public void mirror() {
        mirror(root);
    }

    private void mirror(BSTNode <E> node) {
        if (node != null) {
            BSTNode <E> tmp = node.right;
            node.right = node.left;
            node.left = tmp;
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(BSTNode <E> node) {
        if (node == null)
            return 0;

        if (node.left == null || node.right == null)
            return 1;

        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int size() {
        return size;
    }

    /**
     * Recursively calculate the size
     */
    private int size(BSTNode <E> node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(BSTNode <E> node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public ArrayList<E> inOrderTraverse() {
        ArrayList<E> list = new ArrayList<>();
        inOrderTraverse(root, list);
        return list;
    }

    private void inOrderTraverse(BSTNode <E> node, ArrayList<E> list) {
        if (node != null) {
            inOrderTraverse(node.left, list);
            list.add(node.data);
            inOrderTraverse(node.right, list);
        }
    }

    public ArrayList<E> preOrderTraverse() {
        ArrayList<E> list = new ArrayList<>();
        preOrderTraverse(root, list);
        return list;
    }

    private void preOrderTraverse(BSTNode<E> node, ArrayList<E> list) {
        if (node != null) {
            list.add(node.data);
            preOrderTraverse(node.left, list);
            preOrderTraverse(node.right, list);
        }
    }

    public ArrayList<E> postOrderTraverse() {
        ArrayList<E> list = new ArrayList<>();
        postOrderTraverse(root, list);
        return list;
    }

    private void postOrderTraverse(BSTNode<E> node, ArrayList<E> list) {
        if (node != null) {
            postOrderTraverse(node.left, list);
            postOrderTraverse(node.right, list);
            list.add(node.data);
        }
    }

    @Override
    public String toString() {
        printBinaryTree(root, 0);
        return null;
    }

    private void printBinaryTree(BSTNode root, int level) {
        if (root == null)
            return;

        printBinaryTree(root.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.data);
        } else {
            System.out.println(root.data);
        }

        printBinaryTree(root.left, level + 1);
    }

    private class BSTNode <T extends Comparable<T>>{
        public BSTNode <T> right;
        public BSTNode <T> left;
        public T data;

        BSTNode(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
