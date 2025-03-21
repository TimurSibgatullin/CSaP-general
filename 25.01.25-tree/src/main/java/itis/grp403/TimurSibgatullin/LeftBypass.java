package itis.grp403.TimurSibgatullin;

public class LeftBypass extends BinaryTree {
    public LeftBypass(int[] values) {
        super(values);
    }

    public void traversal() {
        traversalTree(this.node);
        System.out.println();
    }

    @Override
    protected Node traversalTree(Node node) {
        // идём налево
        // выводим
        // Идём направо
        if (node.nextLeftNode != null) {
            traversalTree(node.nextLeftNode);
        }
        System.out.print(node.value + " ");
        if (node.nextRightNode != null) {
            traversalTree(node.nextRightNode);
        }
        return null;
    }
}
