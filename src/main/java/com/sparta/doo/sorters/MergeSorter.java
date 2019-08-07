package com.sparta.doo.sorters;

public class MergeSorter implements Sorter {

    private static int[] mergeSort(int[] array){

        if (array.length <= 1){
            return array;
        }

        int midPoint = array.length / 2;

        int [] leftArr = new int [midPoint];
        int [] rightArr;

        if(array.length % 2 == 0 ){
            rightArr = new int[midPoint]; // making sure right array is initialised properly
        }else {
            rightArr = new int [midPoint + 1];
        }
        for (int i = 0; i < midPoint; i++){
            leftArr[i] = array[i]; // populates the left array
        }

        for (int j = 0; j < rightArr.length; j++){
            rightArr[j] = array[midPoint + j]; // makes sure the right array will be initialised with the correct values
        }

        int[] result;

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        result = merge(leftArr, rightArr);

        return result;
    }

    private static int[]merge(int[] leftArr, int[] rightArr){

        int [] result = new int [leftArr.length + rightArr.length];

        int leftPointer, rightPointer, resultPointer; // pointers for each array
        leftPointer = rightPointer = resultPointer = 0;

        // while there are elements in either  right array OR left array merge, if none then dont merge

        while (leftPointer < leftArr.length || rightPointer <rightArr.length){
            if (leftPointer < leftArr.length && rightPointer < rightArr.length){
                if (leftArr[leftPointer] < rightArr[rightPointer]) {
                    result[resultPointer++] = leftArr[leftPointer++];

                }else {
                    result[resultPointer++] = rightArr[rightPointer++]; // if this is not true then right poiinter is less than left
                }
            }
            else if (leftPointer < leftArr.length){
                result[resultPointer++] = leftArr[leftPointer++]; // if there are only elements in the left array then you take the element in the left array then assign it to result and increment
            }

            else if(rightPointer < rightArr.length){
                result[resultPointer++] = rightArr[rightPointer++];
            }
        }
        return result;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return mergeSort(arrayToSort);
    }
}


    // create array then add new array i = temp

        /*if (length < 2) {
            return;
        }
        // getting the midpoint
        int midPoint = length + 1 / 2; // getting the middle index and then creating two temporary arrays
        int[] tempLeft = new int[midPoint];
        int[] tempRight = new int[length - midPoint];

        // split the array
        for (int i = 0; i < midPoint; i++) {
            tempLeft[i] = a[i];
        }
        for (int i = midPoint; i < length; i++) {
            tempRight[i - midPoint] = a[i];
        }
        System.out.println(Arrays.toString(tempLeft));
        System.out.println(Arrays.toString(tempRight));

        // merge the array
        mergeSort(tempLeft, midPoint);
        mergeSort(tempRight, length - midPoint);*/










