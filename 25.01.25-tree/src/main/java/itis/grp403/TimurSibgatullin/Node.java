package itis.grp403.TimurSibgatullin;

public class Node implements ITree {
    int value;
    Node nextLeftNode;
    Node nextRightNode;

    public Node(int value) {
        this.value = value;
        this.nextLeftNode = null;
        this.nextRightNode = null;
    }

    public void setNextLeftNode(Node nextLeftNode) {
        this.nextLeftNode = nextLeftNode;
    }

    public void setNextRightNode(Node nextRightNode) {
        this.nextRightNode = nextRightNode;
    }

    @Override
    public Node left() {
        return nextLeftNode;
    }

    @Override
    public Node right() {
        return nextRightNode;
    }

    @Override
    public int value() {
        return value;
    }
}
