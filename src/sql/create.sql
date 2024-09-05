create table person(
    id serial primary key,
    "name" varchar(200) not null,
    age int check (age > 0)
)

create table passport(
    person_id int primary key references person(id) on delete cascade,
    passport_number int not null
)
