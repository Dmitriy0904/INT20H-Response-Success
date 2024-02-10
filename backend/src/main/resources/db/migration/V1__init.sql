CREATE TABLE IF NOT EXISTS users (
    id          BIGSERIAL       PRIMARY KEY,
    email       VARCHAR(100)    NOT NULL UNIQUE,
    username    VARCHAR(50)     NOT NULL UNIQUE,
    password    VARCHAR(100)    NOT NULL
);

CREATE TABLE IF NOT EXISTS auctions (
    id            BIGSERIAL     PRIMARY KEY,
    name          VARCHAR(255)  NOT NULL,
    description   VARCHAR(255)  NOT NULL,
    users_id      BIGSERIAL     NOT NULL,
    photo_url     VARCHAR(255)  NOT NULL,
    status        VARCHAR(100)  NOT NULL,
    start_price   REAL          NOT NULL,
    actual_price  REAL          NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS bids (
    id              BIGSERIAL   PRIMARY KEY,
    users_id        BIGSERIAL   NOT NULL,
    auction_id      BIGSERIAL   NOT NULL,
    amount          REAL        NOT NULL,
    created_date    BIGINT      NOT NULL,
    FOREIGN KEY (users_id) REFERENCES users (id),
    FOREIGN KEY (auction_id) REFERENCES auctions (id)
);