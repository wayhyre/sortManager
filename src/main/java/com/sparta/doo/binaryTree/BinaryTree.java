package com.sparta.doo.binaryTree;

/**
 * Created by keith.dauris on 26/06/2017.
 */
public interface BinaryTree {
    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int value) throws ChildNotFoundException;

    int getRightChild(int value);

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}
