ALTER TABLE song ADD COLUMN band_id bigint;
ALTER TABLE song ADD CONSTRAINT FK_band_id_song FOREIGN KEY (band_id) REFERENCES band (id);
ALTER TABLE song ADD COLUMN creation_date timestamp with time zone NOT NULL default '2000-01-01 00:00:00-07';
ALTER TABLE song ADD CONSTRAINT UQ_band_song UNIQUE (name, band_id);