package com.prenevin.learning.football.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println("items.size "+ items.size());
        items.forEach(s -> System.out.println(s));
    }

}

