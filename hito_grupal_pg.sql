-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-06-2022 a las 14:56:27
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hito_grupal_pg`
--

CREATE TABLE `hito_grupal_pg` (
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  `mediaalumno` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hito_grupal_pg`
--

INSERT INTO `hito_grupal_pg` (`usuario`, `correo`, `contraseña`, `mediaalumno`) VALUES
('isla', 'isla@hitogrupal.com', 'Vivaelcubaton', 0),
('javi', 'javi@hitogrupal.com', 'Vivalavida', 9),
('sergio', 'sergio@hitogrupal.com', 'Vivalaformulauno', 8.4);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hito_grupal_pg`
--
ALTER TABLE `hito_grupal_pg`
  ADD PRIMARY KEY (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
