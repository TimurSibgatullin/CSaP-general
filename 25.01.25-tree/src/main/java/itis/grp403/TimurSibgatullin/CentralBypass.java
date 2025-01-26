package itis.grp403.TimurSibgatullin;

public class CentralBypass extends BinaryTree {
    private Node node;
    public CentralBypass(int[] vals) {
        this.node = growTree(vals);
    }

    public void traversal() {
        traversalTree(this.node);
        System.out.println();
    }

    @Override
    protected Node traversalTree(Node node) {
        // выводим
        // идём налево
        // Идём направо
        System.out.print(node.value + " ");
        if (node.nextLeftNode != null) {
            traversalTree(node.nextLeftNode);
        }
        if (node.nextRightNode != null) {
            traversalTree(node.nextRightNode);
        }
        return null;
    }
}
