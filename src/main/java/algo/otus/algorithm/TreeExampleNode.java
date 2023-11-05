package algo.otus.algorithm;

public class TreeExampleNode {
    private int key;

    private int count;
    private TreeExampleNode left;
    private TreeExampleNode right;

    public TreeExampleNode(int key, TreeExampleNode left, TreeExampleNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public TreeExampleNode(int key) {
        this.key = key;
        this.count++;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeExampleNode getLeft() {
        return left;
    }

    public void setLeft(TreeExampleNode left) {
        this.left = left;
    }

    public TreeExampleNode getRight() {
        return right;
    }

    public void setRight(TreeExampleNode right) {
        this.right = right;
    }

    public void countIncrement() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
