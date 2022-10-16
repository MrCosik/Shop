CREATE TABLE final_order
(
    id     INTEGER PRIMARY KEY,
    name   VARCHAR,
    price  DOUBLE,
    copies DOUBLE
);

CREATE TABLE ordered_game
(
    id       INTEGER PRIMARY KEY,
    game_id  VARCHAR,
    order_id INTEGER,
    CONSTRAINT order_id FOREIGN KEY (order_id)
        REFERENCES final_order (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);