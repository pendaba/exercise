package main.java.data.tree;

import java.util.ArrayDeque;

/**
 * @author fupengga
 * 二叉搜索树示例
 */
public class Tree {

    private Node root;
    public Node find(int key){
        Node current = root;
        while(current.getiData() != key){
            if(key<current.getiData()){
                current = current.getlChild();
            }else {
                current = current.getrChild();
            }
            if(current == null){
                return null;
            }
        }

        return current;
    }
    public Node insert(int value,double dd){
        Node node = new Node();
        node.setiData(value);
        node.setfData(dd);
        if(root == null){
            root = node;
            return null;
        }else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(value<current.getiData()){
                    current = current.getlChild();
                    if(current == null){
                        parent.setlChild(node);
                        return parent;
                    }
                }else{
                    current=current.getrChild();
                    if(current == null){
                        parent.setrChild(node);
                        return parent;
                    }
                }
            }
        }
    }

    /**
     * 删除节点
     * @param node
     * @return
     */
    public Node delete(Node node){

        return node;
    }

    /**
     *
     * @param node
     * 中序遍历 1 遍历左子树 2 访问本身 3 遍历右子树
     *
     * 前序遍历 1 访问本身 2 遍历左子树  3 遍历右子树
     *
     * 后序遍历 1 遍历左子树 2 遍历右子树 3 访问本身
     */
    public void inOrder(Node node){
        if (node != null){
            System.out.print("节点的值："+node.getiData()+"  ");
            inOrder(node.getlChild());
            inOrder(node.getrChild());
        }
    }
    /**
     *
     * @param node
     * 中序遍历 1 遍历左子树 2 访问本身 3 遍历右子树
     *
     * 前序遍历 1 访问本身 2 遍历左子树  3 遍历右子树
     *
     * 后序遍历 1 遍历左子树 2 遍历右子树 3 访问本身
     */
    public void middleOrder(Node node){
        if (node != null){
            middleOrder(node.getlChild());
            System.out.print("节点的值："+node.getiData()+"  ");
            middleOrder(node.getrChild());
        }
    }
    /**
     *
     * @param node
     * 中序遍历 1 遍历左子树 2 访问本身 3 遍历右子树
     *
     * 前序遍历 1 访问本身 2 遍历左子树  3 遍历右子树
     *
     * 后序遍历 1 遍历左子树 2 遍历右子树 3 访问本身
     */
    public void afterOrder(Node node){
        if (node != null){
            afterOrder(node.getlChild());
            afterOrder( node.getrChild());
            System.out.print("节点的值："+node.getiData()+"  ");
        }
    }


    /**
     * 宽度优先的遍历
     * @param root
     */
    public void widthOrder(Node root){
        if(root == null){
            return;
        }
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()){
            Node node = arrayDeque.remove();
            System.out.print(node.getiData()+",");
            if(node.getlChild() != null){
                arrayDeque.add(node.getlChild());

            }
            if(node.getrChild() != null){
                arrayDeque.add(node.getrChild());
            }
        }
    }




    /**
     *
     * @return
     */
    public Node findMin(){
        Node min = root;
        Node current = root;
        while(current != null){
            min = current;
            current = current.getlChild();
        }
        return min;
    }
    /**
     *
     * @return
     */
    public Node findMax(){
        Node max = root;
        Node current = root;
        while(current != null){
            max = current;
            current = current.getrChild();
        }
        return max;
    }

    /**
     * 删除叶子节点
     * @param key
     * @return
     */
    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.getiData() != key){
            parent = current;
            if(key < current.getiData()){
                isLeftChild = true;
                current = current.getlChild();
            }else{
                isLeftChild = false;
                current = current.getrChild();
            }
            if(current == null){
                return false;
            }
        }
        if(current.getlChild() == null && current.getrChild() == null){
           if(current == root){
               root = null;
           }else if(isLeftChild){
               parent.setlChild(null);
           }else{
               parent.setrChild(null);
           }
        }else if(current.getrChild() == null){
            if(current == root){
                root = current.getlChild();
            }else if(isLeftChild){
                parent.setlChild(current.getlChild());
            }else{
                parent.setrChild(current.getlChild());
            }

        }else if(current.getlChild() == null){
            if(current == root){
                root = current.getrChild();
            }else if(isLeftChild){
                parent.setlChild(current.getrChild());
            }else {
                parent.setrChild(current.getrChild());
            }
        }else{
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.setlChild(successor);
            }else{
                parent.setrChild(successor);
            }
            successor.setlChild(current.getlChild());
        }
        return true;
    }

    /**
     * 找到要删除节点的后继节点
     * @param node
     * @return
     */
    private Node getSuccessor(Node node){
        Node parent = node;
        Node successor = node;
        Node current = node.getrChild();
        while (current != null){
            parent = successor;
            successor = current;
            current = current.getlChild();
        }
//        后继节点是被删除节点的左子孙且有右儿子；
        if(successor != node.getrChild()){
            parent.setlChild(successor.getrChild());
            successor.setrChild(node.getrChild());
        }
        System.out.println("删除节点的后继节点："+successor.getiData());
        return successor;

    }

    /**
     * 二叉树节点的深度
     * @return
     */
    public int getDepth(int value) {
       return recursionGetDepth(root,value,1);
    }
    private int recursionGetDepth(Node node,int value,int depth){
        if(node == null){
            return -1;
        }

        if(value == node.getiData()){
            return depth;
        }
        int s = -1;
        depth += 1;
        if(node.getlChild() != null){
            s=recursionGetDepth(node.getlChild(),value,depth);
        }
        if(s > 0) {
            return s;
        }
        if( node.getrChild() != null){
            s=recursionGetDepth(node.getrChild(),value,depth);
        }
        if(s > 0){
            return s;
        }
        return -1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(20,0.1);
        tree.insert(10,0.2);
        Node parent = tree.insert(30,0.3);
        tree.insert(5,0.4);
        tree.insert(12,0.5);
        tree.insert(25,0.5);
        tree.insert(40,0.5);
//        tree.inOrder(tree.find(10));
//        System.out.println("最小值： "+tree.findMin().getiData());
//        System.out.println("最大值： "+tree.findMax().getiData());
//        System.out.println("插入测试   返回父节点的值： "+parent.getiData());
//        tree.afterOrder(tree.find(20));
//      System.out.println("后继节点： "+tree.getSuccessor(tree.find(15)).getiData());
//        tree.delete(15);
//        tree.inOrder(tree.find(10));
//        tree.middleOrder(tree.find(20));
//       tree.widthOrder(tree.find(20));
       System.out.println(tree.getDepth(30));
    }

}
