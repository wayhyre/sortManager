package com.sparta.doo.binaryTree;

class Node {
    private final int value;
    private Node left;
    private Node right;

    Node(int value) {
        this.value = value;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;

    }

    void setRight(Node right) {
        this.right = right;
    }

    int getValue() {
        return value;
    }

    boolean find(int value) {

        //recursively searching for a given value

        if (value == this.value) {
            return true;
        } else if (value < this.value) {
            return left != null && left.find(value);

//            if (left == null) {
//                return false;
////            }
////            else {
////                return left.find(value);
////            }
        } else {
            return right != null && right.find(value);

//            if (right == null) {
//                return false;
//            }
//            else  {
//                return right.find(value);
//            }
        }
    }


    Node getNode(int value) {
        //recursively trying to get a node for the given value or an exception

        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            return left.getNode(value);

        } else {
            return right.getNode(value);
        }
    }
}




