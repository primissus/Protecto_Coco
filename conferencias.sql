-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 02, 2017 at 09:22 
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `conferencias`
--

-- --------------------------------------------------------

--
-- Table structure for table `asistencia`
--

CREATE TABLE `asistencia` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_conferencia` int(11) NOT NULL,
  `asiste` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asistencia`
--

INSERT INTO `asistencia` (`id`, `id_usuario`, `id_conferencia`, `asiste`) VALUES
(1, 1, 1, 0),
(2, 2, 1, 0),
(3, 3, 1, 0),
(5, 1, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `conferencia`
--

CREATE TABLE `conferencia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `expositor` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `fecha_hora` date NOT NULL,
  `sala` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `costo` int(11) NOT NULL,
  `encargado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conferencia`
--

INSERT INTO `conferencia` (`id`, `nombre`, `expositor`, `capacidad`, `fecha_hora`, `sala`, `descripcion`, `costo`, `encargado`) VALUES
(1, 'a', 'a', 12, '2017-12-12', 12, 'abcde', 12, 5),
(2, 'b', 'b', 12, '2017-11-12', 12, '12', 12, 5),
(3, 'c', 'c', 12, '2017-10-12', 12, '12', 12, 5),
(4, 'd', 'd', 12, '2017-09-12', 12, '12', 12, 5);

-- --------------------------------------------------------

--
-- Table structure for table `publico`
--

CREATE TABLE `publico` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `domicilio` varchar(40) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `correo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `publico`
--

INSERT INTO `publico` (`id`, `nombre`, `domicilio`, `telefono`, `correo`) VALUES
(1, 'abc', 'abc', '123', 'abc'),
(2, 'abcd', 'abcd', '134', 'abcd'),
(3, 'abcde', 'abcde', 'abcde', 'abcde'),
(4, 'abcdef', 'abcdef', '135', 'abcdef');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tipo` enum('adm','enc') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `username`, `password`, `tipo`) VALUES
(4, 'Jason', 'Rivera', 'jason', '12345', 'adm'),
(5, 'Jose', 'Rivera', 'jose', '12345', 'enc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_conferencia` (`id_conferencia`);

--
-- Indexes for table `conferencia`
--
ALTER TABLE `conferencia`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publico`
--
ALTER TABLE `publico`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `conferencia`
--
ALTER TABLE `conferencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `publico`
--
ALTER TABLE `publico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
