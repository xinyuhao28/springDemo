drop table if exists t_coffee ;
drop table if exists t_order ;
drop table if exists t_order_coffee ;

create table t_coffee (
                          id bigint auto_increment,
                          create_time timestamp,
                          update_time timestamp,
                          name varchar(255),
                          price bigint,
                          primary key (id)
)engine=InnoDB;

create table t_order (
                         id bigint auto_increment,
                         create_time timestamp,
                         update_time timestamp,
                         customer varchar(255),
                         state integer not null,
                         primary key (id)
)engine=InnoDB;

create table t_order_coffee (
                                coffee_order_id bigint not null,
                                items_id bigint not null
)engine=InnoDB;
