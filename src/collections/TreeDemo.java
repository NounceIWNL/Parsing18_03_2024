package collections;

public class TreeDemo {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        Tree.Node root = tree.getRoot();
        root.addChild(tree.new Node(root, 2));
        root.addChild(tree.new Node(root, 3));
        root.addChild(tree.new Node(root, 4));
        root.preOrder(root);

    }
} 