-- Contains table-details for filling the embedded database used in the jUnit testing classes.
-- The database is a DERBY database, not MySQL, so all sql-code must be reviewed, and MySQL
-- specific methods must be carefully written

CREATE TABLE person(
	personnr VARCHAR(12) not null primary key,
	fornavn VARCHAR(40) NOT NULL,
	etternavn VARCHAR(40) NOT NULL);
