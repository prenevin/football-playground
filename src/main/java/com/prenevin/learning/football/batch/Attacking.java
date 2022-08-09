package com.prenevin.learning.football.batch;

import java.io.Serializable;

import lombok.Data;

@Data
public class Attacking implements Serializable {
    private String serial;
    private String player_name;
    private String club;
    private String position;
    private Integer assists;

    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getPlayer_name() {
        return player_name;
    }
    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }
    public String getClub() {
        return club;
    }
    public void setClub(String club) {
        this.club = club;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Integer getAssists() {
        return assists;
    }
    public void setAssists(Integer assists) {
        this.assists = assists;
    }
    public Integer getCorner_taken() {
        return corner_taken;
    }
    public void setCorner_taken(Integer corner_taken) {
        this.corner_taken = corner_taken;
    }
    public Integer getOffsides() {
        return offsides;
    }
    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }
    public Integer getDribbles() {
        return dribbles;
    }
    public void setDribbles(Integer dribbles) {
        this.dribbles = dribbles;
    }
    public Integer getMatch_played() {
        return match_played;
    }
    public void setMatch_played(Integer match_played) {
        this.match_played = match_played;
    }
    private Integer corner_taken;
    private Integer offsides;
    private Integer dribbles;
    private Integer match_played;

}
