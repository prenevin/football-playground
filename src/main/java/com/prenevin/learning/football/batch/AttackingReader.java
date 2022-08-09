package com.prenevin.learning.football.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

public class AttackingReader extends FlatFileItemReader<Attacking> {

    private final class BeanWrapperFieldSetMapperExtension extends BeanWrapperFieldSetMapper<Attacking> {
        {
                setTargetType(Attacking.class);
            }
    }

    public AttackingReader() {

        FlatFileItemReader<Attacking> reader = this;

        //Set input file location
        reader.setResource(new FileSystemResource("/home/userdev/myworkspace/project_source_code/java/football/data/attacking.csv"));

        //Set number of lines to skips. Use it if file has header rows.
        reader.setLinesToSkip(1);   

        //Configure how each line will be parsed and mapped to different values
        reader.setLineMapper(new DefaultLineMapper<Attacking>() {
        {
                //3 columns in each row
                setLineTokenizer(new DelimitedLineTokenizer() {
                {
                        setNames(new String[] {
                            "serial",
                            "player_name",
                            "club",
                            "position",
                            "assists",
                            "corner_taken",
                            "offsides",
                            "dribbles",
                            "match_played",
                        });
                    }
                });
                //Set values in Attacking class
                // setFieldSetMapper((fieldSet) -> {
                //
                //     return null;
                // });
                setFieldSetMapper(new BeanWrapperFieldSetMapperExtension());
            }
        });
    }
}
