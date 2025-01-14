-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 14 Jan 2025 pada 12.20
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemetaan_kehutanan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `berita`
--

CREATE TABLE `berita` (
  `idberita` int NOT NULL,
  `judul` varchar(255) NOT NULL,
  `isi` text NOT NULL,
  `Kdgambar` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `tgl` text NOT NULL,
  `jam` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `berita`
--

INSERT INTO `berita` (`idberita`, `judul`, `isi`, `Kdgambar`, `tgl`, `jam`) VALUES
(1, '2', '3', '4', '5', '6'),
(2, '1', '1', '1', '1', '1'),
(7, '8', '9', '0', '1', '2');

-- --------------------------------------------------------

--
-- Struktur dari tabel `contact`
--

CREATE TABLE `contact` (
  `noktp` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `email` varchar(100) NOT NULL,
  `keluhan_saran` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data untuk tabel `contact`
--

INSERT INTO `contact` (`noktp`, `nama`, `alamat`, `email`, `keluhan_saran`) VALUES
('1', '1', '1', '1', '1'),
('12', 'zaki kelaz', 'basirih', 'takisung', 'ada'),
('123', 'banjarmasin', 'rifki@gmail.com', 'tidak ada', 'rifki'),
('12345678', 'jalan pangeran', 'rifki@gmail.com', 'tidak ada', 'Muhammad Rifki Hatasa'),
('29981', 'Sungai Andai', 'mirza@gmail.com', 'anjay', 'Mirza'),
('6', '7', '8', '7', '7');

-- --------------------------------------------------------

--
-- Struktur dari tabel `geometry_columns`
--

CREATE TABLE `geometry_columns` (
  `F_tabel_catalog` varchar(100) DEFAULT NULL,
  `F_tabel_name` varchar(100) NOT NULL,
  `F_tabel_schema` varchar(100) DEFAULT NULL,
  `F_geometry_column` varchar(100) NOT NULL,
  `Coord_dimension` int DEFAULT NULL,
  `srid` int DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `home`
--

CREATE TABLE `home` (
  `Idhome` int NOT NULL,
  `judul` varchar(255) NOT NULL,
  `isi` text NOT NULL,
  `Kdgambar` text,
  `tgl` date NOT NULL,
  `jam` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hutan_lindung`
--

CREATE TABLE `hutan_lindung` (
  `OGR_FID` int NOT NULL,
  `shape` geometry NOT NULL,
  `id` int NOT NULL,
  `Jenis_hutan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jalan`
--

CREATE TABLE `jalan` (
  `OGR_FID` int NOT NULL,
  `shape` geometry NOT NULL,
  `id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kota`
--

CREATE TABLE `kota` (
  `OGR_FID` int NOT NULL,
  `shape` geometry NOT NULL,
  `id` int NOT NULL,
  `kabupaten` varchar(100) NOT NULL,
  `kota` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `lampung`
--

CREATE TABLE `lampung` (
  `OGR_FID` int NOT NULL,
  `shape` geometry NOT NULL,
  `kabupaten` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `idadmin` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `lokasi`
--

CREATE TABLE `lokasi` (
  `OGR_FID` int NOT NULL,
  `shape` geometry NOT NULL,
  `id` int NOT NULL,
  `Nama_hutan` varchar(255) NOT NULL,
  `alamat` text NOT NULL,
  `kecamatan` varchar(100) NOT NULL,
  `kabupaten` varchar(100) NOT NULL,
  `foto` text,
  `keterangan` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `berita`
--
ALTER TABLE `berita`
  ADD PRIMARY KEY (`idberita`);

--
-- Indeks untuk tabel `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`noktp`);

--
-- Indeks untuk tabel `geometry_columns`
--
ALTER TABLE `geometry_columns`
  ADD PRIMARY KEY (`F_tabel_name`,`F_geometry_column`);

--
-- Indeks untuk tabel `home`
--
ALTER TABLE `home`
  ADD PRIMARY KEY (`Idhome`);

--
-- Indeks untuk tabel `hutan_lindung`
--
ALTER TABLE `hutan_lindung`
  ADD PRIMARY KEY (`OGR_FID`);

--
-- Indeks untuk tabel `jalan`
--
ALTER TABLE `jalan`
  ADD PRIMARY KEY (`OGR_FID`);

--
-- Indeks untuk tabel `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`OGR_FID`);

--
-- Indeks untuk tabel `lampung`
--
ALTER TABLE `lampung`
  ADD PRIMARY KEY (`OGR_FID`);

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idadmin`);

--
-- Indeks untuk tabel `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`OGR_FID`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `berita`
--
ALTER TABLE `berita`
  MODIFY `idberita` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `home`
--
ALTER TABLE `home`
  MODIFY `Idhome` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `hutan_lindung`
--
ALTER TABLE `hutan_lindung`
  MODIFY `OGR_FID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `jalan`
--
ALTER TABLE `jalan`
  MODIFY `OGR_FID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `kota`
--
ALTER TABLE `kota`
  MODIFY `OGR_FID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `lampung`
--
ALTER TABLE `lampung`
  MODIFY `OGR_FID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `idadmin` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `lokasi`
--
ALTER TABLE `lokasi`
  MODIFY `OGR_FID` int NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
