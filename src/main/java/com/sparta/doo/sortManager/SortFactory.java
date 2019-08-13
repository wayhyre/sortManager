package com.sparta.doo.sortManager;

import com.sparta.doo.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

class SortFactory {

    private static final String PATH = "resources/factory.properties";

    //Return a sorter based on the given user input
    //1 -> Bubble sort, 2 -> Merge sort, anything is an error case so we get an empty array
    static Sorter getInstance(int sorter) {
        Sorter newSorter = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty("sorter");
            Class selectedSorter = Class.forName(sortType);
            newSorter = (Sorter) selectedSorter.getDeclaredConstructor().newInstance();

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return newSorter;


//        switch (sorter) {
//            case 1:
//                return new BubbleSorter();
//            case 2:
//                return new MergeSorter();
//            default:
//                return arrayToSort -> new int[0];
//        }
    }
}




