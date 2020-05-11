package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyArbitaryPrecisionArrays {

    public static List<Integer> multiplier(List<Integer> one, List<Integer> two){
        List<Integer> mul = new ArrayList<Integer>(Collections.nCopies(one.size() + two.size(), 0));
        if(two.size() > one.size()){
            return multiplier(two, one);
        }

        var oneSize = one.size() - 1;
        var twoSize = two.size() - 1;
        Collections.fill(mul, 0);

        for (int i = oneSize; i >= 0; i--) {
            for (int j = twoSize; j >= 0; j--) {
                mul.set(i + j + 1, mul.get(i + j + 1) + (one.get(i) * two.get(j)));
                mul.set(i + j, mul.get(i + j + 1)/10);
                mul.set(i + j + 1, mul.get(i + j + 1)%10);

            }
        }

        int zeroIndex = 0;
        for(int i : mul){
            if(i != 0){
                break;
            }
            zeroIndex++;
        }
        return mul.subList(zeroIndex, mul.size());

    }



    public static void main(String args[]){
        List<Integer> one = Arrays.asList(1,1);
        List<Integer> two = Arrays.asList(1,0,0,0,0,0,0);
        List<Integer> result = multiplier(one, two);
        for(int i : result){
            System.out.println(i);
        }
//        multiplier();

    }

}
