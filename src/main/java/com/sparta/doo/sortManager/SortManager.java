package com.sparta.doo.sortManager;

import com.sparta.doo.display.DisplayManager;
import com.sparta.doo.sorters.Sorter;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import java.util.Random;


class SortManager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private DisplayManager displayManager = new DisplayManager();
    private SortLoader loader = new SortLoader();

    public void sortArray() {
        try {
            initialiseLogging();
            String sortType = displayManager.displayTerminalSortTypeRequest(loader.getSortersLocation());
            int sizeOfArray = displayManager.displayTerminalArraySizeRequest();

            int[] unsortedArray = createArray(sizeOfArray);
            Sorter sorter = selectSorter(sortType);

            printBeforeSort(sorter.toString(), unsortedArray);
            var start = System.nanoTime();
            int[] sortedArray = sorter.sortArray(unsortedArray);
            var end = System.nanoTime();
            printAfterSort(sortedArray, end - start);
        } catch (SorterLoaderException e) {
            e.printStackTrace();
        }
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.trace("Logging initialised");
    }

    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }

    private Sorter selectSorter(String sortType) throws SorterLoaderException {
        return loader.getSorter(sortType);
    }

    private void printBeforeSort(String sorter, int[] unsortedArray) {
        displayManager.displayUnsortedArray(sorter, unsortedArray);
    }

    private void printAfterSort(int[] sortedArray, long l) {
        displayManager.displaySortedArray(sortedArray);
    }


//    void runSort(int typeOfSort) {
//        Sorter sorter = SortFactory.getInstance(typeOfSort); // Type Of Sort could be bubble (1) or merge (2)
//
//        int[] arrayToSort = {42, 20, 32, 90, 60, 47, 70, 63, 50, 31, 79, 83, 27, 59, 19}; // this is the array bubble and merge sort are using
//
//        long start = System.nanoTime(); // we take a snapshot of the time before we start sorting
//        int[] sortedArray = sorter.sortArray(arrayToSort);
//        long end = System.nanoTime(); // we take a snapshot of the time after we finish sorting
//        long timeTaken = end - start; //the subtraction of the end and start give us the time taken
//
//        showSortedArray(typeOfSort, sortedArray, timeTaken);
//    }

//    private void showSortedArray(int typeOfSort, int[] sortedArray, long timeTaken) {
//        //no need to store a local instance of the DisplayManager object
//        new DisplayManager().displaySortedArray(typeOfSort, sortedArray, timeTaken);
//    }
}

