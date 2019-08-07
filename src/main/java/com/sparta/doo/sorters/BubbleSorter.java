package com.sparta.doo.sorters;

public class BubbleSorter implements Sorter{

    private static int[] bubbleSort(int[] list) {
        int i, j, temp; // i for outer loop, j for inner loop and a temp variable to do the number swaps
        for (i = 0; i < list.length - 1; i++) {
            for (j = 0; j < list.length - 1 - i; j++) { // length of the list minus the number of items that are already sorted
                // here is where im going to compare an item to another on its immediate right
                //if the item on the left is greater than the item on its right, swap
                if (list[j] > list[j + 1]) { //
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return bubbleSort(arrayToSort);
    }
}