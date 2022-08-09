package com.prenevin.learning.football.batch;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Processor implements ItemProcessor<Attacking, Attacking> {

    @Override
    public Attacking process(final Attacking item) throws Exception {
        System.out.println("In processor, item=" + item);
        return item;
    }

}
