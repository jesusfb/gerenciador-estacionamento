-- Tabela Usuário
CREATE TABLE "usuario"(
    id BIGSERIAL PRIMARY KEY,
    alterado_por VARCHAR(255),
    criado_por VARCHAR(255),
    data_alteracao timestamp,
    data_criacao timestamp,
    nome VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    status VARCHAR(255)
);
-- Tabela Proprietario
CREATE TABLE "proprietario"(
    id BIGSERIAL PRIMARY KEY,
    apartamento VARCHAR(255),
    cpf_cnpj VARCHAR(255),
    data_nascimento timestamp,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    id_usuario BIGINT
);

-- Tabela Vaga
CREATE TABLE "vaga"(
    id BIGSERIAL PRIMARY KEY,
    alterado_por VARCHAR(255),
    criado_por VARCHAR(255),
    data_alteracao timestamp,
    data_criacao timestamp,
    ocupada VARCHAR(255),
    status VARCHAR(255),
    id_veiculo BIGINT
);

-- Tabela Veículo
CREATE TABLE "veiculo"(
    id BIGSERIAL PRIMARY KEY,
    ano VARCHAR(255),
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    id_pessoa BIGINT,
    vaga_id BIGINT
);

-- V2__Add_FK_Pessoa_Usuario.sql
ALTER TABLE "proprietario"
ADD CONSTRAINT fk_pessoa_usuario
FOREIGN KEY (id_usuario)
REFERENCES "usuario" (id);

-- V3__Add_FK_Vaga_Veiculo.sql
ALTER TABLE "vaga"
ADD CONSTRAINT fk_vaga_veiculo
FOREIGN KEY (id_veiculo)
REFERENCES "veiculo" (id);

-- V4__Add_FK_Veiculo_Pessoa.sql
ALTER TABLE "veiculo"
ADD CONSTRAINT fk_veiculo_pessoa
FOREIGN KEY (id_pessoa)
REFERENCES "proprietario" (id)
ON DELETE CASCADE;

-- V5__Add_FK_Veiculo_Vaga.sql
ALTER TABLE "veiculo"
ADD CONSTRAINT fk_veiculo_vaga
FOREIGN KEY (vaga_id)
REFERENCES "vaga" (id);

INSERT INTO "usuario"
(alterado_por, criado_por, data_alteracao, data_criacao, email, "password", "role", status)
VALUES(null, null, null, CURRENT_TIMESTAMP, 'admin', '$2a$10$EizuTnm1gIcWV2kXX6ZsSeUJ9sWQu./oCljAJ9ASuWoC61D6lyO2O', 'ADMIN', 'A');