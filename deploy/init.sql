CREATE TABLE IF NOT EXISTS starships (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    class VARCHAR(255),
    captain VARCHAR(255),
    launched_year INT
);

INSERT INTO starships (name, class, captain, launched_year) VALUES
('USS Enterprise', 'Constitution', 'James T. Kirk', 2245),
('USS Voyager', 'Intrepid', 'Kathryn Janeway', 2371),
('USS Defiant', 'Defiant', 'Benjamin Sisko', 2370),
('USS Discovery', 'Crossfield', 'Gabriel Lorca', 2256),
('USS Enterprise-D', 'Galaxy', 'Jean-Luc Picard', 2363),
('USS Excelsior', 'Excelsior', 'Hikaru Sulu', 2285),
('USS Franklin', 'Freedom', 'Balthazar Edison', 2164),
('USS Shenzhou', 'Walker', 'Philippa Georgiou', 2255),
('USS Reliant', 'Miranda', 'Clark Terrell', 2285),
('USS Kelvin', 'Kelvin', 'Richard Robau', 2233);