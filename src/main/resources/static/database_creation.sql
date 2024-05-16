-- MariaDB
CREATE DATABASE Katio
COLLATE = `uca1400_spanish_ai_ci`; 
-- Accent Insensitive Case Insensitive

Use Katio;

CREATE TABLE Users
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    Lastname NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    Phone NVARCHAR(20) NOT NULL,
    Identification NVARCHAR(20) NOT NULL,
    Passhash NVARCHAR(255) NOT NULL,
    INDEX email_idx(Email)
);

CREATE TABLE Authors
(
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    Lastname NVARCHAR(255) NOT NULL,
    Country NVARCHAR(255) NOT NULL,
    Birthdate DATE NOT NULL,
    INDEX apellido_ix(Lastname)
);

CREATE TABLE Books
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    ISBN10 NVARCHAR(255) NOT NULL,
    ISBN13 NVARCHAR(255) NOT NULL,
    Published DATE NOT NULL,
    Edition NVARCHAR(255) NOT NULL,
    Genre NVARCHAR(255) NOT NULL,
    Dewey_Index INT UNSIGNED NOT NULL,
    Author_Id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_book_author`
        FOREIGN KEY (Author_Id) REFERENCES Authors (Id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE Audiobooks
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    ISBN10 NVARCHAR(255) NOT NULL,
    ISBN13 NVARCHAR(255) NOT NULL,
    Published DATE NOT NULL,
    Edition NVARCHAR(255) NOT NULL,
    Genre NVARCHAR(255) NOT NULL,
    Abridged BIT NOT NULL,
    LengthInSeconds INT UNSIGNED NOT NULL,
    Path NVARCHAR(255) NOT NULL,
    Author_Id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_audiobooks_author`
        FOREIGN KEY (Author_Id) REFERENCES Authors(Id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE Narrator 
(
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    LastName NVARCHAR(255) NOT NULL,
    Genre NVARCHAR(255) NOT NULL,
    Languajes NVARCHAR(255) NOT NULL,
);