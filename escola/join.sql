1. Criação do Banco de Dados:

SQL

CREATE DATABASE escola;
2. Seleção do Banco de Dados:

SQL

USE escola;
3. Criação das Tabelas:

Tabela alunos:
SQL

CREATE TABLE alunos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    id_endereco INT,
    FOREIGN KEY (id_endereco) REFERENCES enderecos(id_endereco)
);
Tabela enderecos:
SQL

CREATE TABLE enderecos (
    id_endereco INT PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(100),
    numero VARCHAR(20),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    cep VARCHAR(9)
);
Tabela disciplinas:
SQL

CREATE TABLE disciplinas (
    id_disciplina INT PRIMARY KEY AUTO_INCREMENT,
    nome_disciplina VARCHAR(100),
    carga_horaria INT
);
Tabela turmas:
SQL

CREATE TABLE turmas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100)
);
Tabela professores:
SQL

CREATE TABLE professores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    id_endereco INT,
    FOREIGN KEY (id_endereco) REFERENCES enderecos(id_endereco)
);
Tabela historico:
SQL

CREATE TABLE historico (
    id INT PRIMARY KEY AUTO_INCREMENT,
    codigo_aluno INT,
    codigo_turma INT,
    data_historico DATE,
    codigo_disciplina INT,
    nota DECIMAL(5,2),
    frequencia VARCHAR(20),
    FOREIGN KEY (codigo_aluno) REFERENCES alunos(id),
    FOREIGN KEY (codigo_turma) REFERENCES turmas(id),
    FOREIGN KEY (codigo_disciplina) REFERENCES disciplinas(id_disciplina)
);
4. Inserção de Dados nas Tabelas:

(Insira os dados conforme o exemplo fornecido na sua pergunta)

5. Consultas com Joins:

Exemplo 1: Listar nome dos alunos e seus respectivos endereços:
SQL

SELECT alunos.nome, enderecos.logradouro, enderecos.numero
FROM alunos
INNER JOIN enderecos ON alunos.id_endereco = enderecos.id_endereco;


Exemplo 2: Listar nome dos alunos e suas respectivas turmas:
SQL

SELECT alunos.nome, turmas.nome
FROM alunos
INNER JOIN historico ON alunos.id = historico.codigo_aluno
INNER JOIN turmas ON historico.codigo_turma = turmas.id;


Exemplo 3: Listar nome dos alunos, suas notas e as disciplinas:
SQL

SELECT alunos.nome, historico.nota, disciplinas.nome_disciplina
FROM alunos
INNER JOIN historico ON alunos.id = historico.codigo_aluno
INNER JOIN disciplinas ON historico.codigo_disciplina = disciplinas.id_disciplina;
Observações:

As chaves estrangeiras são utilizadas para criar relacionamentos entre as tabelas, garantindo a integridade dos dados.
Os comandos JOIN permitem combinar dados de diferentes tabelas em uma única consulta.
Existem diferentes tipos de JOIN (INNER JOIN, LEFT JOIN, RIGHT JOIN, etc.), que podem ser utilizados de acordo com a necessidade da consulta.