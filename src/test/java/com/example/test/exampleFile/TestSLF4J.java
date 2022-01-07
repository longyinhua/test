package com.example.test.exampleFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSLF4J {

    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(TestSLF4J.class);
        logger.info("Hello");
    }

}
