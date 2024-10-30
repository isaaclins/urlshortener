CREATE SCHEMA url_shortener;
USE url_shortener;
CREATE TABLE url (
                     id BIGINT PRIMARY KEY,
                     short_url VARCHAR(255) NOT NULL,
                     long_url VARCHAR(255) NOT NULL,
                     active BOOLEAN NOT NULL,
                     access_count INT NOT NULL,
                     password VARCHAR(255),
                     ip_adresses VARCHAR(255)
);