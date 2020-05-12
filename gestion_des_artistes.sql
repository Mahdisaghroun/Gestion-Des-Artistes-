CREATE DATABASE IF NOT EXISTS `gestion des artistes`;


use `gestion des artistes`;
DROP TABLE IF EXISTS `artiste`;

CREATE TABLE IF NOT EXISTS `artiste` (
  `user` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `DateNais` varchar(20) NOT NULL,
  `genre de musique` varchar(20) NOT NULL,
  `idspotify` varchar(50) NOT NULL,
  `idyoutube` varchar(50) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`user`)
) ;