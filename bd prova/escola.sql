-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Jun-2022 às 21:23
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

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
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` bigint(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `celular` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `nome`, `cpf`, `endereco`, `email`, `celular`) VALUES
(1, 'arthur', 23764234, 'uhasdhuiasd', 'asdjasod', 71231),
(2, 'thiago', 123123123, 'duhasud', 'auahsdasd', 4323423);

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunocurso`
--

CREATE TABLE `alunocurso` (
  `matricula` int(11) NOT NULL,
  `curso_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `alunocurso`
--

INSERT INTO `alunocurso` (`matricula`, `curso_cod`) VALUES
(1, 11),
(2, 11),
(1, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `curso_cod` int(11) NOT NULL,
  `curso` text NOT NULL,
  `carga_h` int(11) NOT NULL,
  `curso_desc` text NOT NULL,
  `status` varchar(10) NOT NULL,
  `func_cod` int(11) NOT NULL,
  `sala_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`curso_cod`, `curso`, `carga_h`, `curso_desc`, `status`, `func_cod`, `sala_cod`) VALUES
(10, 'ciencias', 23423, 'asdausd', 'Ativo', 8, 3),
(11, 'letras', 470, 'viamao', 'Inativo', 9, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `func_cod` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` bigint(20) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `celular` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`func_cod`, `nome`, `cpf`, `endereco`, `email`, `celular`) VALUES
(8, 'maria', 11111, 'rua das conchas', 'teste.com', 985102019),
(9, 'marcio', 12312312, 'asijdaisjd', 'asijdasid', 3124234);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sala`
--

CREATE TABLE `sala` (
  `id_sala` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `local` varchar(30) NOT NULL,
  `capacidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `sala`
--

INSERT INTO `sala` (`id_sala`, `nome`, `local`, `capacidade`) VALUES
(3, '201', 'algarve', 200),
(4, '301', 'poa', 100);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `alunocurso`
--
ALTER TABLE `alunocurso`
  ADD KEY `curso_cod` (`curso_cod`),
  ADD KEY `matricula` (`matricula`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`curso_cod`),
  ADD KEY `func_cod` (`func_cod`),
  ADD KEY `sala_cod` (`sala_cod`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`func_cod`);

--
-- Índices para tabela `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id_sala`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `curso_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `func_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `sala`
--
ALTER TABLE `sala`
  MODIFY `id_sala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `alunocurso`
--
ALTER TABLE `alunocurso`
  ADD CONSTRAINT `alunocurso_ibfk_1` FOREIGN KEY (`curso_cod`) REFERENCES `curso` (`curso_cod`),
  ADD CONSTRAINT `alunocurso_ibfk_2` FOREIGN KEY (`matricula`) REFERENCES `aluno` (`matricula`);

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`func_cod`) REFERENCES `professor` (`func_cod`),
  ADD CONSTRAINT `curso_ibfk_2` FOREIGN KEY (`sala_cod`) REFERENCES `sala` (`id_sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
