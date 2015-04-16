-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2015 at 06:03 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `twitter`
--

-- --------------------------------------------------------

--
-- Table structure for table `tweets`
--

CREATE TABLE IF NOT EXISTS `tweets` (
`user_id` int(11) NOT NULL,
  `users` varchar(15) DEFAULT NULL,
  `tweets` varchar(141) DEFAULT NULL,
  `timeOfTweet` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tweets`
--

INSERT INTO `tweets` (`user_id`, `users`, `tweets`, `timeOfTweet`) VALUES
(1, '@andre', '@andre: ddfd', 50058),
(2, '@bob3Builder', '@bob3Builder: ssfdss', 50102),
(3, '@money', '@money: fdfdss', 50107),
(4, '@andre', '@andre: boiiiii', 54352),
(5, '@andre', '@andre: Billy is cool', 54458),
(6, '@andre', '@andre: Andre is hella goat', 54517),
(7, '@andre', '@andre: addskakda;djfajfja;', 54551),
(8, '@andre', '@andre: dsfsf', 103139),
(9, '@andre', '@andre: Bang', 103537),
(10, '@andre', '@andre: dsagsgsa', 103945),
(11, '@andre', '@andre: afdafda', 104050),
(12, '@andre', '@andre: fdada', 104103),
(13, '@andre', '@andre: gfsd', 104158),
(14, '@andre', '@andre: andre', 110218),
(15, '@andre', '@andre: afa', 110505),
(16, '@andre', '@andre: af', 110631),
(17, '@andre', '@andre: fdaf', 111024),
(18, '@andre', '@andre: sagd', 111204),
(19, '@andre', '@andre: afdsgd', 111315),
(20, '@andre', '@andre: sfs', 113013),
(21, '@andre', '@andre: fadd', 115755),
(22, '@andre', '@andre: fsfs', 115953),
(23, '@bob3Builder', '@bob3Builder: sfssdf', 115956),
(24, '@money', '@money: sfsfsd', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tweets`
--
ALTER TABLE `tweets`
 ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tweets`
--
ALTER TABLE `tweets`
MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
