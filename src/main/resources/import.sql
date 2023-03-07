drop table products if exists;
create table if not exists products (id bigserial, title varchar(255), price integer, PRIMARY KEY (id));
insert into products (title, price) VALUES ('first', 10),('second', 20),('third', 20);

