package com.sparta.doo;

import static org.junit.Assert.assertTrue;

import com.sparta.doo.sorters.BubbleSorter;
import com.sparta.doo.sorters.Sorter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple Starter.
 */

public class StarterTest {
    private Sorter sorter;
    int[] testArray = new int[]{42, 20, 32, 90, 60, 47, 70, 63, 50, 31, 79, 83, 27, 59, 19};
    BubbleSorter bubbleSorter = new BubbleSorter();

    @Test
    public void arrayLengthTest() {
        int sortedArray[] = bubbleSorter.sortArray(testArray);

        assertTrue(testArray.length == sortedArray.length);
    }

    @Test
    public void checkValue() {
        int[] sortedArray = bubbleSorter.sortArray(testArray);
        for (int i = 0; i < testArray.length - 1; i++)
            assertTrue(sortedArray[i] <= sortedArray[i + 1]);
    }

    @Test
    public void checkNull(){
        bubbleSorter.sortArray(testArray);
        Assert.assertNotNull(testArray);
    }
}



