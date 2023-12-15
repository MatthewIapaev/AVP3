create table users
(
    id       serial primary key,
    username varchar unique,
    password varchar,
    enabled  boolean default true
);

create table authorities
(
    username  varchar,
    authority varchar
);
