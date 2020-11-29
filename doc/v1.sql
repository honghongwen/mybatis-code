create table user(
id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
name varchar(50) not null default "",
age int not null default 0,
gender tinyint not null default b'0' comment "0-男 1-女"
)