CREATE TABLE IF NOT EXISTS app_users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(25),
    password VARCHAR(255),
    email VARCHAR(100),
    account_role VARCHAR(10)
);

INSERT INTO app_users(username,password,email,account_role)
VALUES ('admin', '$2a$12$2Lt7WcnqRSpQZiHnGYGKAuKZceI/d.mpWpCeNLtRUCbN5xpwc5tbi', 'admin@test.com', 'ROLE_ADMIN');

INSERT INTO app_users(username,password,email,account_role)
VALUES ('user', '$2a$12$A1pCyay8WsFbuczsePFxFui3kjeC8QNHZo5Xoz6UoCG/hyOPwRcMq', 'user@test.com', 'ROLE_USER');

