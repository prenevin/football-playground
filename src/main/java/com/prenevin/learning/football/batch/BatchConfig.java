
package com.prenevin.learning.football.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job processJob(Step orderStep1) {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1).end().build();
	}

	@Bean
	public Step orderStep1(final DataSource datasource, final NamedParameterJdbcOperations namedParameterJdbcTemplate) {
		return stepBuilderFactory.get("orderStep1").<Attacking, Attacking> chunk(10)
        .reader(new AttackingReader())
        .processor(new Processor())
        .writer(new Writer(datasource, namedParameterJdbcTemplate)).build();
	}

	@Bean
	public JobCompletionListener listener() {
		return new JobCompletionListener();
	}
}
