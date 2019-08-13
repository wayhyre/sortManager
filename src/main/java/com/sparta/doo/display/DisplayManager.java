package com.sparta.doo.display;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {
    private Scanner scanner = new Scanner(System.in);

    public String displayTerminalSortTypeRequest(String path) {
        System.out.println("Enter the number of the Sorter you wish to use");
        String[] sortNames = getMenuItems(path);
        String sortType = scanner.nextLine();
        return sortNames[Integer.parseInt(sortType) - 1];
    }

    public int displayTerminalArraySizeRequest() {
        System.out.println("Please enter the size of array you want to enter");
        return scanner.nextInt();
    }

    public void displayUnsortedArray(String sorterName, int[] unsortedArray) {
        System.out.println("Sorting using the " + sorterName);
        System.out.println("Before sorting:\n" + Arrays.toString(unsortedArray));
    }


    public void displaySortedArray(int[] sortedArray, long timeTaken) {
        DecimalFormat df = new DecimalFormat("###,###.###");
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
        System.out.println("Time taken: " + (df.format(timeTaken)) + " nano seconds");

//        String sortType = typeOfSort == 1 ? "Bubble sort: " : typeOfSort == 2 ? "Merge sort: " : "Error";
//        System.out.println(Arrays.toString(sortedArray) + " - " + sortType + timeTaken + " nanoseconds");
    }

    private String[] getMenuItems(String path) {
        File sortDirectory = new File(path);
        String[] names = sortDirectory.list();
        Arrays.sort(names != null ? names : new String[0]);
        int index = 1;
        for (String name : names) {
            System.out.println(index + ". " + name);
            index++;
        }
        return names;
        // display terminal sort type request
        // display terminal array size request
        // display unsorted array
        // display sorted array (Done?)
    }
}
