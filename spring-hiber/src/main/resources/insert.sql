drop table person;

create table person(
                       id int primary key generated by default  as identity,
                       name varchar(100),
                       age int check ( age >0 )
);

insert into person(name, age) values ('Tom', 35);
insert into person(name, age) values ('bob', 52);
insert into person(name, age) values ('kate', 14);

create table item(
                     id int generated by default as identity,
                     person_id int references person(id),
                     item_name varchar(100)
);

insert into Item(person_id, item_name) VALUES (1, 'book');
insert into Item(person_id, item_name) VALUES (1, 'airpods');
insert into Item(person_id, item_name) VALUES (2, 'iphone');
insert into Item(person_id, item_name) VALUES (3, 'kindle');
insert into Item(person_id, item_name) VALUES (3, 'TV');
insert into Item(person_id, item_name) VALUES (3, 'Playstation');

