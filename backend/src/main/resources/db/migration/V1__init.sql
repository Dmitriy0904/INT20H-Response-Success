create table IF NOT EXISTS auctions (
        id bigserial not null,
        actual_price float(53),
        description varchar(255),
        name varchar(255),
        photo_url varchar(255),
        start_price float(53),
        status varchar(255) check (status in ('PENDING','ACTIVE','CLOSED','REMOVED')),
        users_id bigint,
        primary key (id)
);

create table if not exists bids (
        id bigserial not null,
        amount float(53),
        created_date bigint,
        auction_id bigint,
        users_id bigint,
        primary key (id)
);

create table if not exists users (
        id bigserial not null,
        email varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (id)
);

alter table if exists auctions
    add constraint FK1wjj56uw2m7y8hrgsdk96bup6
    foreign key (users_id)
    references users;

alter table if exists bids
    add constraint FKbm89m2gow82dotpnlcp7t3p5f
    foreign key (auction_id)
    references auctions;

alter table if exists bids
    add constraint FK4o74kyqmvuij72yuprdlyu2ge
    foreign key (users_id)
    references users;