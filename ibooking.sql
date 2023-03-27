-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-03-2023 a las 08:08:33
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ibooking`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `comment_text` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `rating` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `comment`
--

INSERT INTO `comment` (`comment_id`, `user_id`, `hotel_id`, `comment_text`, `rating`) VALUES
(1, 1, 1, 'Great hotel, amazing service!', 4.5),
(2, 2, 2, 'The location was perfect, but the room was a bit small.', 3),
(3, 3, 3, 'The staff was very helpful and friendly.', 4),
(4, 4, 4, 'I loved my stay here, highly recommend!', 4.8),
(5, 5, 1, 'The location was great and the staff was very friendly.', 3.5),
(6, 2, 5, 'Beautiful hotel, but the room was a bit too small for my liking.', 4),
(7, 3, 2, 'The hotel was clean and comfortable, but the breakfast was not very good.', 3.2),
(8, 1, 3, 'Lovely hotel with great views of the city.', 4.5),
(9, 5, 4, 'The room was spacious and well-appointed, but the wifi was slow.', 3.7),
(10, 3, 1, 'The hotel was amazing, but the price was a bit steep.', 4.2),
(11, 4, 3, 'Great hotel with friendly staff and comfortable rooms.', 4),
(12, 1, 5, 'I had a great time at this hotel, would definitely stay again!', 4.5),
(13, 2, 4, 'The hotel was lovely and well-located, but the room was a bit noisy.', 3.8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hotel`
--

CREATE TABLE `hotel` (
  `hotel_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `hotel`
--

INSERT INTO `hotel` (`hotel_id`, `name`, `description`, `location_id`, `rating`) VALUES
(1, 'Hotel Madrid', 'A luxurious hotel in the heart of Madrid', 1, 4),
(2, 'Hotel Barcelona', 'A modern hotel located in Barcelona', 2, 4),
(3, 'Hotel Paris', 'A charming hotel in the historic district of Paris', 3, 4),
(4, 'Hotel Berlin', 'A stylish hotel in the trendy Mitte neighborhood of Berlin', 4, 4),
(5, 'Hotel Rome', 'A classic hotel in the center of Rome', 4, 4),
(6, 'Grand Hotel', 'A classic hotel in the heart of London', 6, 4),
(7, 'Hotel New York', 'A modern hotel located in Times Square', 7, 4),
(8, 'Hotel Tokyo', 'A luxurious hotel in the heart of Tokyo', 8, 4),
(9, 'Hotel Sydney', 'A charming hotel in the historic district of Sydney', 9, 4),
(10, 'Hotel Rio de Janeiro', 'A stylish hotel in the Copacabana beach', 10, 4),
(11, 'Hotel Dubai', 'A classic hotel in the center of Dubai', 11, 4),
(12, 'Hotel Moscow', 'A modern hotel located in the center of Moscow', 12, 4),
(13, 'Hotel Amsterdam', 'A luxurious hotel in the canal district of Amsterdam', 13, 4),
(14, 'Hotel Toronto', 'A charming hotel in the heart of Toronto', 14, 4),
(15, 'Hotel Bangkok', 'A stylish hotel in the center of Bangkok', 15, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `city` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `location`
--

INSERT INTO `location` (`location_id`, `city`, `country`) VALUES
(1, 'Madrid', 'Spain'),
(2, 'Barcelona', 'Spain'),
(3, 'Paris', 'France'),
(4, 'Berlin', 'Germany'),
(5, 'Rome', 'Italy'),
(6, 'New York', 'United States'),
(7, 'Tokyo', 'Japan'),
(8, 'London', 'United Kingdom'),
(9, 'Sydney', 'Australia'),
(10, 'Amsterdam', 'Netherlands'),
(11, 'Hong Kong', 'China'),
(12, 'Dubai', 'United Arab Emirates'),
(13, 'Rio de Janeiro', 'Brazil'),
(14, 'Cape Town', 'South Africa'),
(15, 'Vancouver', 'Canada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `user_id`, `hotel_id`, `room_id`, `check_in_date`, `check_out_date`) VALUES
(1, 1, 1, 1, '2023-04-10', '2023-04-15'),
(2, 2, 2, 3, '2023-05-20', '2023-05-23'),
(3, 3, 3, 5, '2023-06-15', '2023-06-17'),
(4, 4, 4, 4, '2023-07-12', '2023-07-18'),
(5, 5, 5, 5, '2023-08-22', '2023-08-25'),
(6, 1, 3, 5, '2023-09-05', '2023-09-10'),
(7, 2, 4, 6, '2023-10-20', '2023-10-25'),
(8, 3, 2, 3, '2023-11-10', '2023-11-15'),
(9, 4, 1, 2, '2023-12-05', '2023-12-10'),
(10, 5, 3, 6, '2024-01-15', '2024-01-20'),
(11, 1, 2, 4, '2024-02-05', '2024-02-10'),
(12, 2, 5, 5, '2024-03-10', '2024-03-15'),
(13, 3, 1, 1, '2024-04-15', '2024-04-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `room`
--

CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `hotel_id` int(11) DEFAULT NULL,
  `room_type` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `price_per_night` float DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `room`
--

INSERT INTO `room` (`room_id`, `hotel_id`, `room_type`, `price_per_night`, `availability`) VALUES
(1, 1, 'Deluxe King', 300, 1),
(2, 1, 'Double Queen', 250, 1),
(3, 2, 'Standard Double', 200, 1),
(4, 2, 'Suite', 400, 0),
(5, 3, 'Twin Room', 180, 1),
(6, 3, 'King Room', 220, 0),
(7, 1, 'Double Queen', 250, 1),
(8, 1, 'Executive Suite', 500, 0),
(9, 1, 'Twin Room', 220, 1),
(10, 2, 'Deluxe King', 350, 1),
(11, 2, 'Standard Double', 200, 1),
(12, 2, 'Junior Suite', 450, 0),
(13, 3, 'Single Room', 150, 1),
(14, 3, 'Superior Twin', 200, 1),
(15, 4, 'Superior King', 400, 0),
(16, 5, 'Classic Double', 220, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `lastName` varchar(75) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`user_id`, `name`, `lastName`, `email`, `password`) VALUES
(1, 'John', 'Smith', 'johnsmith@gmail.com', 'password123'),
(2, 'Jane', 'Doe', 'janedoe@yahoo.com', 'qwerty123'),
(3, 'Bob', 'Johnson', 'bob.johnson@hotmail.com', 'pass123'),
(4, 'Alice', 'Williams', 'alice.williams@gmail.com', 'password123'),
(5, 'Charlie', 'Brown', 'charlie.brown@yahoo.com', 'password123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Indices de la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`hotel_id`),
  ADD KEY `location_id` (`location_id`);

--
-- Indices de la tabla `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Indices de la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `hotel_id` (`hotel_id`),
  ADD KEY `room_id` (`room_id`);

--
-- Indices de la tabla `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`);

--
-- Filtros para la tabla `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Filtros para la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`);

--
-- Filtros para la tabla `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
