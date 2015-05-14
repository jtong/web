create table Employee (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    PHONE varchar(100) not null,
    AGE int not null,
    GRENDER boolean not null,
    SEQ varchar(8) not null UNIQUE,
    PRIMARY KEY (ID)
);