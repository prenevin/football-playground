package com.prenevin.learning.football.batch;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        System.out.println("In processor, item=" + item);
        return item.toUpperCase();
    }

}
