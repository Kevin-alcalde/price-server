CREATE SCHEMA IF NOT EXISTS products;
SET SCHEMA products;

CREATE TABLE price(
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list INT NOT NULL,
    product_id INT NOT NULL,
    priority INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    curr CHAR(3) NOT NULL
);