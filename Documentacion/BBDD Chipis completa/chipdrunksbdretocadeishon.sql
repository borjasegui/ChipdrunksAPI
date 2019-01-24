-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-01-2019 a las 14:57:23
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `chipdrunks`
--
CREATE DATABASE IF NOT EXISTS `chipdrunks` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `chipdrunks`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bar`
--

CREATE TABLE `bar` (
  `bid` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bar_cerveza`
--

CREATE TABLE `bar_cerveza` (
  `bar` int(11) NOT NULL,
  `cerveza` int(11) NOT NULL,
  `bar_id` int(11) NOT NULL,
  `cerveza_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cerveza`
--

CREATE TABLE `cerveza` (
  `zid` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `porcentaje_alcohol` double NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clan`
--

CREATE TABLE `clan` (
  `cid` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `n_bares` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nid` int(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `cp` int(6) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `n_bares` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_clan`
--

CREATE TABLE `usuario_clan` (
  `usuario` int(11) NOT NULL,
  `clan` int(11) NOT NULL,
  `clan_id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`bid`);

--
-- Indices de la tabla `bar_cerveza`
--
ALTER TABLE `bar_cerveza`
  ADD KEY `bar` (`bar`),
  ADD KEY `cerveza` (`cerveza`),
  ADD KEY `FK2a4pv8r9ea1ovdn3v6fl2r3na` (`cerveza_id`),
  ADD KEY `FK3wce5sts13ypayg1foyweragh` (`bar_id`);

--
-- Indices de la tabla `cerveza`
--
ALTER TABLE `cerveza`
  ADD PRIMARY KEY (`zid`);

--
-- Indices de la tabla `clan`
--
ALTER TABLE `clan`
  ADD PRIMARY KEY (`cid`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nid`);

--
-- Indices de la tabla `usuario_clan`
--
ALTER TABLE `usuario_clan`
  ADD KEY `usuario` (`usuario`),
  ADD KEY `clan` (`clan`),
  ADD KEY `FKs2shuxqijjb1nc3vykyb01t6g` (`usuario_id`),
  ADD KEY `FK613g1ttnj019l52sidtfern5d` (`clan_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bar`
--
ALTER TABLE `bar`
  MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `cerveza`
--
ALTER TABLE `cerveza`
  MODIFY `zid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `clan`
--
ALTER TABLE `clan`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `nid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bar_cerveza`
--
ALTER TABLE `bar_cerveza`
  ADD CONSTRAINT `FK2a4pv8r9ea1ovdn3v6fl2r3na` FOREIGN KEY (`cerveza_id`) REFERENCES `cerveza` (`zid`),
  ADD CONSTRAINT `FK3wce5sts13ypayg1foyweragh` FOREIGN KEY (`bar_id`) REFERENCES `bar` (`bid`),
  ADD CONSTRAINT `rel_bar_cerveza` FOREIGN KEY (`cerveza`) REFERENCES `cerveza` (`zid`),
  ADD CONSTRAINT `rel_cerveza_bar` FOREIGN KEY (`bar`) REFERENCES `bar` (`bid`);

--
-- Filtros para la tabla `usuario_clan`
--
ALTER TABLE `usuario_clan`
  ADD CONSTRAINT `FK613g1ttnj019l52sidtfern5d` FOREIGN KEY (`clan_id`) REFERENCES `clan` (`cid`),
  ADD CONSTRAINT `FKs2shuxqijjb1nc3vykyb01t6g` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`nid`),
  ADD CONSTRAINT `rel_clan_user` FOREIGN KEY (`clan`) REFERENCES `clan` (`cid`),
  ADD CONSTRAINT `rel_user_clan` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
