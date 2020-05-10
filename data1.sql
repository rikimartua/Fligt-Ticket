-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2020 at 09:19 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data1`
--

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `No_Pesawat` varchar(30) NOT NULL,
  `Nama_Maskapai` varchar(30) NOT NULL,
  `Kelas` varchar(30) NOT NULL,
  `Berangkat` varchar(30) NOT NULL,
  `Tiba` varchar(30) NOT NULL,
  `Harga` int(30) NOT NULL,
  `Tujuan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`No_Pesawat`, `Nama_Maskapai`, `Kelas`, `Berangkat`, `Tiba`, `Harga`, `Tujuan`) VALUES
('AC 123', 'Lion Air', 'Economi', '12.00', '15.30', 1750000, 'Jambi');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `Nama` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Nama`, `Email`, `Username`, `Password`) VALUES
('RIki', 'riki@gmail.com', 'riki', '123qwe');

-- --------------------------------------------------------

--
-- Table structure for table `perjalanan`
--

CREATE TABLE `perjalanan` (
  `asal` varchar(30) NOT NULL,
  `tujuan` varchar(30) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `tanggal` text NOT NULL,
  `Harga` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perjalanan`
--

INSERT INTO `perjalanan` (`asal`, `tujuan`, `kelas`, `tanggal`, `Harga`) VALUES
('Yogyakarta', 'Jambi', 'Economic', '10-03-2020', '1750000');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `Nama` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Telepon` varchar(30) NOT NULL,
  `ID` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`Nama`, `Email`, `Telepon`, `ID`) VALUES
('riki martua', '1212121212', 'aaaaaaaaaaaaa', '323232'),
('riki martua', '123123423', 'qqqqqqqq', '123'),
('qqqq wwwww', 'aaaaaaaa', 'eeeee', 'sssssssss'),
('Riki Martua', '12', 'rii', '21'),
('riki riki', '12312321', 'dadad', '3213213'),
('RIki Martua', '1231232', 'Riki@gmail.com', '213213213'),
('Riki Martua', '123123', 'riki@gmail,com', '321321'),
('rik rr', '123232432', '@gmail.com', '43242342'),
('riki ro', '132132', 're', '32321'),
('dfs dfs', 'fsd', 'fsd', 'sdf');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
