CREATE TABLE IF NOT EXISTS atms(
    id SERIAL PRIMARY KEY,
    open_street_id BIGINT NOT NULL,
    lat NUMERIC NOT NULL,
    lon NUMERIC NOT NULL,
    amenity VARCHAR(10),
    int_name VARCHAR(255),
    name VARCHAR(255),
    name_en VARCHAR(255),
    operator VARCHAR(255),
    addr_city VARCHAR(255),
    addr_street VARCHAR(255),
    addr_housenumber VARCHAR(255),
    addr_postcode INT,
    opening_hours VARCHAR(10),
    wheelchair VARCHAR(10)
);

