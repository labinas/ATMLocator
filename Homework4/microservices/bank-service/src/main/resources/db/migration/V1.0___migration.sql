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
                                   addr_city_en VARCHAR(255),
                                   addr_street VARCHAR(255),
                                   addr_housenumber VARCHAR(255),
                                   addr_postcode VARCHAR(10),
                                   opening_hours VARCHAR(10),
                                   wheelchair VARCHAR(10),
                                   rating INTEGER
);

/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    310348494, 42.0036936, 21.3946845,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Булевар Партизански Одреди',
    '70b', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    386744780, 41.9921343, 21.4266335,
    'atm', 'Sparkasse', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе', '', '', 'Св. Кирил и Методиj', 'Ramstore',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    416411687, 42.0079825, 21.3842855,
    'atm', 'Uni Banka', 'Уни Банка', 'Uni Bank', 'Уни Банка',
    '', '', 'Разловечко востание', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    416411754, 42.0043009, 21.3847909,
    'atm', 'Uni Banka', 'Уни Банка', 'Uni Bank', 'Уни Банка',
    '', '', 'Његошева', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    416411856, 42.0058046, 21.4171593,
    'atm', 'Uni Banka', 'Уни Банка', 'Uni Bank', 'Уни Банка',
    '', '', 'Бул. Илинден - Зоолошка', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    443017395, 41.9967167, 21.4998343,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка',
    '', '', 'Жан Зорес', '6', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    459663482, 41.9966492, 21.4065094,
    'atm', '', '', '', '', '', '', 'Бул. Митрополит Теодосиј Гологанов', '74',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1475404512, 42.0069591, 21.3654634,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка', '', '', 'Ул. Ѓорче Петров', '7',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1475404520, 42.0074334, 21.3682759,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка', '', '', 'Ул. Ѓорче Петров', '1/4',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1475404532, 42.0075098, 21.3683049,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје', '', '', 'Ул. Ѓорче Петров', '1/1',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1615856817, 42.0031153, 21.3989023,
    'atm', 'Šparkase', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Бул. Партизански Одреди', '64б', 1000,
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1858888741, 41.9994538, 21.4257466,
    'atm', 'NLB Tutunska Banka', 'НЛБ Тутунка Банка', 'NLB Banka', 'НЛБ Тутунска Банка', '', '', 'Бул. Св. Климент Охридски', '', '',
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1858888742, 41.9995581, 21.4260824,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка', '', '', 'Бул. Св. Климент Охридски', '', '',
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1858888763, 41.9996412, 21.4259096,
    'atm', '', '', '', '', '', '', 'Бул. Св. Климент Охридски', '', '',
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2174953997, 41.9975122, 21.4837593,
    'atm', 'Halkbank', 'Халкбанк', 'Halkbank', 'Халкбанк', '', '', 'Перо Наков', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2335276909, 41.9937422, 21.417619,
    'atm', 'Šparkase', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Народен Фронт', '19', 1000,
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2335276914, 42.0064284, 21.3577339,
    'atm', 'Šparkase', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе', '', '', 'Ул. Ѓорче Петров', '33', '',
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2335304829, 42.0136404, 21.4452888,
    'atm', 'Šparkasse', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Булевар Цветан Димов',
    '', 1000, '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2520984629, 41.9976152, 21.4263503,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Булевар Партизански Одреди', '9', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2520984650, 41.9993708, 21.4259194,
    'atm', '', '', '', '', '', '', 'Бул. Св. Климент Охридски', '', '',
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    2980043658, 41.9908011, 21.4447857,
    'atm', 'Uni Banka', 'Уни Банка', 'Uni Bank', 'Уни Банка', '', '', 'Железничка Станица Скопје', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3026549093, 42.0030413, 21.4000421,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Бул. Партизански Одреди', '62 - Лептокарија', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3099334942, 41.9909328, 21.4455925,
    'atm', 'Halkbank', 'Халкбанк', 'Halkbank', 'Халкбанка', '', '',
    'Железничка Станица Скопје', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3101725359, 41.9989126, 21.435174,
    'atm', 'Šparkase', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе Банка Македонија АД Скопје',
    '', '', 'Казанџиска, Центар', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3101725378, 41.9993417, 21.4357789,
    'atm', 'ProCredit', 'Прокредит', 'ProCredit', 'Прокредит', '',
    '', 'Архиепископ Ангелариј', '2', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3101725382, 41.9937271, 21.4425083,
    'atm', 'Uni Banka', 'Уни Банка', 'Uni Banka', 'Уни Банка', '',
    '', 'Бул. Кузман Јосифовски Питу', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3103985010, 41.9953834, 21.4345612,
    'atm', 'NLB Tutunska banka', 'НЛБ Тутунска Банка',
    'NLB Tutunska banka', 'НЛБ Тутунска Банка', 'Cкoпje', 'Skopje', 'Кеј 13 Ноември',
    '', 1000, '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3437249685, 41.9953942, 21.431033,
    'atm', '', '', '', '', '', '', 'Македонија', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3497498228, 42.0139201, 21.4062413,
    'atm', 'Unibank', 'УНИ Банка', 'Unibank', 'УНИ Банка',
    '', '', 'Скупи', '1', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3497498229, 42.0139259, 21.4061361,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка АД Скопје',
    '', '', 'Скупи', '1', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3633126812, 41.9944722, 21.3959313,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Козле', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3633126813, 41.996706, 21.4050875,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Бул. Митрополит Теодосиј Гологанов', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3634182298, 42.0005737, 21.3916984,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка АД Скопје',
    '', '', 'Лондонска', '8', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3634182299, 42.0010817, 21.3900585,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка АД Скопје',
    '', '', 'Фармерски маркет - Тафталиџе', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3634182400, 42.001081, 21.3900911,
    'atm', 'NLB Tutunska Banka', 'НЛБ Тутунска Банка',
    'NLB Tutunska Banka', 'НЛБ - Тутунска Банка',
    '', '', 'Фармерски маркет - Тафталиџе', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3635130200, 42.0010181, 21.3900584,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Фармерски маркет - Тафталиџе', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3637351595, 41.9944772, 21.3959333,
    'atm', 'NLB Tutunska Banka', 'НЛБ Тутунска Банка',
    'NLB Tutunska Banka', 'НЛБ - Тутунска Банка',
    '', '', 'Козле', 'б.б.', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3673492606, 41.9951423, 21.4292834,
    'atm', 'Šparkase', 'Шпаркасе',
    'Sparkasse', 'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Никола Вапцаров',
    18, 1000, '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3673514709, 41.9757707, 21.443976,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Христо Татарчев', '43А', 1000,
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3673575643, 42.0045813, 21.3925292,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе Банка Македонија АД Скопје',
    '', '', 'Љублјанска', '4', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3674607001, 41.9849643, 21.4658037,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе Банка Македонија АД Скопје',
    'Cкoпje', 'Skopje', 'Бул. Јане Сандански', 'Бисер', 1000,
    '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3787600183, 41.9809158, 21.4405696,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Божидар Аџиа', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    3787622358, 41.981848, 21.4400507,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе Банка Македонија АД Скопје', '',
    '', 'Борис Трајковски', '36', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4059895433, 41.9938379, 21.4171609,
    'atm', 'Ohridska Banka', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Народен фронт', '19', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4149490303, 41.9983327, 21.3924412,
    'atm', '', 'НЛБ Тутунска Банка', 'NLB Tutunska Banka', 'НЛБ Тутунска Банка',
    '', '', 'Лондонска', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4169882189, 41.9920274, 21.4295739,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе', '', '', 'Македонија',
    '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4169893239, 41.9939123, 21.4009084,
    'atm', '', 'Шпаркасе', 'Sparkasse',
    'Шпаркасе', '', '', 'Козле',
    53, '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4197577689, 41.9847345, 21.4549624,
    'atm', '', '', '', '', '', '', 'Вангел Тодоровски', '7',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4225448690, 42.015202, 21.399685,
    'atm', '', 'НЛБ Тутунска Банка', 'NLB Tutunska Banka', 'NLB Tutunska Banka',
    '', '', 'Макпетрол Темко, Скупи', '8', '', '24/7', 'yes'
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4234366920, 42.0137911, 21.4039823,
    'atm', '', 'Стопанска Банка АД - Битола', 'Stopanska Banka AD Bitola', 'Стопанска Банка АД - Битола',
    '', '', 'Скупи', '', '', '24/7', 'yes'
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4359835489, 41.9909851, 21.4456144,
    'atm', 'Komercijalna Banka', 'Комерцијална Банка',
    'Komercijalna Banka', 'Комерцијална Банка АД Скопје', '', '', 'Железничка Станица Скопје',
    '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4594432368, 41.9957551, 21.4333409,
    'atm', 'Stopanska Banka', 'Стопанска Банка',
    'Stopanska Banka', 'Стопанска Банка АД - Скопје',
    '', '', 'Кеј 13 Ноември', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    4938101522, 41.9917059, 21.4378292,
    'atm', '','Шпаркасе', 'Sparkasse',
    'Шпаркасе', '', '', 'Булевар Кочо Рацин',
    '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    5055455127, 41.9868165, 21.431026,
    'atm', '', '', '', '', '', '', 'Ул. Павел Шатев', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    5759411265, 41.9931833, 21.4664512,
    'atm', 'NLB Tutunska Banka', 'НЛБ Банка', 'NLB Tutunska Banka', 'НЛБ Банка', '', '', 'Бул. АСНОМ', '1',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    5798860601, 41.939374, 21.516183,
    'atm', 'NLB Tutunska Banka', 'НЛБ Банка', 'NLB Tutunska Banka', 'НЛБ Банка',
    '', '', 'Иван Хаџиников', '75b', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6030006585, 41.9974347, 21.4344946,
    'atm', 'Halkbank', 'Халкбанка', 'Halkbank', 'Halkbank', '', '',
    'Кеј Димитар Влахов', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6030006586, 41.9952698, 21.4328457,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', '11 Октомври', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6054036214, 41.9994044, 21.4200771,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Бул. Партизански Одреди', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6354850987, 41.994836, 21.4368673,
    'atm', '', '', '', '', '', '', 'Кеј 13 Ноември', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6414108786, 42.0072333, 21.4425529,
    'atm', '', '', '', '', '', '', 'Цветан Димов', '21',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6419704785, 42.0056394, 21.4270178,
    'atm', '', '', '', '', '', '', 'Центар', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6440573589, 42.0057289, 21.4270947,
    'atm', '', '', '', '', '', '', 'Центар', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    6913357686, 42.0246861, 21.4294091,
    'atm', '', '', '', '', '', '', 'Македонско Косовска Бригада', '',
    '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133065638, 42.0065804, 21.3597505,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Мице Козар', '1', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133065639, 42.0067318, 21.3570683,
    'atm', '', 'Стопанска Банка', 'Stopanska Banka', 'Стопанска Банка',
    '', '', 'Ул. Ѓорче Петров', 'б.б', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133065640, 42.0065931, 21.359169,
    'atm', '', 'Халкбанка', 'Halkbank', 'Халкбанка',
    '', '', 'Ул. Ѓорче Петров', '38', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133065642, 42.0067621, 21.3575725,
    'atm', '', 'Уни Банка', 'Uni Banka', 'Уни Банка',
    '', '', 'Ул. Ѓорче Петров', '50', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133321080, 42.0032539, 21.3746296,
    'atm', '', '', '', '', '', '', 'Ангел Динев',
    1, '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133424007, 41.9972771, 21.4087112,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Анкарска', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133436089, 41.9992882, 21.4185028,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Рајко Жинзифов', '18', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133438548, 41.9984598, 21.4252244,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Партизански Одреди', '14', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133445813, 41.9970916, 21.4297565,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Орце Николов', '54', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7133445908, 41.9952018, 21.4323164,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', '11 Октомври', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136180065, 41.9837158, 21.4701949,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Бул. Јане Сандански', '113', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136180066, 41.9838577, 21.4699015,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска банка',
    '', '', 'Бул. Јане Сандански', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136505913, 42.0033653, 21.3967495,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Бул. Партизански Одреди', '102г', '', '24//7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136914205, 42.0025929, 21.4616683,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Ул. 1632', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136914208, 42.0026662, 21.4617348,
    'atm', '', 'Силк Роуд Банка', 'Silk Road Banka', 'Силк Роуд Банка',
    '', '', 'Ул. 1632', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136947040, 42.0057143, 21.3119917,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Ул. 1723', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7136956046, 41.9844079, 21.4837986,
    'atm', '', 'Шпаркасе', 'Sparkasse', 'Шпаркасе',
    '', '', 'Февруарски Поход', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137056772, 42.0038552, 21.4618738,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Трифун Хаџијанев', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137063836, 42.0134867, 21.442704,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Џон Кенеди', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137078903, 41.9937895, 21.427607,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридска Банка',
    '', '', 'Даме Груев', '3', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137091823, 42.0024787, 21.3974984,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Бул. Партизански Одреди', '101', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137106710, 41.9916024, 21.4341214,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', '11 Октомври', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7137143985, 41.988115, 21.4550178,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Бул. Јане Сандански', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138812609, 41.9941588, 21.430463,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Македонија', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138828587, 41.9844901, 21.4838556,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Февруарски поход', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138849110, 41.995781, 21.5008435,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Пошта Маџари', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138855081, 41.9928708, 21.4414426,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Бул. Кузман Јосифовски Питу', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138883012, 41.9771994, 21.4438029,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Народни Херои', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7138995761, 42.0045231, 21.3925052,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Љублјанска', '4', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7139002051, 41.9941475, 21.5432393,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Ул. 34', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7139048848, 41.9392781, 21.5159734,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Зелено пазарче Драчево', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7139048849, 41.9391212, 21.5156427,
    'atm', '', 'Комерцијална Банка', 'Komercijalna Banka', 'Комерцијална банка',
    '', '', 'Зелено пазарче Драчево', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7139054635, 42.0028088, 21.4079598,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Бранислав Нушиќ', '', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    7139055367, 42.0072387, 21.3745188,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Бул. Партизански Одреди', '130', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    8187485902, 41.9977389, 21.4293567,
    'atm', '', 'Охридска Банка', 'Ohridska Banka', 'Охридкса Банка',
    '', '', 'Орце Николов', '54', '', '24/7', ''
);
/* INSERT QUERY */
INSERT INTO atms(
    open_street_id, lat, lon, amenity,
    int_name, name, name_en, operator,
    addr_city, addr_city_en, addr_street,
    addr_housenumber, addr_postcode,
    opening_hours, wheelchair
)
VALUES
(
    1000000000000000, 41.999506, 21.4259145,
    'atm', '', 'Фероинвест',
    '', 'НЛБ - Тутунска Банка',
    'Cкoпje', 'Skopje', 'Булевар Климент Охридски',
    30, 1000, '24/7', ''
);

