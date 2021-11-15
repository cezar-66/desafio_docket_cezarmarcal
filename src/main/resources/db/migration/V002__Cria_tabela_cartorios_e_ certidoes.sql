create table certidoes
(
    cert_id serial primary key,
    nome    varchar(100) not null
);

create table cartorios(
    cartorio_id serial primary key,
    nome        varchar(100) not null,
    endereco    varchar(100) not null
);

create table cartorio_certidao(
    cartorio_id integer,
    foreign key (cartorio_id) references cartorios (cartorio_id),
    certidao_id integer,
    foreign key (certidao_id) references certidoes (cert_id)
);