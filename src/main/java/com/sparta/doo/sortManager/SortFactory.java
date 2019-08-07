package com.sparta.doo.sortManager;

import com.sparta.doo.sorters.BubbleSorter;
import com.sparta.doo.sorters.MergeSorter;
import com.sparta.doo.sorters.Sorter;

class SortFactory {

    //Return a sorter based on the given user input
    //1 -> Bubble sort, 2 -> Merge sort, anything is an error case so we get an empty array
    static Sorter getInstance(int sorter){
        switch(sorter) {
            case 1: return new BubbleSorter();
            case 2: return new MergeSorter();
            default: return arrayToSort -> new int[0];
        }
    }
}




