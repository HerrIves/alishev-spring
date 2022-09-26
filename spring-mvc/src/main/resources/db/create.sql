create table person(
    id    int generated by default as identity primary key,
    name  varchar not null,
    age   int check (age > 0),
    email varchar unique
)