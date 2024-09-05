create table person(
    id serial primary key,
    "name" varchar(200) not null,
    age int check (age > 0)
)

--without id
create table passport(
    person_id int primary key references person(id) on delete cascade,
    passport_number int not null
)

--with id (better)
create table passport(
    id serial primary key,
    passport_number int not null,
    person_id int unique references person(id) on delete cascade
)
