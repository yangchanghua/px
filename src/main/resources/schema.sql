
CREATE table IF NOT EXISTS projects (
id INTEGER IDENTITY PRIMARY KEY,
  domain varchar(64),
  sub_domain varchar(64),
  start_date Date,
  hours int
);