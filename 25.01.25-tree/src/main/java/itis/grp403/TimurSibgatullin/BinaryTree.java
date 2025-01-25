package itis.grp403.TimurSibgatullin;

public abstract class BinaryTree {
    public Node traversalTree(Node node) {
        return null;
    }

    public void addLeaf(int value, Node node) {
        if (value > node.value()) {
            if (node.right() == null) {
                Node tempNode = new Node(value);
                node.setNextRightNode(tempNode);
            } else {
                addLeaf(value, node.right());
            }
        } else if (value <= node.value()) {
            if (node.left() == null) {
                Node tempNode = new Node(value);
                node.setNextLeftNode(tempNode);
            } else {
                addLeaf(value, node.left());
            }
        }
    }
}
