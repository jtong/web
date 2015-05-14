create table Account (
    ID int not null AUTO_INCREMENT,
    NAME varchar(100) not null,
    PRICE double not null,
    PAID_TIME datetime not null,
    TYPE varchar(255) not null,
    PRIMARY KEY (ID)
);