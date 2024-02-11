INSERT INTO users (email, username, password) values ('user1@gmail.com', 'user1', 'user1');
INSERT INTO users (email, username, password) values ('user2@gmail.com', 'user2', 'user2');
INSERT INTO users (email, username, password) values ('user3@gmail.com', 'user3', 'user3');

INSERT INTO auctions (name, description, users_id, status, start_price, actual_price, photo_url)
VALUES ('car',
        'This stunning 2020 Honda Civic EX boasts a low 25,000 miles and is in immaculate condition both inside and out. The powerful 2.0L engine paired with the smooth CVT transmission delivers a comfortable and fuel-efficient driving experience.',
        1, 'PENDING', 14000, 14000,
        'https://cdn.townweb.com/cityofmineralpoint.com/wp-content/uploads/2023/09/auction-2.jpg');
INSERT INTO auctions (name, description, users_id, status, start_price, actual_price, photo_url)
VALUES ('iPhone 13 Pro Max 256GB',
        'Own the latest technology without breaking the bank! This iPhone 13 Pro Max is in mint condition, like new, with no scratches, cracks, or blemishes. It boasts a powerful A15 Bionic chip, stunning camera system, and long-lasting battery with 85% health.',
        2, 'PENDING', 600, 600,
        'https://cdn.townweb.com/cityofmineralpoint.com/wp-content/uploads/2023/09/auction-2.jpg');
INSERT INTO auctions (name, description, users_id, status, start_price, actual_price, photo_url)
VALUES ('PS5',
        'Experience lightning-fast loading times, stunning visuals, and immersive audio with the revolutionary PlayStation 5 console. This bundle includes the original box, all factory packaging, and a DualSense wireless controller.',
        3, 'PENDING', 800, 800,
        'https://cdn.townweb.com/cityofmineralpoint.com/wp-content/uploads/2023/09/auction-2.jpg');