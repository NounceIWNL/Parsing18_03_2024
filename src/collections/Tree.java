package collections;

import java.util.ArrayList;

//Простая реализация дерева
public class Tree<E> {
    private Node root;

    Tree(E value) {
        root = new Node(null, value);
    }

    //Узел дерева
    public class Node {
        private E value; //Объект, привязанный к узлу дерева
        private Node parent; //Родительский элемент
        private ArrayList<Node> childs = new ArrayList<>(); //Массив дочерних элементов

        public Node(Node parent, E value) {
            this.parent = parent;
            this.value = value;
        }

        public void addChild(Node child) {
            child.parent = this;
            childs.add(child);
        }

        public void removeChild(Node child) {
            childs.remove(childs.indexOf(child));
        }

        public void preOrder(Node node) {
            if (node == null) return;
            System.out.println(node.value);
            for (int i = 0; i < node.childs.size(); i++) {
                preOrder(node.childs.get(i));
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
} 