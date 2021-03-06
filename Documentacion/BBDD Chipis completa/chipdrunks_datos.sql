-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-01-2019 a las 13:33:03
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

--
-- Volcado de datos para la tabla `bar`
--

INSERT INTO `bar` (`bid`, `nombre`, `direccion`, `telefono`, `latitud`, `longitud`, `descripcion`, `imagen`) VALUES
(1, 'Bar el Alamo', 'Calle Madrid 2 ', 916564876, 40.4619445, -3.6741318, 'Chupitos Gratis de 00:00 a 00:30 los Martes', NULL),
(3, 'Bar el Fresxo', 'Calle del Mar 45', 915684752, 40.4634891, -3.6752189, 'Con el Fresco ven al Fresxo y tienes un 3x2 en Birra', NULL),
(4, 'Cerveceria Blanco y Azul', 'Calle Blanco Y Negro', 916582563, 40.4637448, -3.6764269, 'Si vienes de blanco y azul, únicamente, chupito gratis', NULL),
(5, 'Taberna la Cocodrila', 'Calle de los Cocodrilos Revoltosos 23 ', 916587455, 40.462959, -3.6780409, 'Todos los miercoles cerveza artesana nueva', NULL),
(6, 'Bar Pop Copas y tapas', 'Calle de la Tapa gratis 23', 916754787, 40.461812, -3.6767821, 'Ven 5 dias en tres semanas y te regalamos la tapa del mes con tu birra', NULL);

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
(1, 'Calentaos', 63),
(2, 'Zozor', 54),
(3, 'PowerLove', 23),
(4, 'Bears', 12),
(5, 'Blurp', 6),
(6, 'Blurp', 6);

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nid`, `nombre`, `cp`, `email`, `password`, `n_bares`) VALUES
(1, 'Charliesitooo', 28907, 'Charliesito@Gmail.com', ' charliesito ', 63),
(2, 'Er_palancas', 28912, 'er_palancas@gmail.es', 'er_palancas', 54),
(3, 'Borji', 28917, 'borji@gmail.es', 'borji', 23),
(4, 'Rickylito', 28933, 'rickylito@gmail.es', 'rickylito', 12),
(5, 'Jorgio', 28927, 'jorgio@gmail.es', 'jorgio', 6),
(6, 'Charlie', 28907, 'Charlie@Gmail.com', 'charlie', 63),
(7, 'Charlie', 28907, 'Charlie@Gmail.com', 'charlie', 63);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
