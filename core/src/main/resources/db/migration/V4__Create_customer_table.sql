create table Customer (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    PHONE varchar(100) not null,
    AGE int not null,
    GRENDER boolean not null,
    SEQ varchar(8) not null UNIQUE,
    EXPIRE datetime not null,
    COACH varchar(100) not null,
    PRIMARY KEY (ID)
);