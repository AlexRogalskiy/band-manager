-- ************************************** tour_music
CREATE TABLE tour_song
(
    "id"      bigint NOT NULL,
    band_id bigint NOT NULL,
    song_id bigint NOT NULL,
    tour_id bigint NOT NULL,
    CONSTRAINT PK_tour_song PRIMARY KEY ( "id" ),
    CONSTRAINT FK_band_tour_song FOREIGN KEY ( band_id ) REFERENCES band ( "id" ),
    CONSTRAINT FK_song_tour_song FOREIGN KEY ( song_id ) REFERENCES song ( "id" ),
    CONSTRAINT FK_tour_tour_song FOREIGN KEY ( tour_id ) REFERENCES tour ( "id" )
);

ALTER TABLE tour_song ADD CONSTRAINT UQ_tour_song UNIQUE (band_id, song_id, tour_id);