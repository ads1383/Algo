package algo.otus.algorithm;

import java.util.List;

public class BinarySearchTree {

    private TreeExampleNode root;

    public TreeExampleNode getRoot() {
        return root;
    }

    public void setRoot(TreeExampleNode root) {
        this.root = root;
    }

    public void add(int key) {
        root = add(root, key);
    }

    private TreeExampleNode add(TreeExampleNode node, int key) {
        if(node == null) return new TreeExampleNode(key);
        int nodeKey = node.getKey();
        if(key < nodeKey) {
            node.setLeft(add(node.getLeft(), key));
        }
        if(key > nodeKey) {
            node.setRight(add(node.getRight(), key));
        }
        if (key == nodeKey) node.countIncrement();
        return node;
    }

    public TreeExampleNode search(int key) {
        return search(this.root, key);
    }

    private TreeExampleNode search(TreeExampleNode node, int key) {
        if(node == null) return null;
        if(node.getKey() == key) return node;
        if(node.getKey() > key) {
            return search(node.getLeft(), key);
        }
        return search(node.getRight(), key);
    }
}
