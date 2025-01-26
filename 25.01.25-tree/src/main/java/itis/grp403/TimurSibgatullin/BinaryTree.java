package itis.grp403.TimurSibgatullin;

public abstract class BinaryTree {
    protected Node traversalTree(Node node) {
        return null;
    }


    static private void addLeaf(int value, Node node) {
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

     protected Node growTree(int[] values) {
        Node res = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            addLeaf(values[i], res);
        }
        return res;
    }
}
