-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jun 10, 2021 at 01:44 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restapi`
--

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--
-- Creation: Jun 07, 2021 at 09:43 AM
--

DROP TABLE IF EXISTS `userdata`;
CREATE TABLE IF NOT EXISTS `userdata` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sport` varchar(15) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `getID` varchar(7) DEFAULT NULL,
  `record_date` datetime DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`userId`, `name`, `sport`, `age`, `getID`, `record_date`, `created_at`) VALUES
(1, 'ZACK IRON  ', 'MUSICIAN ', 28, '101', NULL, '2021-06-03 07:35:47'),
(2, 'Yenusus', 'baller', 29, '102', NULL, '2021-06-03 10:31:56'),
(3, 'George', 'skater', 9, '103', NULL, '2021-06-07 07:09:21'),
(4, 'Okello', 'student', 15, '104', NULL, '2021-06-07 12:09:01'),
(5, 'Simon', 'dev', 20, '105', NULL, '2021-06-07 12:10:18'),
(6, 'Jack', 'runner', 22, '106', NULL, '2021-06-08 12:27:21'),
(7, 'Sam', 'retired', 45, '107', NULL, '2021-06-08 12:33:04'),
(8, 'Marcaroni', 'no sport', 70, '108', NULL, '2021-06-08 12:40:21'),
(9, 'Kunle', 'rugby', 12, '109', NULL, '2021-06-08 12:46:34'),
(10, 'Yawa', 'Tennis', 23, '110', NULL, '2021-06-08 12:49:03'),
(11, 'Nonso', 'Cricket', 25, '111', NULL, '2021-06-08 12:53:16'),
(12, 'Adeise', 'retired', 87, '112', NULL, '2021-06-08 13:07:35'),
(13, 'Linda', 'soccer', 29, '113', NULL, '2021-06-08 13:14:01'),
(14, 'Mary', 'cricket', 31, '114', NULL, '2021-06-08 13:22:14'),
(15, 'Susan', 'dancer', 12, '115', NULL, '2021-06-09 08:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
