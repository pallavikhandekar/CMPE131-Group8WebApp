-- To start mysql on Mac: Execute /usr/local/mysql/bin/mysqld_safe as root or sudo
-- To execute this sql:  /usr/local/mysql/bin/mysql -uroot < create_db_table.sql
-- To start mysql on Mac: Execute /usr/local/mysql/bin/mysqld_safe as root or sudo
-- To start mysql prompt: /usr/local/mysql/bin/mysql
create database sanramon;
use sanramon;
CREATE USER sanramon IDENTIFIED BY 'sanramon';
grant all privileges on sanramon.* to sanramon@localhost;
grant usage on *.* to sanramon@localhost identified by 'sanramon';
create table sanramon_users (Company varchar(255),Department varchar(255) ,UserID varchar(255) ,User varchar(255),IPAddress varchar(255),LUN varchar(255),IOChannel varchar(255));

