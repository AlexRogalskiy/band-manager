-- ************************************** country
CREATE TABLE country
(
    "id"   bigint NOT NULL,
    name text NOT NULL,
    CONSTRAINT PK_country PRIMARY KEY ( "id" )
);

-- ************************************** member_role
CREATE TABLE member_role
(
    "id"   bigint NOT NULL,
    name text NOT NULL,
    CONSTRAINT PK_member_role PRIMARY KEY ( "id" )
);

-- ************************************** band
CREATE TABLE band
(
    "id"             bigint NOT NULL,
    name           text NOT NULL,
    country_id     bigint NOT NULL,
    formation_year timestamp with time zone NOT NULL,
    CONSTRAINT PK_band PRIMARY KEY ( "id" ),
    CONSTRAINT FK_country FOREIGN KEY ( country_id ) REFERENCES country ( "id" )
);

CREATE INDEX IN_country_band ON band
    (
     country_id
        );

-- ************************************** hit_parade
CREATE TABLE hit_parade
(
    "id"       bigint NOT NULL,
    band_id  bigint NOT NULL,
    "position" bigint NOT NULL,
    CONSTRAINT PK_hit_parade PRIMARY KEY ( "id" ),
    CONSTRAINT FK_band FOREIGN KEY ( band_id ) REFERENCES band ( "id" )
);

CREATE INDEX IN_band_hit_parade ON hit_parade
    (
     band_id
        );

-- ************************************** "member"
CREATE TABLE "member"
(
    "id"      bigint NOT NULL,
    name    text NOT NULL,
    band_id bigint NOT NULL,
    age     integer NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT PK_member PRIMARY KEY ( "id" ),
    CONSTRAINT FK_band FOREIGN KEY ( band_id ) REFERENCES band ( "id" ),
    CONSTRAINT FK_role FOREIGN KEY ( role_id ) REFERENCES member_role ( "id" )
);

CREATE INDEX IN_band_member ON "member"
    (
     band_id
        );

CREATE INDEX IN_role_member ON "member"
    (
     role_id
        );

-- ************************************** song
CREATE TABLE song
(
    "id"            bigint NOT NULL,
    compositor_id bigint NOT NULL,
    author_id     bigint NOT NULL,
    name          text NOT NULL,
    CONSTRAINT PK_song PRIMARY KEY ( "id" ),
    CONSTRAINT FK_compositor FOREIGN KEY ( compositor_id ) REFERENCES "member" ( "id" ),
    CONSTRAINT FK_author FOREIGN KEY ( author_id ) REFERENCES "member" ( "id" )
);

CREATE INDEX IN_compositor_song ON song
    (
     compositor_id
        );

CREATE INDEX IN_author_song ON song
    (
     author_id
        );

-- ************************************** tour
CREATE TABLE tour
(
    "id"           bigint NOT NULL,
    name         text NOT NULL,
    band_id      bigint NOT NULL,
    begin_date   timestamp with time zone NOT NULL,
    end_date     timestamp with time zone NOT NULL,
    country_id   bigint NOT NULL,
    ticket_price numeric NOT NULL,
    CONSTRAINT PK_tour PRIMARY KEY ( "id" ),
    CONSTRAINT FK_band FOREIGN KEY ( band_id ) REFERENCES band ( "id" ),
    CONSTRAINT FK_country FOREIGN KEY ( country_id ) REFERENCES country ( "id" )
);

CREATE INDEX IN_band_tour ON tour
    (
     band_id
        );

CREATE INDEX IN_country_tour ON tour
    (
     country_id
        );

-- ************************************** tour
CREATE TABLE user_entity
(
    "id"            bigint NOT NULL,
    username      text NOT NULL,
    password      text NOT NULL,
    CONSTRAINT PK_id PRIMARY KEY ("id"),
    CONSTRAINT UQ_username UNIQUE (username)
)
