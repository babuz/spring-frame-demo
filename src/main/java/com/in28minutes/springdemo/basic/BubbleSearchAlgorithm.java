package com.in28minutes.springdemo.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BubbleSearchAlgorithm implements SortAlgorithm {
    @Override
    public int[] sort(int[] listOfInt) {
        return listOfInt;
    }
}
