package com.sparta.doo.display;

import java.util.Arrays;

public class DisplayManager {

    public void displaySortedArray(int typeOfSort, int[] sortedArray, long timeTaken) {
        String sortType = typeOfSort == 1 ? "Bubble sort: " : typeOfSort == 2 ? "Merge sort: " : "Error";
        System.out.println(Arrays.toString(sortedArray) + " - " + sortType + timeTaken + " nanoseconds");
    }

}
