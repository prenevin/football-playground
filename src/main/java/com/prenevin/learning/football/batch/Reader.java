package com.prenevin.learning.football.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

    private int counter;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (counter >= 10_000) {
            return null;
        }
        String ret = "Hello World = " + counter++;
        System.out.println("Reader: " + ret);
        return ret;
    }

}
