-- Criação do Esquema
CREATE SCHEMA IF NOT EXISTS gerenciador_estacionamento;

-- Tabela Pessoa
CREATE TABLE gerenciador_estacionamento.pessoa (
    id BIGSERIAL PRIMARY KEY,
    apartamento VARCHAR(255),
    cpf VARCHAR(255),
    data_nascimento DATE,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    id_usuario BIGINT
);

-- Tabela Usuário
CREATE TABLE gerenciador_estacionamento.usuario (
    id BIGSERIAL PRIMARY KEY,
    alterado_por VARCHAR(255),
    criado_por VARCHAR(255),
    data_alteracao DATE,
    data_criacao DATE,
    login VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    status VARCHAR(255)
);

-- Tabela Vaga
CREATE TABLE gerenciador_estacionamento.vaga (
    id BIGSERIAL PRIMARY KEY,
    alterado_por VARCHAR(255),
    criado_por VARCHAR(255),
    data_alteracao DATE,
    data_criacao DATE,
    ocupada VARCHAR(255),
    status VARCHAR(255),
    id_veiculo BIGINT
);

-- Tabela Veículo
CREATE TABLE gerenciador_estacionamento.veiculo (
    id BIGSERIAL PRIMARY KEY,
    ano VARCHAR(255),
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    id_pessoa BIGINT,
    vaga_id BIGINT
);

-- V2__Add_FK_Pessoa_Usuario.sql
ALTER TABLE gerenciador_estacionamento.pessoa
ADD CONSTRAINT fk_pessoa_usuario
FOREIGN KEY (id_usuario)
REFERENCES gerenciador_estacionamento.usuario (id);

-- V3__Add_FK_Vaga_Veiculo.sql
ALTER TABLE gerenciador_estacionamento.vaga
ADD CONSTRAINT fk_vaga_veiculo
FOREIGN KEY (id_veiculo)
REFERENCES gerenciador_estacionamento.veiculo (id);

-- V4__Add_FK_Veiculo_Pessoa.sql
ALTER TABLE gerenciador_estacionamento.veiculo
ADD CONSTRAINT fk_veiculo_pessoa
FOREIGN KEY (id_pessoa)
REFERENCES gerenciador_estacionamento.pessoa (id)
ON DELETE CASCADE;

-- V5__Add_FK_Veiculo_Vaga.sql
ALTER TABLE gerenciador_estacionamento.veiculo
ADD CONSTRAINT fk_veiculo_vaga
FOREIGN KEY (vaga_id)
REFERENCES gerenciador_estacionamento.vaga(id);
