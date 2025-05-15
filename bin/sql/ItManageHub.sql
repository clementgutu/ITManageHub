drop database  if exists itmanagehub ;
create database itmanagehub ;
use itmanagehub;

CREATE TABLE user (
	iduser int(11) NOT NULL,
	nom varchar(50) NOT NULL,
	prenom varchar(50) NOT NULL,
	email varchar(255) NOT NULL,
	mdp varchar(255) NOT NULL,
	role varchar(50) NOT NULL
);

CREATE TABLE categorie (
    idcategorie INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE equipement (
    idequipement INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(150) NOT NULL,
    marque VARCHAR(100),
    modele VARCHAR(100),
    quantite INT DEFAULT 1,
    etat VARCHAR(50), -- Ex: neuf, utilisé, cassé
    emplacement VARCHAR(100),
    idcategorie INT, -- Lien vers la catégorie

    FOREIGN KEY (idcategorie) REFERENCES categorie(idcategorie)
);

CREATE TABLE incident (
    idincident INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT NOT NULL,
    date_signalement DATE DEFAULT CURRENT_DATE,
    statut VARCHAR(50) DEFAULT 'En attente', -- En attente / En cours / Résolu
    idequipement INT, -- Lien vers l'équipement concerné

    FOREIGN KEY (idequipement) REFERENCES equipement(idequipement)
);


INSERT INTO user (iduser, nom, prenom, email, mdp, role) VALUES (NULL, 'Fabien', 'Vincent', 'a@gmail.com', '123', 'Admin');
INSERT INTO user (iduser, nom, prenom, email, mdp, role) VALUES (NULL, 'JeanM', 'Anthony', 'b@gmail.com', '456', 'user');


