DROP TABLE IF EXISTS users;
CREATE TABLE users(id serial PRIMARY KEY, username VARCHAR(255), password VARCHAR(255) , firstname VARCHAR(255) , lastname VARCHAR(255) , email VARCHAR(255) , createdata TIMESTAMP , lastenterdata TIMESTAMP , myrole VARCHAR(20));

DROP TABLE IF EXISTS dishes;
CREATE TABLE dishes(dishes_id serial PRIMARY KEY, name VARCHAR(255), weight integer , price integer, calories integer);

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient(ingredient_id serial PRIMARY KEY, name VARCHAR(255), weight integer , number integer , price integer, calories integer , dishes_id int not null, CONSTRAINT fk_dishes FOREIGN KEY(dishes_id) REFERENCES dishes(dishes_id));

DROP TABLE IF EXISTS faq;
CREATE TABLE faq(faq_id serial PRIMARY KEY, text_answer TEXT, text_request TEXT , theme VARCHAR(255));