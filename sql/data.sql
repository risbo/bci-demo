
create table user_phone
(
    user_info_id varchar(255) not null,
    citycode    varchar(255),
    contrycode  varchar(255),
    number      varchar(255)
);
create table user_info
(
    id         varchar(255) not null,
    created    timestamp,
    email      varchar(255),
    is_active  boolean,
    last_login varchar(255),
    modified   timestamp,
    name       varchar(255),
    password   varchar(255),
    token      varchar(255),
    primary key (id)
);

alter table user_phone
    add constraint FK6ia7lcvkumdagyeyr08jwtly9 foreign key (user_info_id) references user_info