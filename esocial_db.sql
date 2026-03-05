CREATE DATABASE IF NOT EXISTS esocial_db;
USE esocial_db;

CREATE TABLE IF NOT EXISTS employeurs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    raisonSociale VARCHAR(255),
    secteurActivite VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS employes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    salaireMensuel DOUBLE,
    employeur_id BIGINT,
    CONSTRAINT FK_employeur_employe FOREIGN KEY (employeur_id) REFERENCES employeurs(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS declarations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    annee INT NOT NULL,
    mois INT NOT NULL,
    dateDeclaration DATE,
    employeur_id BIGINT,
    CONSTRAINT FK_employeur_declaration FOREIGN KEY (employeur_id) REFERENCES employeurs(id)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS cotisations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    montantSalarial DOUBLE,
    montantPatronal DOUBLE,
    assure_id BIGINT,
    declaration_id BIGINT,
    CONSTRAINT FK_employe_cotisation FOREIGN KEY (employes_id) REFERENCES employes(id),
    CONSTRAINT FK_declaration_cotisation FOREIGN KEY (declaration_id) REFERENCES declarations(id)
) ENGINE=InnoDB;