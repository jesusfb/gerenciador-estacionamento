create table pessoa (
    id bigint generated by default as identity,
    apartamento varchar(255),
    cpf varchar(255),
    data_nascimento date,
    nome varchar(255) not null,
    telefone varchar(255),
    id_usuario bigint,
    primary key (id)
);

create table usuario (
    id bigint generated by default as identity,
    alterado_por varchar(255),
    criado_por varchar(255),
    data_alteracao date,
    data_criacao date,
    login varchar(255),
    password varchar(255),
    role varchar(255),
    status varchar(255),
    primary key (id)
);

create table vaga (
    id bigint generated by default as identity,
    alterado_por varchar(255),
    criado_por varchar(255),
    data_alteracao date,
    data_criacao date,
    ocupada varchar(255),
    status varchar(255),
    id_veiculo bigint,
    primary key (id)
);

create table veiculo (
    id bigint generated by default as identity,
    ano varchar(255),
    marca varchar(255),
    modelo varchar(255),
    placa varchar(255),
    id_pessoa bigint,
    vaga_id bigint,
    primary key (id)
);

alter table pessoa
    add constraint fk_pessoa_usuario
    foreign key (id_usuario)
    references usuario (id);

alter table vaga
    add constraint fk_vaga_veiculo
    foreign key (id_veiculo)
    references veiculo (id);

alter table veiculo
    add constraint fk_veiculo_pessoa
    foreign key (id_pessoa)
    references pessoa (id)
    on delete cascade;

alter table veiculo
    add constraint fk_veiculo_vaga
    foreign key (vaga_id)
    references vaga (id);
