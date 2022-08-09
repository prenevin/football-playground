package com.prenevin.learning.football.batch;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public class Writer extends JdbcBatchItemWriter<Attacking> {
    private static final String INSERT_INTO_ATTACKING_BATCH_SQL = "INSERT INTO ATTACKING(serial_value,player_name,club,position,assists,corner_taken,offsides,dribbles,match_played) VALUES (?,?,?,?,?,?,?,?,?);";

    public Writer(final DataSource dataSource, final NamedParameterJdbcOperations namedParameterJdbcTemplate) {
        this.setDataSource(dataSource);
        this.setJdbcTemplate(namedParameterJdbcTemplate);
        this.setSql(INSERT_INTO_ATTACKING_BATCH_SQL);
        this.setItemPreparedStatementSetter(this.preaparedStatmentSetter());
    }

    public ItemPreparedStatementSetter<Attacking> preaparedStatmentSetter() {
        return (Attacking item, PreparedStatement ps) -> {
            ps.setString(1, item.getSerial());
            ps.setString(2, item.getPlayer_name());
            ps.setString(3, item.getClub());
            ps.setString(4, item.getPosition());
            ps.setInt(5, item.getAssists());
            ps.setInt(6, item.getCorner_taken());
            ps.setInt(7, item.getOffsides());
            ps.setInt(8, item.getDribbles());
            ps.setInt(9, item.getMatch_played());
        };
    }

}

