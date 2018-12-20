-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-12-2018 a las 11:27:39
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

--
-- Volcado de datos para la tabla `bar`
--

INSERT INTO `bar` (`bid`, `nombre`, `direccion`, `telefono`, `latitud`, `longitud`, `descripcion`) VALUES
(1, 'Bar el Alamo', 'Calle Madrid 2 ', 916564876, 40.4619445, -3.6741318, 'Chupitos Gratis de 00:00 a 00:30 los Martes'),
(3, 'Bar el Fresxo', 'Calle del Mar 45', 915684752, 40.4634891, -3.6752189, 'Con el Fresco ven al Fresxo y tienes un 3x2 en Birra'),
(4, 'Cerveceria Blanco y Azul', 'Calle Blanco Y Negro', 916582563, 40.4637448, -3.6764269, 'Si vienes de blanco y azul, únicamente, chupito gratis'),
(5, 'Taberna la Cocodrila', 'Calle de los Cocodrilos Revoltosos 23 ', 916587455, 40.462959, -3.6780409, 'Todos los miercoles cerveza artesana nueva'),
(6, 'Bar Pop Copas y tapas', 'Calle de la Tapa gratis 23', 916754787, 40.461812, -3.6767821, 'Ven 5 dias en tres semanas y te regalamos la tapa del mes con tu birra');

--
-- Volcado de datos para la tabla `cerveza`
--

INSERT INTO `cerveza` (`zid`, `nombre`, `porcentaje_alcohol`, `descripcion`) VALUES
(1, 'alhambra', 6.3, 'rubia del sur de españa'),
(2, 'cruz campo', 5.4, 'cerveza barata y mala'),
(3, 'mahou', 4.6, 'madrid 5 estrellas'),
(4, 'san miguel', 3.7, 'gran cerveza para los filipinos'),
(5, 'leffe', 7.5, 'cerveza belga');

--
-- Volcado de datos para la tabla `clan`
--

INSERT INTO `clan` (`cid`, `nombre`, `n_bares`) VALUES
(1, 'Blurp', 6),
(2, 'Zozor', 54),
(3, 'Calentaos', 63),
(4, 'Bears', 12),
(5, 'PowerLover', 23),
(6, 'Happy Tree Friends', 1);

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nid`, `nombre`, `cp`, `email`, `password`, `n_bares`) VALUES
(1, 'Charlie', 28907, 'Charlie@gmail.es', 'charlie', 63),
(2, 'Er_palancas', 28912, 'er_palancas@gmail.es', 'er_palancas', 54),
(5, 'Borji', 28917, 'borji@gmail.es', 'borji', 23),
(6, 'Rickylito', 28933, 'rickylito@gmail.es', 'rickylito', 12),
(7, 'Jorgio', 28927, 'jorgio@gmail.es', 'jorgio', 6),
(8, 'Espinete', 28929, 'espinete@gmail.es', 'espinete', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
