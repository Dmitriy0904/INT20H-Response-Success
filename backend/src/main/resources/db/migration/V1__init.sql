CREATE TABLE IF NOT EXISTS users (
    id          BIGSERIAL       PRIMARY KEY,
    email       VARCHAR(100)    NOT NULL UNIQUE,
    username    VARCHAR(50)     NOT NULL UNIQUE,
    password    VARCHAR(100)    NOT NULL,
    created_at  TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS auctions (
    id            BIGSERIAL     PRIMARY KEY,
    name          VARCHAR(100)  NOT NULL,
    description   TEXT          NOT NULL,
    user_id       BIGSERIAL     NOT NULL,
    photo_key     VARCHAR(100)  NOT NULL,
    status        VARCHAR(100)  NOT NULL,
    start_price   REAL          NOT NULL,
    actual_price  REAL          NOT NULL,
    created_at    TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS bids (
    id          BIGSERIAL   PRIMARY KEY,
    user_id     BIGSERIAL   NOT NULL,
    auction_id  BIGSERIAL   NOT NULL,
    amount      REAL        NOT NULL,
    time        TIMESTAMP   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (auction_id) REFERENCES auctions (id)
);