package itis.grp403.TimurSibgatullin;

public class RightBypass extends BinaryTree {
    private Node node;
    public RightBypass(int[] vals) {
        this.node = growTree(vals);
    }

    public void traversal() {
        traversalTree(this.node);
        System.out.println();
    }

    @Override
    protected Node traversalTree(Node node) {
        // идём налево
        // Идём направо
        // выводим
        if (node.nextLeftNode != null) {
            traversalTree(node.nextLeftNode);
        }
        if (node.nextRightNode != null) {
            traversalTree(node.nextRightNode);
        }
        System.out.print(node.value + " ");
        return null;
    }
}
