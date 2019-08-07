package com.sparta.doo.sortManager;

import com.sparta.doo.display.DisplayManager;
import com.sparta.doo.sorters.Sorter;

class SortManager {

    void runSort(int typeOfSort) {
        Sorter sorter = SortFactory.getInstance(typeOfSort); // Type Of Sort could be bubble (1) or merge (2)

        int[] arrayToSort = {42, 20, 32, 90, 60, 47, 70, 63, 50, 31, 79, 83, 27, 59, 19}; // this is the array bubble and merge sort are using

        long start = System.nanoTime(); // we take a snapshot of the time before we start sorting
        int[] sortedArray = sorter.sortArray(arrayToSort);
        long end = System.nanoTime(); // we take a snapshot of the time after we finish sorting
        long timeTaken = end - start; //the subtraction of the end and start give us the time taken

        showSortedArray(typeOfSort, sortedArray, timeTaken);
    }

    private void showSortedArray(int typeOfSort, int[] sortedArray, long timeTaken) {
        //no need to store a local instance of the DisplayManager object
        new DisplayManager().displaySortedArray(typeOfSort, sortedArray, timeTaken);
    }
}
