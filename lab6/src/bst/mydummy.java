package bst;

public class mydummy {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>((e1, e2) -> ((e2).compareTo(e1)));
        tree.add("b");
        tree.add("a");
        tree.add("c");
        tree.printTree();
        System.out.println("the size is " + tree.size());
        System.out.println("the level is "+ tree.height());



    }
}
