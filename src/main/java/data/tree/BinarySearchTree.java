package main.java.data.tree;


/**
 * @author fupengga
 * 二分搜索树的递归实现
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        root = recursionAdd(root, e);

    }

    private Node recursionAdd(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = recursionAdd(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = recursionAdd(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return recursionContains(root, e);
    }

    private boolean recursionContains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return recursionContains(node.left,e);
        }else{
            return recursionContains(node.right,e);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(8);
        tree.add(20);
        System.out.println(tree.contains(80));
    }


}
