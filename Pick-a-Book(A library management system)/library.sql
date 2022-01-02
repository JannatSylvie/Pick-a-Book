-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2017 at 08:09 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_info`
--

CREATE TABLE `admin_info` (
  `AdminId` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_info`
--

INSERT INTO `admin_info` (`AdminId`, `Password`) VALUES
('123456', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `issued_books`
--

CREATE TABLE `issued_books` (
  `StudentId` varchar(10) NOT NULL,
  `BookId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issued_books`
--

INSERT INTO `issued_books` (`StudentId`, `BookId`) VALUES
('12345', '1000'),
('78932', '1002');

-- --------------------------------------------------------

--
-- Table structure for table `list_of_books`
--

CREATE TABLE `list_of_books` (
  `BookName` varchar(60) NOT NULL,
  `AuthorName` varchar(60) NOT NULL,
  `BookId` int(10) NOT NULL,
  `NumberOfCopies` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `list_of_books`
--

INSERT INTO `list_of_books` (`BookName`, `AuthorName`, `BookId`, `NumberOfCopies`) VALUES
('Let Us C', 'Yashavant Kanetkar', 1000, 5),
('Management Accounting', 'Kaplan', 1002, 1),
('Teach Yourself C', 'Herbert Schildt', 1001, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `FullName` varchar(25) NOT NULL,
  `StudentId` varchar(10) NOT NULL,
  `Password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`FullName`, `StudentId`, `Password`) VALUES
('Azmina Farzeen', '78932', '2345'),
('Hasib Ahmed', '1612694660', '1234'),
('Hasibul Islam Sahir', '23456', '6543'),
('Jannatul Ferdousi Sylvie', '12345', '1234'),
('Sadia Tanzin', '14263161', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_info`
--
ALTER TABLE `admin_info`
  ADD UNIQUE KEY `unique` (`AdminId`);

--
-- Indexes for table `issued_books`
--
ALTER TABLE `issued_books`
  ADD PRIMARY KEY (`StudentId`),
  ADD UNIQUE KEY `unique` (`BookId`);

--
-- Indexes for table `list_of_books`
--
ALTER TABLE `list_of_books`
  ADD PRIMARY KEY (`BookName`),
  ADD UNIQUE KEY `unique` (`BookId`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`FullName`),
  ADD UNIQUE KEY `unique` (`StudentId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
