insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('Tom', 'd41d8cd98f00b204e9800998ecf8427e','tom@abc.com', 16 );
insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('Jerry', 'd41d8cd98f00b204e9800998ecf8427e','jerry@abc.com', 17 );
insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('Red', 'd41d8cd98f00b204e9800998ecf8427e','red@abc.com', 18 );
insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('Marry', 'd41d8cd98f00b204e9800998ecf8427e','marry@abc.com', 19 );
insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('James', 'd41d8cd98f00b204e9800998ecf8427e','james@abc.com', 20 );
insert into USER ( NAME, PASSWORD, EMAIL, AGE ) values ('Emma', 'd41d8cd98f00b204e9800998ecf8427e','emma@abc.com', 21 );

insert into Employee ( NAME, PHONE, AGE, GRENDER, SEQ ) values ('Adam', '1234567',21, 1, '12345678' );
insert into Employee ( NAME, PHONE, AGE, GRENDER, SEQ ) values ('Tony', '1234568',22, 0, '12345679' );
insert into Employee ( NAME, PHONE, AGE, GRENDER, SEQ ) values ('Henry', '1234569',24, 1, '12345680' );
insert into Employee ( NAME, PHONE, AGE, GRENDER, SEQ ) values ('Alex', '1234560',30, 0, '12345681' );

insert into CUSTOMER ( NAME, PHONE, AGE, GRENDER, SEQ, EXPIRE, COACH ) values ('John', '123456',21, 1, '87654321', '2016-2-29', 'Adam');
insert into CUSTOMER ( NAME, PHONE, AGE, GRENDER, SEQ, EXPIRE, COACH ) values ('Terry', '123',22, 0, '87654322', '2016-2-29', 'Adam');
insert into CUSTOMER ( NAME, PHONE, AGE, GRENDER, SEQ, EXPIRE, COACH ) values ('Chris', '1234',24, 1, '87654323', '2016-2-29', 'Adam');
insert into CUSTOMER ( NAME, PHONE, AGE, GRENDER, SEQ, EXPIRE, COACH ) values ('Lee', '12345',30, 0, '87654324', '2016-2-29', 'Adam');

insert into EQUIPMENT ( NAME, STATUS ) values ('equip a', 'NORMAL');
insert into EQUIPMENT ( NAME, STATUS ) values ('equip b', 'DAMAGED');
insert into EQUIPMENT ( NAME, STATUS ) values ('equip c', 'NORMAL');
insert into EQUIPMENT ( NAME, STATUS ) values ('equip d', 'NORMAL');

insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 1', 1000.00, '2012-2-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 2', 2000.00, '2012-2-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 3', 3000.00, '2012-2-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 4', 4000.00, '2012-2-29', 'INCOME');

insert into USER ( NAME, PASSWORD, EMAIL, AGE, IS_ADMIN ) values ('admin', 'd41d8cd98f00b204e9800998ecf8427e','admin@abc.com', 21, true);

insert into Course ( NAME, SEQ, COACH ) values ('training 1', '1234', 'Adam');

