package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvenOddArray {
    public static void evenOddSolution(List<Integer> list){
        int slow = 0;
        int fast = 0;

        while(fast < list.size()){
            if(list.get(fast)%2 == 0) {
                Collections.swap(list, slow, fast);
                slow++;
            }
            fast++;

        }


    }

    public static void main(String[] args) {

        //test case
        Integer[] test = {1,2,3,4,5,5,5,5,6,7};
        List<Integer> list =  Arrays.asList(test);


        evenOddSolution(list);
        for(int i : list){
            System.out.println(i);
        }
    }

}
