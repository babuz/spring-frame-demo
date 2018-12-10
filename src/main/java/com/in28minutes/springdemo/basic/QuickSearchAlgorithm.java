package com.in28minutes.springdemo.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Primary
public class QuickSearchAlgorithm implements SortAlgorithm {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public int[] sort(int[] listOfInt) {
        return listOfInt;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("Post Construct -> Quick Search Algorithm");
    }


    @PreDestroy
    public void preDestroy(){
        logger.info("Pre Destroy -> Quick Search Algorithm");
    }
}
