-- Tabela de Operadores
create table operador
(
    id       serial primary key,
    nome     varchar(150) not null,
    cpf      varchar(14)  not null unique,
    username varchar(120) not null unique,
    password text         not null
);

-- tabela permissoes de acesso
create table roles
(
    id        serial primary key,
    nome_role varchar(100) not null
);


-- Gerencia permissoes de acesso
create table operadores_roles
(
    id_operador integer not null,
    FOREIGN KEY (id_operador) REFERENCES operador (id),
    id_role     integer not null,
    FOREIGN KEY (id_role) REFERENCES roles (id)
);


--Roles
insert into roles(id, nome_role)
values (1, 'ROLE_ADMIN');
insert into roles(id, nome_role)
values (2, 'ROLE_USER');


--Operador root - login: root, password:123
insert into operador(nome, cpf, username, password)
values ('root', '000.000.000-00', 'root', '$2a$10$hzXXzANJ8pE9WIYfExGh6OJVuoqkHK1FYaf3QXUfRabJwbAleLA66');

--Operador user: (usuario comum) login: user, password 123
insert into operador(nome, cpf, username, password)
values ('user', '111.111.11-111', 'user', '$2a$10$hzXXzANJ8pE9WIYfExGh6OJVuoqkHK1FYaf3QXUfRabJwbAleLA66');


-- Permissoes
--Operador Root possui permissoes a todas as roles
insert into operadores_roles(id_operador, id_role)
values (1, 1);
insert into operadores_roles(id_operador, id_role)
values (1, 2);


--Operador "user" possui permissoes "basicas"
insert into operadores_roles(id_operador, id_role)
values (2, 2);




