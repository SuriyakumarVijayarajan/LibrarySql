--book_details
--user_details
--supplier_details
--fine_details
--login_details
--signup_details
--book_issue_details


CREATE TABLE BOOK_DETAILS(
BOOK_CODE VARCHAR(10),
BOOK_TITLE VARCHAR(50) NOT NULL,
CATEGORY VARCHAR(15) NOT NULL,
AUTHOR VARCHAR(30) NOT NULL,
PRICE DECIMAL(8,2) NOT NULL,
RACK_NUM VARCHAR(3),
DATE_ARRIVAL DATE NOT NULL,
SUPPLIER_ID VARCHAR(3) NOT NULL
);
desc book_details;

CREATE TABLE USER_DETAILS(
USER_ID VARCHAR(10),
USER_NAME VARCHAR(30) NOT NULL,
CITY VARCHAR(20),
DATE_REGISTER DATE NOT NULL,
DATE_EXPIRE DATE ,
USER_ROLE VARCHAR2(20),
PASSWORD VARCHAR2(20) NOT NULL
);

CREATE TABLE SUPPLIER_DETAILS(
SUPPLIER_ID VARCHAR(3),
SUPPLIER_NAME VARCHAR(30) NOT NULL,
ADDRESS VARCHAR(50),
CONTACT INT NOT NULL
);
alter table book_details modify date_arrival varchar2(20);
desc supplier_details;

insert into supplier_details values ('003','vel co','trichy',98909);


CREATE TABLE FINE_DETAILS(
FINE_RANGE int,
FINE_AMOUNT DECIMAL(10,2) NOT NULL
);

drop table fine_Details;
ALTER TABLE FINE_DETAILS MODIFY FINE_RANGE VARCHAR(20);
DESC FINE_DETAILS;
SELECT * FROM FINE_DETAILS;


CREATE TABLE BOOK_ISSUE_DETAILS(
BOOK_ISSUE_NO INT,
USER_ID INT NOT NULL,
BOOK_CODE VARCHAR(10) NOT NULL,
DATE_ISSUE DATE NOT NULL,
DATE_RETURN DATE NOT NULL,
DATE_RETURNED DATE NULL,
FINE_RANGE int
);

CREATE TABLE ORDER_BOOK(
USER_NAME VARCHAR2(20),
BOOK_NAME VARCHAR2(30),
AUTHOR VARCHAR2(30),
SUPPLIER_ID VARCHAR(3));



DESC USER_DETAILS;
DESC SUPPLIER_DETAILS;
DESC FINE_DETAILS;
DESC BOOK_DETAILS;
DESC BOOK_ISSUE_DETAILS;
DESC ORDER_BOOK;
ALTER TABLE BOOK_ISSUE_DETAILS ADD CONSTRAINT PRIME5 PRIMARY KEY(BOOK_ISSUE_NO);
ALTER TABLE FINE_DETAILS ADD CONSTRAINT PRIME3 PRIMARY KEY(FINE_RANGE_IN_MONTH);
ALTER TABLE USER_DETAILS ADD CONSTRAINT PRIME1 PRIMARY KEY(USER_NAME);
ALTER TABLE USER_DETAILS MODIFY USER_NAME UNIQUE;
ALTER TABLE USER_DETAILS DROP UNIQUE (USER_NAME);
ALTER TABLE USER_DETAILS MODIFY PASSWORD UNIQUE;
ALTER TABLE BOOK_DETAILS ADD CONSTRAINT PRIME4 PRIMARY KEY(BOOK_TITLE);
ALTER TABLE BOOK_DETAILS MODIFY BOOK_CODE UNIQUE;
COMMIT;


select round(months_between(date_returned,date_return)) as fine_range from book_issue_details;



update user_details set mobile_no=9089089087,email_id ='balu@gmail.com' where user_id = 1019;

alter table book_issue_details modify fine_range_in_month default 0;
alter table book_details add user_name varchar2(20) default null;
alter table book_issue_details modify fine_range as (round(months_between(date_returned,date_return)));






commit;
alter table fine_details modify fine_range varchar(20);
alter table book_issue_details modify book_title varchar(50);

alter table book_issue_details rename column book_code to book_title;

insert into book_details (book_code,book_title,category,author,price,rack_num,date_arrival,supplier_id) values ('5006','Timon of Athens','Novel','Shakespeare','570','2','09-08-2018','003');
insert into book_details values ('5002','You Can Win','Philosophy','Shivkhera',350,'3','15-09-2017','003');

alter table book_details drop column publication;
alter table book_details add book_issue_no int default 0 ;
alter table book_details modify preRequest default 'none';
alter table user_details drop column date_register;
alter table user_details add mobile_no int unique;
alter table user_details add email_id varchar2(30) unique;
alter table  user_details add constraint un unique(user_name);
create sequence seq start with 1010 increment by 1 minvalue 1001 maxvalue 1200;
alter table supplier_details drop column supplier_id;
create sequence seq1 start with 101 increment by 1 minvalue 100 maxvalue 999;
alter table supplier_details add supplier_id int default seq1.nextval;
delete from user_details where user_id in 1022;
commit;
commit;

drop table order_book;
alter table order_book rename column supplier_id to supplier_name;
alter table book_details drop column date_arrival;
alter table order_book modify supplier_name varchar2(20);
commit;
update user_details set password = 'Sithan@123' where user_name='sithan';
update book_details set availability='available',user_name=null,book_issue_no=0 where book_title in 'Half Girlfriend'; 

Update BOOK_ISSUE_DETAILS set FINE_RANGE_IN_MONTH = (Round(Months_between(DATE_RETURNED,DATE_RETURN)));
delete book_issue_details where fine_range_in_month in 3;
update user_details set fine_amount=120 where user_name='mani';
delete user_details where user_name in 'mathi';
select * from user_details;
select * from book_details;
select * from book_issue_details;
select * from fine_details;
select * from supplier_details;
select * from order_book;
commit;
update book_details set availability='available';
update book_details set user_name=null;
update book_details set book_issue_no=0;
update book_details set prerequest = 'none' where prerequest is null;
update order_book set supplier_name='deepan' where user_name='hari';
create sequence biseq start with 101 increment by 1; 
alter table book_issue_details modify book_issue_no int default BISEQ.nextval;
alter table book_issue_details drop column book_issue_no;
delete from book_issue_details where fine_range_in_month in 12;
alter table book_issue_details add book_issue_no int generated always as identity(start with 1 increment by 1);
update book_details set book_issue_no=14 where book_code=5002;


update user_details
set userwallet = (userwallet - 45)
where user_name in 'mani';
delete from fine_history where collected_time like'%07:44:%';

create table fine_history(
user_name varchar2(20),
fine_amount int,
collected_time timestamp default current_timestamp);
commit;
select * from fine_history;
select * from user_details;
select * from book_details;
select book_title from book_details where availability in 'available' and prerequest is  null or prerequest in 'hari';
alter table user_details add userWallet int default 1000;
alter table user_details drop column userWallet;
alter table book_issue_details modify date_issue default sysdate;
alter table book_issue_details modify date_returned default add_months(sysdate,3);
insert into book_issue_details (user_name,book_title) values ('kamal','King Lear');
update user_details 
set fine_amount=0,wallet=sum(wallet-25) 
where user_name in mani;


commit;


select * from user_details;
select * from book_details;
select * from book_issue_details;
select * from fine_details;
select * from supplier_details;
select * from order_book;
select * from fine_history;
commit;
