DROP TABLE IF EXISTS PRICES;

CREATE TABLE PRICES (
    ID integer AUTO_INCREMENT PRIMARY KEY,
    brand_id integer NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price_list integer NOT NULL,
    product_id integer NOT NULL,
    priority integer NOT NULL,
    price DOUBLE  NOT NULL,
    curr VARCHAR(4) NOT NULL
);
