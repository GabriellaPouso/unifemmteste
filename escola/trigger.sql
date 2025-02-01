.

1. Criação do Banco de Dados:

SQL

CREATE DATABASE escola;
2. Seleção do Banco de Dados:

SQL

USE escola;
3. Criação das Tabelas e Atributos:

Tabela alunos:

id (INT, PRIMARY KEY, AUTO_INCREMENT)
nome (VARCHAR(100))
data_nascimento (DATE)
email (VARCHAR(100))
id_turma (INT, FOREIGN KEY referencing turmas(id))
Tabela turmas:

id (INT, PRIMARY KEY, AUTO_INCREMENT)
nome (VARCHAR(50))
ano (INT)
Tabela professores:

id (INT, PRIMARY KEY, AUTO_INCREMENT)
nome (VARCHAR(100))
email (VARCHAR(100))
Tabela disciplinas:

id (INT, PRIMARY KEY, AUTO_INCREMENT)
nome (VARCHAR(100))
carga_horaria (INT)
Tabela matriculas:

id (INT, PRIMARY KEY, AUTO_INCREMENT)
id_aluno (INT, FOREIGN KEY referencing alunos(id))
id_disciplina (INT, FOREIGN KEY referencing disciplinas(id))
id_professor (INT, FOREIGN KEY referencing professores(id))
data_matricula (DATE)
4. Criação do Trigger:

Vamos criar um trigger que será acionado após a inserção de um novo registro na tabela matriculas. O trigger irá verificar se o aluno já está matriculado na disciplina e, em caso afirmativo, impedirá a inserção, lançando um erro.

SQL

CREATE TRIGGER tr_verifica_matricula
BEFORE INSERT ON matriculas
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1
        FROM matriculas
        WHERE id_aluno = NEW.id_aluno
          AND id_disciplina = NEW.id_disciplina
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Aluno já matriculado nesta disciplina.';
    END IF;
END;
5. Testando o Trigger:

Inserção válida:
SQL

INSERT INTO matriculas (id_aluno, id_disciplina, id_professor, data_matricula)
VALUES (1, 1, 1, '2024-01-15');
Inserção inválida (aluno já matriculado na disciplina):
SQL

INSERT INTO matriculas (id_aluno, id_disciplina, id_professor, data_matricula)
VALUES (1, 1, 2, '2024-01-20');
A segunda inserção irá gerar um erro, pois o trigger impedirá a matrícula duplicada.

Observações:

Este é um exemplo simples de trigger. É possível criar triggers mais complexos para realizar diversas ações, como logs, auditoria, cálculos, etc.
O trigger BEFORE INSERT é acionado antes da inserção do registro. Existem outros tipos de triggers, como AFTER INSERT, BEFORE UPDATE, AFTER UPDATE, BEFORE DELETE e AFTER DELETE.
A mensagem de erro definida no trigger pode ser personalizada.