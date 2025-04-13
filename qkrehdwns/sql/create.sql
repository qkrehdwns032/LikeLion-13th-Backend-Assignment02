use movie;

create table users(
	id int auto_increment primary key,
    name varchar(20) not null, -- 이름은 반드시 입력해야 하므로 not null사용
    email varchar(30) unique -- 이메일 중복을 방지하기 위해 unique사용
);

create table movie(
	id int auto_increment primary key,
    title varchar(40) not null,
    director varchar(30) not null,
	user_id int,
    foreign key (user_id) references user(id)
);
