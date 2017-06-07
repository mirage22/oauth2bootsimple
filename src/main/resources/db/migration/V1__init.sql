CREATE TABLE robo_unit (
  ID BIGINT PRIMARY KEY,
  UID VARCHAR(255) NOT NULL,
  CONFIG VARCHAR(255) NOT NULL,
  UNITS BIGINT REFERENCES robo_unit(ID),
  PARENT_ID BIGINT
);

create sequence robo_unit_sequence start with 1 increment by 1;

CREATE TABLE robo_point (
  ID BIGINT PRIMARY KEY,
  UNIT BIGINT REFERENCES ROBO_UNIT(ID),
  VALUE_TYPE VARCHAR (255) NOT NULL,
  VALUES VARCHAR (255) NOT NULL
);

create sequence robo_point_sequence start with 1 increment by 1;

ALTER TABLE robo_unit ADD COLUMN points BIGINT;
ALTER TABLE robo_unit ADD FOREIGN KEY (points) REFERENCES robo_point (id);


