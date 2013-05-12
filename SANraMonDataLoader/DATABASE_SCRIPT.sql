create database sanramon;
use sanramon;
CREATE USER sanramon IDENTIFIED BY 'sanramon'; 
grant usage on *.* to sanramon@localhost identified by 'sanramon'; 
grant all privileges on sanramon.* to sanramon@localhost;

CREATE TABLE monitor_data (IO_TYPE VARCHAR(30) NOT NULL, 
    IO_CHANNEL VARCHAR(30) NOT NULL,
    LUN VARCHAR(30) NOT NULL, 
	MON_TIMESTAMP VARCHAR(30) NOT NULL, 
    IP_ADDR VARCHAR(30) NOT NULL, 
    NO_OF_DATABLOCKS VARCHAR(30) NOT NULL, 
    DURATION VARCHAR(30) NOT NULL,
    IOPS VARCHAR(30) NOT NULL);

create table sanramon_users (Company varchar(255),Department varchar(255) ,UserID varchar(255) ,User varchar(255),IPAddress varchar(255),LUN varchar(255),IOChannel varchar(255));
