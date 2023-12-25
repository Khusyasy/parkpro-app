-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2023 at 03:29 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `park-pro-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`, `nama`) VALUES
(1, 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `lahan_parkir`
--

CREATE TABLE `lahan_parkir` (
  `id` int(11) NOT NULL,
  `lantai` varchar(50) NOT NULL,
  `lokasi` varchar(50) NOT NULL,
  `nomor` int(11) NOT NULL,
  `tersedia` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lahan_parkir`
--

INSERT INTO `lahan_parkir` (`id`, `lantai`, `lokasi`, `nomor`, `tersedia`) VALUES
(1, 'B', 'A1', 1, 1),
(2, 'B', 'A1', 2, 1),
(3, 'B', 'A1', 3, 1),
(4, 'B', 'A1', 4, 1),
(5, 'B', 'A2', 1, 1),
(6, 'B', 'A2', 2, 1),
(7, 'B', 'A2', 3, 1),
(8, 'B', 'A2', 4, 1),
(9, 'B', 'B1', 1, 1),
(10, 'B', 'B1', 2, 1),
(11, 'B', 'B1', 3, 1),
(12, 'B', 'B1', 4, 1),
(13, 'B', 'B2', 1, 1),
(14, 'B', 'B2', 2, 1),
(15, 'B', 'B2', 3, 1),
(16, 'B', 'B2', 4, 1),
(17, '1', 'A1', 1, 1),
(18, '1', 'A1', 2, 1),
(19, '1', 'A1', 3, 1),
(20, '1', 'A1', 4, 1),
(21, '1', 'A2', 1, 1),
(22, '1', 'A2', 2, 1),
(23, '1', 'A2', 3, 1),
(24, '1', 'A2', 4, 1),
(25, '1', 'B1', 1, 1),
(26, '1', 'B1', 2, 1),
(27, '1', 'B1', 3, 1),
(28, '1', 'B1', 4, 1),
(29, '1', 'B2', 1, 1),
(30, '1', 'B2', 2, 1),
(31, '1', 'B2', 3, 1),
(32, '1', 'B2', 4, 1),
(33, '2', 'A1', 1, 1),
(34, '2', 'A1', 2, 1),
(35, '2', 'A1', 3, 1),
(36, '2', 'A1', 4, 1),
(37, '2', 'A2', 1, 1),
(38, '2', 'A2', 2, 1),
(39, '2', 'A2', 3, 1),
(40, '2', 'A2', 4, 1),
(41, '2', 'B1', 1, 1),
(42, '2', 'B1', 2, 1),
(43, '2', 'B1', 3, 1),
(44, '2', 'B1', 4, 1),
(45, '2', 'B2', 1, 1),
(46, '2', 'B2', 2, 1),
(47, '2', 'B2', 3, 1),
(48, '2', 'B2', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(11) NOT NULL,
  `id_tiket` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `total_bayar` int(11) NOT NULL,
  `id_tarif` int(11) NOT NULL,
  `metode` varchar(50) NOT NULL,
  `waktu_bayar` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL,
  `no_telepon` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `gender` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis_kendaraan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `no_telepon`, `password`, `gender`, `date_of_birth`, `nama`, `jenis_kendaraan`) VALUES
(1, '+628123456789', '$2a$10$v/pNBGD1utxy0YOSeniv8eYhasrW3HIzJn/kQPce9eCfb57Eydx5u', 'male', '2003-05-11', 'Khusyasy', 'mobil');

-- --------------------------------------------------------

--
-- Table structure for table `tarif`
--

CREATE TABLE `tarif` (
  `id` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `jenis_kendaraan` varchar(50) NOT NULL,
  `id_admin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tarif`
--

INSERT INTO `tarif` (`id`, `harga`, `jenis_kendaraan`, `id_admin`) VALUES
(1, 3000, 'mobil', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `id` int(11) NOT NULL,
  `id_pengguna` int(11) NOT NULL,
  `id_lahan_parkir` int(11) NOT NULL,
  `waktu_masuk` datetime NOT NULL,
  `waktu_keluar` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `lahan_parkir`
--
ALTER TABLE `lahan_parkir`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pembayaran_tiket` (`id_tiket`),
  ADD KEY `fk_pembayaran_pengguna` (`id_pengguna`),
  ADD KEY `fk_pembayaran_tarif` (`id_tarif`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `no_telepon` (`no_telepon`);

--
-- Indexes for table `tarif`
--
ALTER TABLE `tarif`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tarif_admin` (`id_admin`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tiket_pengguna` (`id_pengguna`),
  ADD KEY `fk_tiket_lahan_parkir` (`id_lahan_parkir`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lahan_parkir`
--
ALTER TABLE `lahan_parkir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tarif`
--
ALTER TABLE `tarif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tiket`
--
ALTER TABLE `tiket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `fk_pembayaran_pengguna` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id`),
  ADD CONSTRAINT `fk_pembayaran_tarif` FOREIGN KEY (`id_tarif`) REFERENCES `tarif` (`id`),
  ADD CONSTRAINT `fk_pembayaran_tiket` FOREIGN KEY (`id_tiket`) REFERENCES `tiket` (`id`);

--
-- Constraints for table `tarif`
--
ALTER TABLE `tarif`
  ADD CONSTRAINT `fk_tarif_admin` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id`);

--
-- Constraints for table `tiket`
--
ALTER TABLE `tiket`
  ADD CONSTRAINT `fk_tiket_lahan_parkir` FOREIGN KEY (`id_lahan_parkir`) REFERENCES `lahan_parkir` (`id`),
  ADD CONSTRAINT `fk_tiket_pengguna` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
