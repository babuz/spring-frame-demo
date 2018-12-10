package com.in28minutes.springdemo.basic;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
@Component
public class BinarySearchImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int search(int[] numbers,int searchNumber){
        System.out.println("Sort Alogirthm Implemented : " + this.sortAlgorithm);
        return 1;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("Post Construct - Binary Search Impl");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("Pre Destroy - Binary Search Impl");
    }
}
