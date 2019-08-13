package com.sparta.doo.binaryTree;

public class BinaryTreeImpl implements BinaryTree {


    private Node root;
    private int[] sortedTree;
    private int numberOfNodes;
    private int count;

    public BinaryTreeImpl(int value) {
        root = new Node(value);
        numberOfNodes++; //root element always increments our node count
    }

    public BinaryTreeImpl(int[] elements) {
        root = new Node(elements[0]);
        numberOfNodes++; //root element increments our node count

        for (int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    //TODO this is original
//    private void addToTree(Node node, int element) {
//        if (element < node.getValue()) {
//            if (node.getLeft() == null) {
//                node.setLeft((new Node(element)));
//                nodes.add(new Node(element));
//                numberOfNodes++;
//            } else {
//                addToTree(node.getLeft(), element);
//            }
//        } else if (node.getValue() < element) {
//            if (node.getRight() == null) {
//                node.setRight(new Node(element));
//                nodes.add(new Node(element));
//                numberOfNodes++;
//            } else {
//                addToTree(node.getRight(), element);
//            }
//        }
//    }


    private Node addToTree(Node node, int element) {

        //if we find the current node to be null, we need to instantiate the new element in its place
        if (node == null) {
            node = new Node(element);
            numberOfNodes++;
            return node;
        }

        if (element < node.getValue()) {
            node.setLeft(addToTree(node.getLeft(), element));
        } else if (element > node.getValue()) {
            node.setRight(addToTree(node.getRight(), element));
        }

        //return the modified node
        return node;
    }

    private void sortTreeAsc(Node node) {
        boolean isLeftEmpty = true;
        if (!isLeftEmpty) {
            sortTreeAsc(node.getLeft());
        }
        sortedTree[count] = node.getValue();
        count++;
        boolean isRightEmpty = true;
        if (!isRightEmpty) {
            sortTreeAsc((node.getRight()));
        }
    }


    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numberOfNodes;
    }

    @Override
    public void addElement(int element) {
        root = addToTree(root, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        return root != null && root.find(value);
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        if (root == null || root.getNode(element) == null) {
            throw new ChildNotFoundException();
        }

        return root.getNode(element).getLeft().getValue();
    }

    @Override
    public int getRightChild(int element) {
        if (root == null) {
            return 0;
        }

        return root.getNode(element).getRight().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }
}
