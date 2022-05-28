-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 21, 2021 lúc 01:14 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `khanhhii`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `leveltower`
--

CREATE TABLE `leveltower` (
  `level` int(11) NOT NULL,
  `dodai` int(11) NOT NULL,
  `sobuoc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `leveltower`
--

INSERT INTO `leveltower` (`level`, `dodai`, `sobuoc`) VALUES
(1, 90, 25),
(2, 110, 40),
(3, 130, 75),
(4, 150, 140);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `towerofhanoi`
--

CREATE TABLE `towerofhanoi` (
  `Id` int(11) NOT NULL,
  `ten` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `level` int(11) NOT NULL,
  `diem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `towerofhanoi`
--

INSERT INTO `towerofhanoi` (`Id`, `ten`, `level`, `diem`) VALUES
(1, 'Khánh Hà', 1, 26),
(59, 'Nguyễn Thị Khánh', 3, 70);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `leveltower`
--
ALTER TABLE `leveltower`
  ADD PRIMARY KEY (`level`);

--
-- Chỉ mục cho bảng `towerofhanoi`
--
ALTER TABLE `towerofhanoi`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `level` (`level`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `towerofhanoi`
--
ALTER TABLE `towerofhanoi`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `towerofhanoi`
--
ALTER TABLE `towerofhanoi`
  ADD CONSTRAINT `towerofhanoi_ibfk_1` FOREIGN KEY (`level`) REFERENCES `leveltower` (`level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
