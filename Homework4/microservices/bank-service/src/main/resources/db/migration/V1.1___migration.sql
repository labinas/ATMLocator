CREATE TABLE IF NOT EXISTS bank_info(
    id SERIAL PRIMARY KEY,
    bank VARCHAR(100),
    contact VARCHAR(20),
    number VARCHAR(20)
);

INSERT INTO bank_info(bank,contact, number)
VALUES ('Komercijalna Banka','02/3296-800','023296800');
INSERT INTO bank_info(bank,contact,number)
VALUES ('NLB Tutunska Banka','02/15-600','0215600');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Ohridska Banka','02/15-050','0215050');
INSERT INTO bank_info(bank,contact,number)
VALUES ('ProCredit Banka','02/2446-000','022446000');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Silk Road Banka','02/3251-900','023251900');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Stopanska Banka','02/3100-109','023100109');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Stopanska Banka - Bitola','02/3087-250','023087250');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Uni Banka','02/3111-111','023111111');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Halkbank','02/3296-330','023296330');
INSERT INTO bank_info(bank,contact,number)
VALUES ('Sparkasse Banka','02/15-050','0215050');