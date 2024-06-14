USE Katio;

INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Gabriel', 'García Márquez', 'Colombia', '1940-03-03');
    

INSERT INTO Authors
    SET Name = 'Jorge', Lastname = 'Isaacs', Country = 'Colombia', Birthdate = '1836-04-01' 


INSERT INTO Authors
    VALUES ('Germán', 'Castro-Caycedo', 'Colombia', '1940-03-03');


INSERT INTO Books VALUES 
    (0, 'Cien años de soledad', '8420471836', '978-8420471839', '1967-06-05', 'RAE Obra Académica', 'Realismo Mágico', '800', 1),
    (0, 'Huellas', '9584277278', '978-958427275', '2019-01-01', '1ra edicion', 'Crónica', '800', 3),
    (0, 'María', '14802722922', '978-148027292', '1867-01-01', '1ra edicion', 'Romancticismo', '800', 2)


INSERT INTO Authors (Name, Lastname, Country, Birthdate)
    VALUES ('Silvia', 'Moreno Garcia', 'Mexico', '1981-04-25');
    
   INSERT INTO Books VALUES 
    (0, 'Mexico Gothic', '8420471836', '978-05256620785', '2020-06-30', 'Del Rey', 'Horror Gótico', '800', 4)


CREATE TABLE AudioBooks_Authors 
(
  Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
  audiobook_id INT UNSIGNED NOT NULL,
  author_id INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_audiobooks_id`
  	FOREIGN KEY (audiobook_id) REFERENCES Audiobooks (Id)
  	ON DELETE CASCADE 
  	ON UPDATE RESTRICT,
  CONSTRAINT `fk_authors_id`
  	FOREIGN KEY (author_id) REFERENCES Authors (ID)
  	ON DELETE CASCADE
  	ON UPDATE RESTRICT 
)

CREATE TABLE AudioBooks_Genre
  (
    Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
    audiobook_id INT UNSIGNED NOT NULL,
  	genre_id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_audiobook_id`
  	FOREIGN KEY (audiobook_id) REFERENCES Audiobooks (Id)
  	ON DELETE CASCADE 
  	ON UPDATE RESTRICT,
  CONSTRAINT `fk_genre_id`
  	FOREIGN KEY (genre_id) REFERENCES Genre (Id)
  	ON DELETE CASCADE
  	ON UPDATE RESTRICT
  )

   INSERT INTO Genre (Id, Name) VALUES
  (0, 'Fantasia Epica'),
  (0, 'Horror Gótico'),
  (0, 'Ciencia Ficción'),
  (0, 'Realismo Mágico'),
  (0, 'Crónica'),
  (0, 'Romancticismo');

   INSERT INTO AudioBooks_Genre (audiobook_id, genre_id) VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4)

    INSERT INTO AudioBooks_Authors (audiobook_id, author_id) VALUES 
	(9, 1),
    (9, 2),
    (9, 3),
    (9, 4),
    (9, 9),
    (9, 10)