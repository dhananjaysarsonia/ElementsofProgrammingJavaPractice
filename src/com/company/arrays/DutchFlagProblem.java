package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DutchFlagProblem {

    //modified for numbers
    //we will do it in one pass
    //move with three pointers
    //initialize smaller and equal pointer to zero
    //traverse through the list
    //swap increment the smaller and equal pointer if smaller is found
    //swap and increment the equal pointer if equal is found
    //swap and decrement the larger pointer and increment equal pointer if larger is found
    //Note the smaller will overwrite the equal numbers by swapping, but our equal pointer will fix them

    public static void dutchPartitioning(List<Integer> list, int pivotIndex){
        int small = 0;
        int equal = 0;
        //notice that we are using large as size here, and later decrementing first then swapping
        //we are doing this because there will be a case where when our larger index will just next to the smaller one, it will
        //swap and decrement with equal, but when it will decrement it will break the loop
        //we won't get a chance to see that if the new swapped element(from larger) on the equal index is smaller, greater
        //as we need to stop the loop when smaller and larger collide
        int large = list.size();
        int pivot = list.get(pivotIndex);
        while(equal < large){
            if(list.get(equal) < pivot){
                Collections.swap(list, small, equal);
                small++;
                equal++;
            }
            else if(list.get(equal) == pivot){
                equal++;
            }
            else if (list.get(equal) > pivot){
                large --;
                Collections.swap(list, equal, large);

            }

        }
    }

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(3,5,6,2,2,2,6,6,7,4,4,3,3,3);
        dutchPartitioning(list, 9);
        for(int item : list){
            System.out.println(item);
        }



    }
}


