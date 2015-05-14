create table Course (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    SEQ varchar(4) not null UNIQUE,
    COACH varchar(100) not null,
    PRIMARY KEY (ID)
);