
CREATE TABLE attacking (
    id bigint auto_increment,
    serial_value VARCHAR(10),
    player_name VARCHAR(255),
    club VARCHAR(255),
    position VARCHAR(255),
    assists INTEGER,
    corner_taken INTEGER,
    offsides INTEGER,
    dribbles INTEGER,
    match_played INTEGER,

    PRIMARY KEY(id)
);
