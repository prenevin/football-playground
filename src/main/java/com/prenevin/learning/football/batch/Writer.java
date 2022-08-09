package com.prenevin.learning.football.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

public class Writer extends JdbcBatchItemWriter<Attacking> {
    public Writer(final DataSource dataSource) {
        JdbcBatchItemWriter<Attacking> itemWriter = this; 
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("INSERT INTO attacking(serial,player_name,club,position,assists,corner_taken,offsides,dribbles,match_played) VALUES ( :serial, :player_name, :club, :position, :assists, :corner_taken, :offsides, :dribbles, :match_played)");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Attacking>());
    }

}

