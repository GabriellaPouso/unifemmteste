-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26/01/2025 às 01:29
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `escola`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `alunos`
--

CREATE TABLE `alunos` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `alunos`
--

INSERT INTO `alunos` (`id`, `nome`, `email`, `id_endereco`) VALUES
(6, 'João da Silva', 'joao@email.com', 1),
(7, 'Maria Souza', 'maria@email.com', 2),
(8, 'Pedro Gomes', 'pedro@email.com', 3),
(9, 'Ana Silva', 'ana@email.com', 4),
(10, 'Carlos', 'carlos@email.com', 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `id_disciplina` int(11) NOT NULL,
  `nome_disciplina` varchar(100) DEFAULT NULL,
  `carga_horaria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `disciplinas`
--

INSERT INTO `disciplinas` (`id_disciplina`, `nome_disciplina`, `carga_horaria`) VALUES
(1, 'Matemática', 90),
(2, 'Português', 90),
(3, 'História', 72),
(4, 'Geografia', 72),
(5, 'Ciências', 72),
(6, 'Inglês', 90),
(7, 'Educação Física', 60),
(8, 'Artes', 60),
(9, 'Música', 60),
(10, 'Filosofia', 60);

-- --------------------------------------------------------

--
-- Estrutura para tabela `enderecos`
--

CREATE TABLE `enderecos` (
  `id_endereco` int(11) NOT NULL,
  `logradouro` varchar(100) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `enderecos`
--

INSERT INTO `enderecos` (`id_endereco`, `logradouro`, `numero`, `bairro`, `cidade`, `estado`, `cep`) VALUES
(1, 'Rua dos Bobos', '123', 'Centro', 'São Paulo', 'SP', '01001-000'),
(2, 'Avenida Brasil', '456', 'Jardim', 'Rio de Janeiro', 'RJ', '20000-000'),
(3, 'Rua das Flores', '789', 'Vila', 'Belo Horizonte', 'MG', '31000-000'),
(4, 'Rua Principal', '100', 'Bairro Novo', 'Curitiba', 'PR', '80000-000'),
(5, 'Avenida Central', '200', 'Centro', 'Salvador', 'BA', '40000-000'),
(6, 'Rua dos Professores', '123', 'Centro', 'São Paulo', 'SP', '01001-000'),
(7, 'Avenida dos Educadores', '456', 'Jardim', 'Rio de Janeiro', 'RJ', '20000-000'),
(8, 'Rua da Sabedoria', '789', 'Vila', 'Belo Horizonte', 'MG', '31000-000'),
(9, 'Rua da Escola', '100', 'Bairro Novo', 'Curitiba', 'PR', '80000-000'),
(10, 'Avenida do Conhecimento', '200', 'Centro', 'Salvador', 'BA', '40000-000');

-- --------------------------------------------------------

--
-- Estrutura para tabela `historico`
--

CREATE TABLE `historico` (
  `id` int(11) NOT NULL,
  `codigo_aluno` int(11) DEFAULT NULL,
  `codigo_turma` int(11) DEFAULT NULL,
  `data_historico` date DEFAULT NULL,
  `codigo_disciplina` int(11) DEFAULT NULL,
  `nota` decimal(5,2) DEFAULT NULL,
  `frequencia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `historico`
--

INSERT INTO `historico` (`id`, `codigo_aluno`, `codigo_turma`, `data_historico`, `codigo_disciplina`, `nota`, `frequencia`) VALUES
(53, 10, 5, '2023-12-31', 1, 9.50, '90%'),
(63, 6, 1, '2023-12-31', 1, 7.00, '90%'),
(73, 7, 2, '2023-12-31', 1, 7.00, '90%'),
(83, 8, 3, '2023-12-31', 1, 7.00, '90%'),
(93, 9, 4, '2023-12-31', 1, 7.00, '90%');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professores`
--

CREATE TABLE `professores` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `id_endereco` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `professores`
--

INSERT INTO `professores` (`id`, `nome`, `email`, `id_endereco`) VALUES
(1, 'Professor João Silva', 'joao.silva@escola.com', 6),
(2, 'Professora Maria Souza', 'maria.souza@escola.com', 7),
(3, 'Professor Pedro Gomes', 'pedro.gomes@escola.com', 8),
(4, 'Professora Ana Oliveira', 'ana.oliveira@escola.com', 9),
(5, 'Professor Carlos Santos', 'carlos.santos@escola.com', 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `turmas`
--

CREATE TABLE `turmas` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `turmas`
--

INSERT INTO `turmas` (`id`, `nome`) VALUES
(1, '1º Ano A'),
(2, '1º Ano B'),
(3, '2º Ano A'),
(4, '2º Ano B'),
(5, '3º Ano A');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_endereco` (`id_endereco`);

--
-- Índices de tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`id_disciplina`);

--
-- Índices de tabela `enderecos`
--
ALTER TABLE `enderecos`
  ADD PRIMARY KEY (`id_endereco`);

--
-- Índices de tabela `historico`
--
ALTER TABLE `historico`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idx_aluno_turma` (`codigo_aluno`,`codigo_turma`),
  ADD KEY `codigo_turma` (`codigo_turma`),
  ADD KEY `codigo_disciplina` (`codigo_disciplina`);

--
-- Índices de tabela `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_endereco` (`id_endereco`);

--
-- Índices de tabela `turmas`
--
ALTER TABLE `turmas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alunos`
--
ALTER TABLE `alunos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `id_disciplina` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `enderecos`
--
ALTER TABLE `enderecos`
  MODIFY `id_endereco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `historico`
--
ALTER TABLE `historico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT de tabela `professores`
--
ALTER TABLE `professores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `turmas`
--
ALTER TABLE `turmas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `alunos`
--
ALTER TABLE `alunos`
  ADD CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `enderecos` (`id_endereco`);

--
-- Restrições para tabelas `historico`
--
ALTER TABLE `historico`
  ADD CONSTRAINT `historico_ibfk_1` FOREIGN KEY (`codigo_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `historico_ibfk_2` FOREIGN KEY (`codigo_turma`) REFERENCES `turmas` (`id`),
  ADD CONSTRAINT `historico_ibfk_3` FOREIGN KEY (`codigo_disciplina`) REFERENCES `disciplinas` (`id_disciplina`);

--
-- Restrições para tabelas `professores`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `professores_ibfk_1` FOREIGN KEY (`id_endereco`) REFERENCES `enderecos` (`id_endereco`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
