CREATE TABLE Url (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     originalUrl VARCHAR(255) NOT NULL,
                     shortUrl VARCHAR(255) NOT NULL,
                     active BOOLEAN NOT NULL
);

-- Example data
INSERT INTO Url (originalUrl, shortUrl, active) VALUES
                                                    ('https://www.example.com', 'exmpl', true),
                                                    ('https://www.anotherexample.com', 'anexmpl', true),
                                                    ('https://www.inactiveexample.com', 'inexmpl', false);