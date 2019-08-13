package com.sparta.doo.sorters;

import com.sparta.doo.binaryTree.BinaryTree;
import com.sparta.doo.binaryTree.BinaryTreeImpl;

public class BinaryTreeSorter implements Sorter {


    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree binaryTree = new BinaryTreeImpl(arrayToSort);
        return binaryTree.getSortedTreeAsc();
    }


}
