-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2015 a las 10:13:12
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `centrocomercial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pass` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `role` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=26 ;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `user`, `pass`, `role`) VALUES
(1, 'climaria', 'maria', 'CLI'),
(2, 'climaitane', 'maitane', 'CLI'),
(3, 'empjuan', 'juan', 'EMP'),
(4, 'emposcar', 'oscar', 'EMP'),
(5, 'emplaura', 'laura', 'EMP'),
(6, 'empmikel', 'mikel', 'EMP'),
(7, 'empjavier', 'javier', 'EMP'),
(8, 'emproberto', 'roberto', 'EMP'),
(9, 'empnekane', 'nekane', 'EMP'),
(10, 'climaite', 'maite', 'CLI'),
(11, 'cliruben', 'ruben', 'CLI'),
(12, 'clijose', 'jose', 'CLI'),
(13, 'clicarlos', 'carlos', 'CLI'),
(14, 'climarta', 'marta', 'CLI'),
(15, 'cliana', 'ana', 'CLI'),
(16, 'cliainara', 'ainara', 'CLI'),
(22, 'cliolaia', 'olaia', 'CLI'),
(23, 'climarga', 'marga', 'CLI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pass` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `online` int(11) DEFAULT NULL,
  `hora_conexion` date DEFAULT NULL,
  `role` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `user`, `pass`, `nombre`, `apellidos`, `ruta_imagen`, `online`, `hora_conexion`, `role`) VALUES
(1, 'climaria', 'maria', 'Maria', 'Gonzalez Palacios', 'resources/images/cliente/default.png', 0, '2015-12-10', 'CLI'),
(2, 'climaitane', 'maitane', 'Maitane', 'Iturriaga Andres', 'resources/images/cliente/default.png', 0, '2015-12-10', 'CLI'),
(3, 'climaite', 'maite', 'Maite', 'Perez Garcia', 'resources/images/cliente/default.png', 0, '2015-11-04', 'CLI'),
(4, 'cliruben', 'ruben', 'Ruben', 'Gonzalez Casas', 'resources/images/cliente/default.png', 0, '2015-10-14', 'CLI'),
(5, 'clijose', 'jose', 'José', 'Alvarez Zabala', 'resources/images/cliente/default.png', 0, '2015-11-17', 'CLI'),
(6, 'clicarlos', 'carlos', 'Carlos', 'Santos Lopez', 'resources/images/cliente/default.png', 0, '2015-12-10', 'CLI'),
(7, 'climarta', 'marta', 'Marta', 'Garcia Garate', 'resources/images/cliente/default.png', 0, '2015-10-12', 'CLI'),
(8, 'cliana', 'ana', 'Ana', 'Marcos Rosal', 'resources/images/cliente/default.png', 0, '2015-09-06', 'CLI'),
(9, 'cliainara', 'ainara', 'Ainara', 'Egiluz Egiluz', 'resources/images/cliente/default.png', 0, '2015-08-03', 'CLI'),
(14, 'cliolaia', 'olaia', 'Olaia', 'Garcia Martinez', 'resources/images/cliente/default.png', 0, '2015-12-10', 'CLI'),
(15, 'climarga', 'marga', 'Marga', 'Gonzalez Cano', 'resources/images/cliente/default.png', 0, '2015-12-10', 'CLI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `pass` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellidos` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `online` int(11) DEFAULT NULL,
  `hora_conexion` date DEFAULT NULL,
  `role` varchar(3) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tienda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `codTienda` (`tienda`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `user`, `pass`, `nombre`, `apellidos`, `ruta_imagen`, `online`, `hora_conexion`, `role`, `tienda`) VALUES
(1, 'empjuan', 'juan', 'Juan', 'Gonzalez Martinez', 'resources/images/empleado/default.png', 0, '2015-12-09', 'EMP', 2),
(2, 'emposcar', 'oscar', 'Oscar', 'Rodriguez Iturraspe', 'resources/images/empleado/default.png', 0, '2015-12-09', 'EMP', 1),
(3, 'emplaura', 'laura', 'Laura', 'Frias Gutierrez', 'resources/images/empleado/default.png', 0, '2015-12-10', 'EMP', 3),
(4, 'empmikel', 'mikel', 'Mikel', 'Salazar Garcia', 'resources/images/empleado/default.png', 0, '2015-12-09', 'EMP', 4),
(5, 'empjavier', 'javier', 'Javier', 'Ramirez Romo', 'resources/images/empleado/default.png', 0, '2015-11-02', 'EMP', 7),
(6, 'emproberto', 'roberto', 'Roberto', 'Sanchez Revuelta', 'resources/images/empleado/default.png', 0, '2015-11-02', 'EMP', 5),
(7, 'empnekane', 'nekane', 'Nekane', 'Ruiz Ruiz', 'resources/images/empleado/default.png', 0, '2015-11-02', 'EMP', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `disponible` int(11) DEFAULT NULL,
  `cliente` int(11) DEFAULT NULL,
  `tienda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `codCliente` (`cliente`),
  KEY `codCliente_2` (`cliente`),
  KEY `codTienda` (`tienda`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=267 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `ruta_imagen`, `disponible`, `cliente`, `tienda`) VALUES
(1, 'Bota', 'Bota de lluvia. \r\nTallas de la 35-40', 'resources/images/producto/calzado/bota1.jpg', 1, 2, 4),
(2, 'Peluche', 'Muñeco de peluche', 'resources/images/producto/juguetes/juguete12.jpg', 1, 1, 3),
(3, 'Camiseta Azul', 'Camiseta azul manga corta.\r\nTalla S/M/L', 'resources/images/producto/ropa/camiseta1.jpg', 1, 1, 1),
(4, 'Camiseta gris ', 'Camiseta gris mangas negras', 'resources/images/producto/ropa/camiseta2.jpg', 1, 1, 1),
(5, 'Camiseta Rosa', 'Manga Corta.\r\nTallas S/M/L', 'resources/images/producto/ropa/camiseta3.jpg', 1, 1, 1),
(6, 'Chaqueta de cuero', 'Chaqueta negra\r\nTallas S/M/L', 'resources/images/producto/ropa/chaqueta1.jpg', 1, 1, 1),
(7, 'Camiseta morada', 'Manga larga\r\nTallas S/M/L', 'resources/images/producto/ropa/camiseta4.jpg', 1, 2, 1),
(8, 'Chaqueta de punto', 'Chaqueta de punto negra\r\nTallas S/M/L', 'resources/images/producto/ropa/chaqueta2.jpg', 1, 1, 1),
(9, 'Chaqueta verde', 'Chaqueta de lana verde\r\nTallas S/M/L', 'resources/images/producto/ropa/chaqueta3.jpg', 1, 1, 1),
(10, 'Chaqueta de invierno', 'Chaqueta negra\r\nTallas S/M/L', 'resources/images/producto/ropa/chaqueta4.jpg', 1, 1, 1),
(11, 'Falda roja', 'Falda de volantes roja\r\nTallas S/M/L', 'resources/images/producto/ropa/falda1.jpg', 1, 1, 1),
(12, 'Falda azul', 'Falda con vuelo azul\r\nTallas S/M/L', 'resources/images/producto/ropa/falda2.jpg', 1, 2, 1),
(13, 'Falda rosa', 'Falda rosa\r\nTallas S/M/L', 'resources/images/producto/ropa/falda4.jpg', 1, 1, 1),
(14, 'Falda verde', 'Falda larga verde\r\nTallas S/M/L', 'resources/images/producto/ropa/falda3.jpg', 1, 1, 1),
(15, 'Pantalon corto', 'Pantalon corto vaquero\r\nTallas S/M/L', 'resources/images/producto/ropa/pantalon1.jpg', 1, 1, 1),
(16, 'Pantalon beis', 'Pantalon beis tipo leggin\r\nTallas S/M/L', 'resources/images/producto/ropa/pantalon2.jpg', 1, 1, 1),
(17, 'Pantalon negro', 'Pantalon negro tipo monte\r\nTallas S/M/L', 'resources/images/producto/ropa/pantalon3.jpg', 1, 1, 1),
(18, 'Pantalon azul marino', 'Pantalon corto azul marino\r\nTallas S/M/L', 'resources/images/producto/ropa/pantalon4.jpg', 1, 1, 1),
(19, 'Pijama rayas', 'Pijama a rayas para chica\r\nTallas S/M/L', 'resources/images/producto/ropa/pijama1.jpg', 1, 1, 1),
(20, 'Pijama lunares', 'Pijama de lunares para chica\r\nTallas S/M/L', 'resources/images/producto/ropa/pijama2.jpg', 1, 1, 1),
(21, 'Pijama a rayas', 'Pijama a rayas para chico\r\nTallas S/M/L', 'resources/images/producto/ropa/pijama3.jpg', 1, 1, 1),
(22, 'Pijama being wild', 'Pijama para chico\r\nTallas S/M/L', 'resources/images/producto/ropa/pijama4.jpg', 1, 1, 1),
(23, 'Vestido verde', 'Vestido verde\r\nTallas S/M/L', 'resources/images/producto/ropa/vestido1.jpg', 1, 1, 1),
(24, 'Vestido negro', 'Vestido negro\r\nTallas S/M/L', 'resources/images/producto/ropa/vestido2.jpg', 1, 1, 1),
(25, 'Vestido rojo', 'Vestido de lunares rojo\r\nTallas S/M/L', 'resources/images/producto/ropa/vestido3.jpg', 1, 1, 1),
(26, 'Vestido amarillo', 'Vestido amarillo\r\nTallas S/M/L', 'resources/images/producto/ropa/vestido4.jpg', 1, 1, 1),
(27, 'Botines ', 'Botines en color rojo,verde,gris.\r\nTallas de 36-41', 'resources/images/producto/calzado/bota2.jpg', 1, 2, 4),
(28, 'Botines tacon', 'Botines grises con tacon\r\nTallas de 36-41', 'resources/images/producto/calzado/bota3.jpg', 1, 2, 4),
(29, 'Botines cordones', 'botines con cordones diferentes colores\r\nTallas de 36-41', 'resources/images/producto/calzado/bota4.jpg', 1, 3, 4),
(30, 'Botin flecos', 'Botin beige con flecos\r\nTallas de 36-41', 'resources/images/producto/calzado/bota5.jpg', 1, 4, 4),
(31, 'Bota de monte', 'Bota de monte para chico\r\nTallas de 39-46', 'resources/images/producto/calzado/botamonte1.jpg', 1, 5, 4),
(32, 'Bota de monte', 'Bota de monte para chico\r\nTallas de 39-46', 'resources/images/producto/calzado/botamonte2.jpg', 1, 6, 4),
(33, 'Bota de monte', 'Bota de monte para chico\r\nTallas de 39-46', 'resources/images/producto/calzado/botamonte3.jpg', 1, 6, 4),
(34, 'Bota de monte', 'Bota de monte\r\nTallas de 38-46', 'resources/images/producto/calzado/botamonte4.jpg', 1, 6, 4),
(35, 'Parisina granate', 'Parisina granate\r\nTallas de 36-39', 'resources/images/producto/calzado/parisina1.jpg', 1, 6, 4),
(36, 'Manoletina roja', 'Manoletina roja\r\nTallas de 36-39', 'resources/images/producto/calzado/parisina2.jpg', 1, 7, 4),
(37, 'Parisina Azul', 'Parisina azul\r\nTallas de 36-39', 'resources/images/producto/calzado/parisina3.jpg', 1, 8, 4),
(38, 'Parisina leopardo', 'Parisina leopardo\r\nTallas de 36-39', 'resources/images/producto/calzado/parisina4.jpg', 1, 9, 4),
(40, 'Sandalia marron', 'Sandalia marron\r\nTallas de 36-39', 'resources/images/producto/calzado/parisina5.jpg', 1, 9, 4),
(41, 'Playera azul', 'Playera azul para chica\r\nTallas de 36-40', 'resources/images/producto/calzado/playera1.jpg', 1, 2, 4),
(42, 'Zapatilla Nike', 'Zapatilla adidas para chica\r\nTallas de 36-40', 'resources/images/producto/calzado/playera2.jpg', 1, 6, 4),
(43, 'Zapatillas', 'Zapatillas blanca o azul\r\nTallas de 36-40', 'resources/images/producto/calzado/playera3.jpg', 1, 8, 4),
(44, 'Zapatillas negras', 'Zapatillas negras para chica\r\nTallas de 36-40', 'resources/images/producto/calzado/playera4.jpg', 1, 7, 4),
(45, 'Zapatillas running', 'Zapatillas de running para chica\r\nTallas de 36-40', 'resources/images/producto/calzado/playera5.jpg', 1, 4, 4),
(46, 'Zapatillas adidas', 'Zapatillas adidas\r\nTallas de 36-40', 'resources/images/producto/calzado/playera6.jpg', 1, 6, 4),
(47, 'Sandalias azules', 'Sandalias azules con piedritas\r\nTallas de 36-40', 'resources/images/producto/calzado/sandalias1.jpg', 1, 3, 4),
(48, 'Sandalias marrones', 'Sandalias marrones\r\nTallas de 36-40', 'resources/images/producto/calzado/sandalias2.jpg', 1, 2, 4),
(49, 'Sandalias con piedras', 'Sandalias con piedras\r\nTallas de 36-40', 'resources/images/producto/calzado/sandalias3.jpg', 1, 2, 4),
(50, 'Tacones corazon', 'Tacones negros con corazon\r\nTallas de 36-40', 'resources/images/producto/calzado/tacon1.jpg', 1, 3, 4),
(51, 'Zapatillas de casa', 'Zapatillas de casa\r\nTallas de 36-40', 'resources/images/producto/calzado/zapatillas1.jpg', 1, 4, 4),
(52, 'Zapatillas cuadros', 'Zapatillas de cuadros para chicos\r\nTallas de 39-46', 'resources/images/producto/calzado/zapatillas2.jpg', 1, 8, 4),
(53, 'Zapatillas de casa', 'Zapatillas de casa diferentes colores\r\nTallas de 36-40', 'resources/images/producto/calzado/zapatillas3.jpg', 1, 5, 4),
(54, 'Zapatillas "make my day"', 'Zapatillas de casa\r\nTallas de 36-40', 'resources/images/producto/calzado/zapatillas4.jpg', 1, 6, 4),
(55, 'Jumpers', NULL, 'resources/images/producto/chuches/bolsa1.jpg', 1, 6, 2),
(56, 'Papadeltas', '', 'resources/images/producto/chuches/bolsa2.jpg', 1, 4, 2),
(57, 'Gusanitos', NULL, 'resources/images/producto/chuches/bolsa3.jpg', 1, 8, 2),
(58, 'Apetinas', NULL, 'resources/images/producto/chuches/bolsa4.jpg', 1, 6, 2),
(59, 'Risketos', NULL, 'resources/images/producto/chuches/bolsa5.jpg', 1, 2, 2),
(60, 'Rufles Original', NULL, 'resources/images/producto/chuches/bolsa6.jpg', 1, 4, 2),
(61, 'Rufles York''eso', NULL, 'resources/images/producto/chuches/bolsa7.jpg', 1, 4, 2),
(62, 'Lay`s Al punto de Sal', NULL, 'resources/images/producto/chuches/bolsa8.jpg', 1, 3, 2),
(63, 'Chicles Trident', 'Feshmint/FreshHerbal', 'resources/images/producto/chuches/chicles.jpg', 1, 8, 2),
(64, 'Gominolas corazon', NULL, 'resources/images/producto/chuches/chuche1.jpg', 1, 6, 2),
(65, 'Bolsas de cumpleaños', NULL, 'resources/images/producto/chuches/chuche2.jpg', 1, 7, 2),
(66, 'Pirtuleta de sabores', NULL, 'resources/images/producto/chuches/chuche3.jpg', 1, 6, 2),
(67, 'Gominolas de sabores', NULL, 'resources/images/producto/chuches/chuche4.jpg', 1, 6, 2),
(69, 'Chupa Chups de sabores', NULL, 'resources/images/producto/chuches/chupachup.jpg', 1, 6, 2),
(70, 'Kinder Bueno', NULL, 'resources/images/producto/chuches/kinder.jpg', 1, 8, 2),
(71, 'Palomitas', NULL, 'resources/images/producto/chuches/palomitas.jpg', 1, 6, 2),
(72, 'Regalizes rojos', NULL, 'resources/images/producto/chuches/regaliz1.jpg', 1, 2, 2),
(73, 'Regalizes de sabores', NULL, 'resources/images/producto/chuches/regaliz2.jpg', 1, 3, 2),
(74, 'Regalizes rojos', NULL, 'resources/images/producto/chuches/regaliz3.jpg', 1, 1, 2),
(75, 'Rimel negro', 'Mascara de pestañas AVON\r\n', 'resources/images/producto/cosmetica/cosmetica1.jpg', 1, 2, 5),
(76, 'Colorete rosa', NULL, 'resources/images/producto/cosmetica/cosmetica2.jpg', 1, 2, 5),
(77, 'Lapiz de labios', 'Perfilador de labios diferentes colores', 'resources/images/producto/cosmetica/cosmetica3.jpg', 1, 3, 5),
(78, 'Espuma Garnier', 'Espuma para el pelo Fructis\r\nHIDRA RIZOS', 'resources/images/producto/cosmetica/cosmetica4.jpg', 1, 4, 5),
(79, 'Barra de labios', 'Pintalabios de diferentes colores', 'resources/images/producto/cosmetica/cosmetica5.jpg', 1, 4, 5),
(80, 'Colorete', 'Colorete en diferentes tonos', 'resources/images/producto/cosmetica/cosmetica6.jpg', 1, 5, 5),
(81, 'Colorete ', NULL, 'resources/images/producto/cosmetica/cosmetica7.jpg', 1, 6, 5),
(82, 'Rizador de pestañas', NULL, 'resources/images/producto/cosmetica/cosmetica8.jpg', 1, 7, 5),
(83, 'Pintauñas', 'Pintauñas de diferentes colores', 'resources/images/producto/cosmetica/cosmetica9.jpg', 1, 7, 5),
(84, 'Champú Loreal', NULL, 'resources/images/producto/cosmetica/cosmetica10.jpg', 1, 8, 5),
(85, 'Maquillaje en polvos', NULL, 'resources/images/producto/cosmetica/cosmetica11.jpg', 1, 9, 5),
(86, 'Desodorante REXONA', NULL, 'resources/images/producto/cosmetica/cosmetica12.jpg', 1, 2, 5),
(87, 'Gel de ducha', 'Gel de ducha en crema Dove', 'resources/images/producto/cosmetica/cosmetica13.jpg', 1, 1, 5),
(88, 'Espuma Giorgi', 'Espuma fijadora hidratante', 'resources/images/producto/cosmetica/cosmetica14.jpg', 1, 2, 5),
(89, 'Supper Liner', NULL, 'resources/images/producto/cosmetica/cosmetica15.jpg', 1, 3, 5),
(90, 'Champu Garnier', 'Champu garnier fructis', 'resources/images/producto/cosmetica/cosmetica16.jpg', 1, 4, 5),
(91, 'Lima de uñas', 'Lima de uñas en diferentes colores', 'resources/images/producto/cosmetica/cosmetica17.jpg', 1, 5, 5),
(92, 'Rimel', 'Mascara de pestañas Volum Express', 'resources/images/producto/cosmetica/cosmetica18.jpg', 1, 6, 5),
(93, 'Barra de labios', NULL, 'resources/images/producto/cosmetica/cosmetica19.jpg', 1, 7, 5),
(94, 'Lapiz de ojos', 'Lapiz de ojos de diferentes colores', 'resources/images/producto/cosmetica/cosmetica20.jpg', 1, 8, 5),
(95, 'Lapiz de ojos', NULL, 'resources/images/producto/cosmetica/cosmetica21.jpg', 1, 9, 5),
(96, 'Pintauñas', 'Pintauñas diferentes colores', 'resources/images/producto/cosmetica/cosmetica22.jpg', 1, 1, 5),
(97, 'Lapiz de labios', NULL, 'resources/images/producto/cosmetica/cosmetica23.jpg', 1, 6, 5),
(98, 'Maquillaje en polvo', NULL, 'resources/images/producto/cosmetica/cosmetica24.jpg', 1, 8, 5),
(99, 'Maquillaje en polvo', 'Sol Desliplus', 'resources/images/producto/cosmetica/cosmetica25.jpg', 1, 9, 5),
(100, 'Sombra de ojos', NULL, 'resources/images/producto/cosmetica/cosmetica26.jpg', 1, 6, 5),
(101, 'Rimel Leopardo', NULL, 'resources/images/producto/cosmetica/cosmetica27.jpg', 1, 8, 5),
(102, 'Sombra de ojos brillante', NULL, 'resources/images/producto/cosmetica/cosmetica28.jpg', 1, 7, 5),
(103, 'Balon Baloncesto', 'Euroleague basketball', 'resources/images/producto/deportes/balon1.jpg', 1, 6, 7),
(104, 'Balon de futbol', 'LFP', 'resources/images/producto/deportes/balon2.jpg', 1, 8, 7),
(105, 'Balon Futbol', 'VOIT', 'resources/images/producto/deportes/balon4.jpg', 1, 6, 7),
(106, 'Balon futbol', 'Nike', 'resources/images/producto/deportes/balon5.jpg', 1, 6, 7),
(107, 'Bicicleta', 'Lider', 'resources/images/producto/deportes/bici1.jpg', 1, 7, 7),
(108, 'Bicicleta', 'Color azul', 'resources/images/producto/deportes/bici2.jpg', 1, 1, 7),
(109, 'Bicicleta', NULL, 'resources/images/producto/deportes/bici3.jpg', 1, 3, 7),
(110, 'Bicicleta', 'Bicicleta de paseo con cesta', 'resources/images/producto/deportes/bici4.jpg', 1, 3, 7),
(111, 'Chandal azul', NULL, 'resources/images/producto/deportes/chandal1.jpg', 1, 3, 7),
(112, 'Chandal rosa', 'Mujer', 'resources/images/producto/deportes/chandal2.jpg', 1, 4, 7),
(113, 'Chandal azul', 'Hombre', 'resources/images/producto/deportes/chandal3.jpg', 1, 5, 7),
(115, 'Chandal azul', 'Hombre', 'resources/images/producto/deportes/chandal4.jpg', 1, 2, 7),
(116, 'Chandal', 'Hombre', 'resources/images/producto/deportes/chandal5.jpg', 1, 6, 7),
(118, 'Chandal negro/naranja', 'Hombre', 'resources/images/producto/deportes/chandal6.jpg', 1, 7, 7),
(119, 'Chandal negro/rosa', 'Mujer', 'resources/images/producto/deportes/chandal7.jpg', 1, 8, 7),
(120, 'Patines', 'Patines rojo/negro\r\nTallas 37-40', 'resources/images/producto/deportes/patines1.jpg', 1, 1, 7),
(121, 'Patines', 'Patines cuatro ruedas de colores', 'resources/images/producto/deportes/patines2.jpg', 1, 2, 7),
(122, 'Patines', 'Patines azul/negro\r\nTallas 38-40', 'resources/images/producto/deportes/patines3.jpg', 1, 3, 7),
(123, 'Patines', 'Patines negros\r\nTallas 38-41', 'resources/images/producto/deportes/patines4.jpg', 1, 4, 7),
(124, 'Esquis', 'SKILOGIK', 'resources/images/producto/deportes/skies1.jpg', 1, 5, 7),
(125, 'Esquis', NULL, 'resources/images/producto/deportes/skies2.jpg', 1, 5, 7),
(126, 'Esquis', NULL, 'resources/images/producto/deportes/skies3.jpg', 1, 6, 7),
(127, 'Esquis', NULL, 'resources/images/producto/deportes/skies4.jpg', 1, 7, 7),
(128, 'Regalizes de sabores', NULL, 'resources/images/producto/chuches/chuche5.jpg', 1, 4, 2),
(220, 'Chandal ', 'Mujer', 'resources/images/producto/deportes/chandal8.jpg', 1, 9, 7),
(221, 'Collar', 'Collar dos colores azules', 'resources/images/producto/joyeria/joya1.jpg', 1, 8, 6),
(222, 'Anillo', '', 'resources/images/producto/joyeria/joya2.jpg', 1, 7, 6),
(223, 'Anillo', '', 'resources/images/producto/joyeria/joya3.jpg', 1, 6, 6),
(224, 'Brazalete ', '', 'resources/images/producto/joyeria/joya4.jpg', 1, 3, 6),
(225, 'Brazatele plateado', '', 'resources/images/producto/joyeria/joya5.jpg', 1, 7, 6),
(226, 'Reloj', '', 'resources/images/producto/joyeria/joya6.jpg', 1, 1, 6),
(227, 'Pulsera', '', 'resources/images/producto/joyeria/joya7.jpg', 1, 4, 6),
(228, 'Collar azul de bolitas', '', 'resources/images/producto/joyeria/joya8.jpg', 1, 2, 6),
(229, 'Pulsera', '', 'resources/images/producto/joyeria/joya9.jpg', 1, 3, 6),
(230, 'Anillo', 'Dos anillos con diamantes', 'resources/images/producto/joyeria/joya10.jpg', 1, 4, 6),
(231, 'Collar', 'Collar negro y granate', 'resources/images/producto/joyeria/joya11.jpg', 1, 6, 6),
(232, 'Brazalete plateado', NULL, 'resources/images/producto/joyeria/joya12.jpg', 1, 8, 6),
(233, 'Reloj', 'Reloj correa negra', 'resources/images/producto/joyeria/joya13.jpg', 1, 9, 6),
(234, 'Pendientes azul turquesa', NULL, 'resources/images/producto/joyeria/joya14.jpg', 1, 7, 6),
(235, 'Pendientes pluma', NULL, 'resources/images/producto/joyeria/joya15.jpg', 1, 6, 6),
(236, 'Reloj', NULL, 'resources/images/producto/joyeria/joya16.jpg', 1, 4, 6),
(237, 'Pendientes', NULL, 'resources/images/producto/joyeria/joya17.jpg', 1, 9, 6),
(238, 'Pendientes verdes', NULL, 'resources/images/producto/joyeria/joya18.jpg', 1, 2, 6),
(239, 'Pendientes cristales', NULL, 'resources/images/producto/joyeria/joya19.jpg', 1, 4, 6),
(240, 'Reloj rosa', NULL, 'resources/images/producto/joyeria/joya20.jpg', 1, 6, 6),
(241, 'Pulsera', NULL, 'resources/images/producto/joyeria/joya21.jpg', 1, 2, 6),
(242, 'Pulseras con accesorio', NULL, 'resources/images/producto/joyeria/joya22.jpg', 1, 3, 6),
(243, 'Pulsera roja con accesorios', NULL, 'resources/images/producto/joyeria/joya23.jpg', 1, 9, 6),
(244, 'Anillo', NULL, 'resources/images/producto/joyeria/joya24.jpg', 1, 6, 6),
(245, 'Collar blanco', NULL, 'resources/images/producto/joyeria/joya26.jpg', 1, 4, 6),
(246, 'Maquillaje', 'Set de maquillaje para niña', 'resources/images/producto/juguetes/juguete1.jpg', 1, 4, 3),
(247, 'Nintento 64 ', 'Nintendo con juego Mario Kart', 'resources/images/producto/juguetes/juguete2.jpg', 1, 6, 3),
(248, 'Juegos', NULL, 'resources/images/producto/juguetes/juguete3.jpg', 1, 2, 3),
(249, 'Tortuga con musica', 'Aprende con la tortuga', 'resources/images/producto/juguetes/juguete4.jpg', 1, 7, 3),
(250, 'Barbie marposa', NULL, 'resources/images/producto/juguetes/juguete5.jpg', 1, 3, 3),
(251, 'Furby', 'Furby morado', 'resources/images/producto/juguetes/juguete6.jpg', 1, 1, 3),
(252, 'Muñeco Mario Bross', NULL, 'resources/images/producto/juguetes/juguete7.jpg', 1, 2, 3),
(253, 'Pelota+Tractor', NULL, 'resources/images/producto/juguetes/juguete8.jpg', 1, 4, 3),
(254, 'Tocador', 'Tocador con accesorios para belleza', 'resources/images/producto/juguetes/juguete9.jpg', 1, 5, 3),
(255, 'Moto', 'Moto roja con casco', 'resources/images/producto/juguetes/juguete10.jpg', 1, 5, 3),
(256, 'Mesa para cocinar', 'Mesa para cocinar con accesorios de cocina', 'resources/images/producto/juguetes/juguete11.jpg', 1, 8, 3),
(257, 'Cubos con bolas', NULL, 'resources/images/producto/juguetes/juguete13.jpg', 1, 6, 3),
(258, 'Muñeco Mickey Mouse', NULL, 'resources/images/producto/juguetes/juguete14.jpg', 1, 6, 3),
(259, 'Furby', 'Furby Rosa', 'resources/images/producto/juguetes/juguete15.jpg', 1, 2, 3),
(260, 'Triciclo Jirafa', NULL, 'resources/images/producto/juguetes/juguete16.jpg', 1, 5, 3),
(261, 'Mr Patata', NULL, 'resources/images/producto/juguetes/juguete17.jpg', 1, 3, 3),
(262, 'Osito de peluche', 'Osito de peluche con lazito', 'resources/images/producto/juguetes/juguete18.jpg', 1, 1, 3),
(263, 'Caja registradora', 'caja registradora en color rosa con billetes y monedas', 'resources/images/producto/juguetes/juguete19.jpg', 1, 2, 3),
(264, 'Set de juguetes', NULL, 'resources/images/producto/juguetes/juguete20.jpg', 1, 4, 3),
(265, 'Bratz', 'Pack de 4 Bratz', 'resources/images/producto/juguetes/juguete21.jpg', 1, 5, 3),
(266, 'Muñecos lego', 'Muñecos lego de Harry Potter', 'resources/images/producto/juguetes/juguete22.jpg', 1, 6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

CREATE TABLE IF NOT EXISTS `tienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ruta_imagen` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `horario_abrir` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `horario_cerrar` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id`, `nombre`, `descripcion`, `ruta_imagen`, `tipo`, `estado`, `horario_abrir`, `horario_cerrar`) VALUES
(1, 'NEW VINTAGE', 'Vete a la última moda, aquí encontrarás todo para ir de lo mas chick!', 'resources/images/tienda/tiendaropa.png', 'ropa', 1, '10:00', '20:00'),
(2, 'GOMINOLAS', 'Ricas chuches', 'resources/images/tienda/tiendachuches.png', 'chuches', 1, '10:00', '20:00'),
(3, 'MUNDOLANDIA', 'Adéntrate en un mundo de mágia y emociones con todos tus juguetes favoritos', 'resources/images/tienda/tiendajuguetes.png', 'juguetes', 1, '10:00', '20:00'),
(4, 'NO ME PISES', 'No me pises que llevo chanclas', 'resources/images/tienda/tiendacalzado.png', 'calzado', 1, '10:00', '20:00'),
(5, 'AMORA', 'Tienda de cosmética, todos tus mejores artículos de belleza', 'resources/images/tienda/tiendacosmetica.png', 'cosmetica', 1, '10:00', '20:00'),
(6, 'EL RUBI', 'Brillarás con glamour', 'resources/images/tienda/tiendajoyeria.png', 'joyas', 1, '10:00', '20:00'),
(7, 'DEPORTES', 'Just do it', 'resources/images/tienda/tiendadeporte.png', 'deporte', 1, '10:00', '20:00');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
