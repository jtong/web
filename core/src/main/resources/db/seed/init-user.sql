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

insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 1', 1000.00, '2012-1-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 6', 2000.00, '2012-2-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 6', 2000.00, '2012-3-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 4', 4000.00, '2012-4-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 5', 3000.00, '2012-5-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 5', 4000.00, '2012-5-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 5', 7000.00, '2012-6-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 8', 5000.00, '2012-7-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 8', 13000.00, '2012-8-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 10', 8000.00, '2012-9-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 15', 6000.00, '2012-10-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 12', 10000.00, '2012-11-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 14', 2000.00, '2012-12-29', 'INCOME');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 3', 3000.00, '2012-1-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 3', 10000.00, '2012-2-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 2', 2000.00, '2012-3-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 2', 2000.00, '2012-4-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('output 2', 2000.00, '2012-5-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 7', 1000.00, '2012-6-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 16', 8000.00, '2012-7-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 9', 7000.00, '2012-8-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 17', 2000.00, '2012-9-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 11', 9000.00, '2012-10-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 11', 7000.00, '2012-11-29', 'OUTPUT');
insert into ACCOUNT ( NAME, PRICE, PAID_TIME, TYPE ) values ('income 13', 4000.00, '2012-12-29', 'OUTPUT');

insert into USER ( NAME, PASSWORD, EMAIL, AGE, IS_ADMIN ) values ('admin', 'd41d8cd98f00b204e9800998ecf8427e','admin@abc.com', 21, true);

insert into Course ( NAME, SEQ, COACH, DURING ) values ('瑜伽', '1234', 'Adam', '2012-2-29 16:00, 2012-3-1 16:00, 2012-3-2 16:00, 2012-3-3 16:00');
insert into Course ( NAME, SEQ, COACH, DURING ) values ('动感单车', '1235', 'Adam', '2012-2-26 16:00, 2012-2-27 16:00, 2012-2-28 16:00, 2012-2-29 16:00');
insert into Course ( NAME, SEQ, COACH, DURING ) values ('健身操', '1236', 'Adam', '2012-2-22 16:00, 2012-2-23 16:00, 2012-2-24 16:00, 2012-2-25 16:00');
insert into Course ( NAME, SEQ, COACH, DURING ) values ('普拉提', '1237', 'Adam', '2012-2-18 16:00, 2012-2-19 16:00, 2012-2-20 16:00, 2012-2-21 16:00');

