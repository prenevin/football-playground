package com.prenevin.learning.football.batch;

import java.io.Serializable;

import lombok.Data;

@Data
public class Attacking implements Serializable {
    private String serial;
    private String player_name;
    private String club;
    private String position;
    private String assists;
    private String corner_taken;
    private String offsides;
    private String dribbles;
    private String match_played;
}
